package com.diviso.graeshoppe.order.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Order.
 */
@Entity
@Table(name = "jhi_order")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "store_id")
    private String storeId;

    @Column(name = "jhi_date")
    private Instant date;

    @Column(name = "grand_total")
    private Double grandTotal;

    @Column(name = "payment_ref")
    private String paymentRef;

    @Column(name = "allergy_note")
    private String allergyNote;

    @Column(name = "pre_order_date")
    private Instant preOrderDate;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(unique = true)
    private DeliveryInfo deliveryInfo;

    @OneToOne
    @JoinColumn(unique = true)
    private ApprovalDetails approvalDetails;

    @OneToMany(mappedBy = "order")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<OrderLine> orderLines = new HashSet<>();
    @OneToMany(mappedBy = "order")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Offer> appliedOffers = new HashSet<>();
    @ManyToOne
    @JsonIgnoreProperties("orders")
    private Status status;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public Order orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Order customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStoreId() {
        return storeId;
    }

    public Order storeId(String storeId) {
        this.storeId = storeId;
        return this;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Instant getDate() {
        return date;
    }

    public Order date(Instant date) {
        this.date = date;
        return this;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public Order grandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
        return this;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getPaymentRef() {
        return paymentRef;
    }

    public Order paymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
        return this;
    }

    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }

    public String getAllergyNote() {
        return allergyNote;
    }

    public Order allergyNote(String allergyNote) {
        this.allergyNote = allergyNote;
        return this;
    }

    public void setAllergyNote(String allergyNote) {
        this.allergyNote = allergyNote;
    }

    public Instant getPreOrderDate() {
        return preOrderDate;
    }

    public Order preOrderDate(Instant preOrderDate) {
        this.preOrderDate = preOrderDate;
        return this;
    }

    public void setPreOrderDate(Instant preOrderDate) {
        this.preOrderDate = preOrderDate;
    }

    public String getEmail() {
        return email;
    }

    public Order email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public Order deliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
        return this;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public ApprovalDetails getApprovalDetails() {
        return approvalDetails;
    }

    public Order approvalDetails(ApprovalDetails approvalDetails) {
        this.approvalDetails = approvalDetails;
        return this;
    }

    public void setApprovalDetails(ApprovalDetails approvalDetails) {
        this.approvalDetails = approvalDetails;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Order orderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
        return this;
    }

    public Order addOrderLines(OrderLine orderLine) {
        this.orderLines.add(orderLine);
        orderLine.setOrder(this);
        return this;
    }

    public Order removeOrderLines(OrderLine orderLine) {
        this.orderLines.remove(orderLine);
        orderLine.setOrder(null);
        return this;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Set<Offer> getAppliedOffers() {
        return appliedOffers;
    }

    public Order appliedOffers(Set<Offer> offers) {
        this.appliedOffers = offers;
        return this;
    }

    public Order addAppliedOffers(Offer offer) {
        this.appliedOffers.add(offer);
        offer.setOrder(this);
        return this;
    }

    public Order removeAppliedOffers(Offer offer) {
        this.appliedOffers.remove(offer);
        offer.setOrder(null);
        return this;
    }

    public void setAppliedOffers(Set<Offer> offers) {
        this.appliedOffers = offers;
    }

    public Status getStatus() {
        return status;
    }

    public Order status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        if (order.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + getId() +
            ", orderId='" + getOrderId() + "'" +
            ", customerId='" + getCustomerId() + "'" +
            ", storeId='" + getStoreId() + "'" +
            ", date='" + getDate() + "'" +
            ", grandTotal=" + getGrandTotal() +
            ", paymentRef='" + getPaymentRef() + "'" +
            ", allergyNote='" + getAllergyNote() + "'" +
            ", preOrderDate='" + getPreOrderDate() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
}
