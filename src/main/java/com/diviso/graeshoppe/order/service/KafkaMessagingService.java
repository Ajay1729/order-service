package com.diviso.graeshoppe.order.service;

import com.diviso.graeshoppe.notification.avro.Notification;
import com.diviso.graeshoppe.order.avro.Order;
import com.diviso.graeshoppe.order.avro.Payment;

import com.diviso.graeshoppe.order.config.KafkaProperties;
import com.diviso.graeshoppe.order.service.dto.OrderDTO;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class KafkaMessagingService {

	private final Logger log = LoggerFactory.getLogger(KafkaMessagingService.class);

	@Value("${topic.order.destination}")
	private String orderTopic;
	@Value("${topic.payment.destination}")
	private String paymentTopic;

	@Autowired
	private OrderCommandService orderCommandService;
	@Value("${topic.notification.destination}")
	private String notificationTopic;
	private final KafkaProperties kafkaProperties;
	private KafkaProducer<String, Order> orderProducer;
	private KafkaProducer<String, Notification> notificatonProducer;
	KafkaConsumer<String, Payment> paymentConsumer ;
	//private ExecutorService sseExecutorService = Executors.newCachedThreadPool();
	private final AtomicBoolean closed = new AtomicBoolean(false);

	public KafkaMessagingService(KafkaProperties kafkaProperties) {
		this.kafkaProperties = kafkaProperties;
		this.orderProducer = new KafkaProducer<>(kafkaProperties.getProducerProps());
		this.notificatonProducer = new KafkaProducer<>(kafkaProperties.getProducerProps());
		this.start();
	}

	public PublishResult publishOrder(Order message) throws ExecutionException, InterruptedException {
		RecordMetadata metadata = orderProducer.send(new ProducerRecord<>(orderTopic, message)).get();
		return new PublishResult(metadata.topic(), metadata.partition(), metadata.offset(),
				Instant.ofEpochMilli(metadata.timestamp()));
	}

	public PublishResult publishNotification(Notification message) throws ExecutionException, InterruptedException {
		RecordMetadata metadata = notificatonProducer.send(new ProducerRecord<>(notificationTopic, message)).get();
		return new PublishResult(metadata.topic(), metadata.partition(), metadata.offset(),
				Instant.ofEpochMilli(metadata.timestamp()));
	}

	public void start() {
		log.info("Kafka consumer starting notification...");
		this.paymentConsumer = new KafkaConsumer<>(kafkaProperties.getConsumerProps());
		Runtime.getRuntime().addShutdownHook(new Thread(this::shutdown));

		Thread consumerThread = new Thread(() -> {
			try {
				paymentConsumer.subscribe(Collections.singletonList(paymentTopic));
				log.info("Kafka consumer started");
				while (!closed.get()) {
					ConsumerRecords<String, Payment> records = paymentConsumer.poll(Duration.ofSeconds(3));
					records.forEach(record -> {
						log.info("Record payment consumed is $$$ " + record.value());
						System.out.println("++++++++++++++++++++++++++++++++++++++++++");
						Optional<OrderDTO> orderDTO = orderCommandService.findByOrderID(record.value().getTargetId());
						System.out.println("++++++++++++++++++++++++++++++++++++++");
						System.out.println("Value findByOrderId "+ orderDTO.get());
						if(orderDTO.isPresent()) {
							orderDTO.get().setPaymentMode(record.value().getPaymentType().toUpperCase());
							orderDTO.get().setPaymentRef(record.value().getId().toString());
							// in order to set the status need to check the order flow if advanced flow this works
							orderDTO.get().setStatusId(6l); //payment-processed-unapproved
							orderCommandService.update(orderDTO.get());
							log.info("Order updated with payment ref");
						}
					});
				}
				paymentConsumer.commitSync();
			} catch (WakeupException e) {
				if (!closed.get())
					throw e;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			} finally {
				paymentConsumer.close();
			}
		});
		consumerThread.start();
	}
	
	/*
	 * public void subscribePayment() {
	 * 
	 * Map<String, Object> consumerProps = kafkaProperties.getConsumerProps();
	 * log.info("Kafka consumer starting Payment..."); Thread consumerThread = new
	 * Thread(() -> { consumer.subscribe(Collections.singletonList(paymentTopic));
	 * boolean exitLoop = false; while (!exitLoop) { try { ConsumerRecords<String,
	 * Payment> records = consumer.poll(Duration.ofSeconds(3));
	 * records.forEach(record -> { log.info("Record payment consumed is $$$ " +
	 * record.value());
	 * System.out.println("++++++++++++++++++++++++++++++++++++++++++");
	 * Optional<OrderDTO> orderDTO =
	 * orderCommandService.findByOrderID(record.value().getTargetId());
	 * System.out.println("++++++++++++++++++++++++++++++++++++++");
	 * System.out.println("Value findByOrderId "+ orderDTO.get());
	 * if(orderDTO.isPresent()) {
	 * orderDTO.get().setPaymentMode(record.value().getPaymentType().toUpperCase());
	 * orderDTO.get().setPaymentRef(record.value().getId().toString()); // in order
	 * to set the status need to check the order flow if advanced flow this works
	 * orderDTO.get().setStatusId(6l); //payment-processed-unapproved
	 * orderCommandService.update(orderDTO.get());
	 * log.info("Order updated with payment ref"); }
	 * 
	 * }); } catch (Exception ex) { log.trace("Complete with error {}",
	 * ex.getMessage(), ex); exitLoop = true; } } consumer.close(); });
	 * 
	 * consumerThread.start(); }
	 */
	public void shutdown() {
		log.info("Shutdown Kafka consumer");
		closed.set(true);
		paymentConsumer.wakeup();
	}
	public static class PublishResult {
		public final String topic;
		public final int partition;
		public final long offset;
		public final Instant timestamp;

		private PublishResult(String topic, int partition, long offset, Instant timestamp) {
			this.topic = topic;
			this.partition = partition;
			this.offset = offset;
			this.timestamp = timestamp;
		}
	}
}