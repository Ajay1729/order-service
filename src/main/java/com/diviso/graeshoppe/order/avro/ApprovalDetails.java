/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.diviso.graeshoppe.order.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ApprovalDetails extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2827081206392041729L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ApprovalDetails\",\"namespace\":\"com.diviso.graeshoppe.order.avro\",\"fields\":[{\"name\":\"acceptedAt\",\"type\":\"long\",\"default\":0,\"logicalType\":\"date\"},{\"name\":\"expectedDelivery\",\"type\":[\"null\",\"long\"],\"default\":null,\"logicalType\":\"date\"},{\"name\":\"decision\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ApprovalDetails> ENCODER =
      new BinaryMessageEncoder<ApprovalDetails>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ApprovalDetails> DECODER =
      new BinaryMessageDecoder<ApprovalDetails>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<ApprovalDetails> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<ApprovalDetails> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ApprovalDetails>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this ApprovalDetails to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a ApprovalDetails from a ByteBuffer. */
  public static ApprovalDetails fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long acceptedAt;
  @Deprecated public java.lang.Long expectedDelivery;
  @Deprecated public java.lang.String decision;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ApprovalDetails() {}

  /**
   * All-args constructor.
   * @param acceptedAt The new value for acceptedAt
   * @param expectedDelivery The new value for expectedDelivery
   * @param decision The new value for decision
   */
  public ApprovalDetails(java.lang.Long acceptedAt, java.lang.Long expectedDelivery, java.lang.String decision) {
    this.acceptedAt = acceptedAt;
    this.expectedDelivery = expectedDelivery;
    this.decision = decision;
  }

  @Override
public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  @Override
public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return acceptedAt;
    case 1: return expectedDelivery;
    case 2: return decision;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
@SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: acceptedAt = (java.lang.Long)value$; break;
    case 1: expectedDelivery = (java.lang.Long)value$; break;
    case 2: decision = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'acceptedAt' field.
   * @return The value of the 'acceptedAt' field.
   */
  public java.lang.Long getAcceptedAt() {
    return acceptedAt;
  }

  /**
   * Sets the value of the 'acceptedAt' field.
   * @param value the value to set.
   */
  public void setAcceptedAt(java.lang.Long value) {
    this.acceptedAt = value;
  }

  /**
   * Gets the value of the 'expectedDelivery' field.
   * @return The value of the 'expectedDelivery' field.
   */
  public java.lang.Long getExpectedDelivery() {
    return expectedDelivery;
  }

  /**
   * Sets the value of the 'expectedDelivery' field.
   * @param value the value to set.
   */
  public void setExpectedDelivery(java.lang.Long value) {
    this.expectedDelivery = value;
  }

  /**
   * Gets the value of the 'decision' field.
   * @return The value of the 'decision' field.
   */
  public java.lang.String getDecision() {
    return decision;
  }

  /**
   * Sets the value of the 'decision' field.
   * @param value the value to set.
   */
  public void setDecision(java.lang.String value) {
    this.decision = value;
  }

  /**
   * Creates a new ApprovalDetails RecordBuilder.
   * @return A new ApprovalDetails RecordBuilder
   */
  public static com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder newBuilder() {
    return new com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder();
  }

  /**
   * Creates a new ApprovalDetails RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ApprovalDetails RecordBuilder
   */
  public static com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder newBuilder(com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder other) {
    return new com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder(other);
  }

  /**
   * Creates a new ApprovalDetails RecordBuilder by copying an existing ApprovalDetails instance.
   * @param other The existing instance to copy.
   * @return A new ApprovalDetails RecordBuilder
   */
  public static com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder newBuilder(com.diviso.graeshoppe.order.avro.ApprovalDetails other) {
    return new com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder(other);
  }

  /**
   * RecordBuilder for ApprovalDetails instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ApprovalDetails>
    implements org.apache.avro.data.RecordBuilder<ApprovalDetails> {

    private long acceptedAt;
    private java.lang.Long expectedDelivery;
    private java.lang.String decision;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.acceptedAt)) {
        this.acceptedAt = data().deepCopy(fields()[0].schema(), other.acceptedAt);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.expectedDelivery)) {
        this.expectedDelivery = data().deepCopy(fields()[1].schema(), other.expectedDelivery);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.decision)) {
        this.decision = data().deepCopy(fields()[2].schema(), other.decision);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ApprovalDetails instance
     * @param other The existing instance to copy.
     */
    private Builder(com.diviso.graeshoppe.order.avro.ApprovalDetails other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.acceptedAt)) {
        this.acceptedAt = data().deepCopy(fields()[0].schema(), other.acceptedAt);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.expectedDelivery)) {
        this.expectedDelivery = data().deepCopy(fields()[1].schema(), other.expectedDelivery);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.decision)) {
        this.decision = data().deepCopy(fields()[2].schema(), other.decision);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'acceptedAt' field.
      * @return The value.
      */
    public java.lang.Long getAcceptedAt() {
      return acceptedAt;
    }

    /**
      * Sets the value of the 'acceptedAt' field.
      * @param value The value of 'acceptedAt'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder setAcceptedAt(long value) {
      validate(fields()[0], value);
      this.acceptedAt = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'acceptedAt' field has been set.
      * @return True if the 'acceptedAt' field has been set, false otherwise.
      */
    public boolean hasAcceptedAt() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'acceptedAt' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder clearAcceptedAt() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'expectedDelivery' field.
      * @return The value.
      */
    public java.lang.Long getExpectedDelivery() {
      return expectedDelivery;
    }

    /**
      * Sets the value of the 'expectedDelivery' field.
      * @param value The value of 'expectedDelivery'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder setExpectedDelivery(java.lang.Long value) {
      validate(fields()[1], value);
      this.expectedDelivery = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'expectedDelivery' field has been set.
      * @return True if the 'expectedDelivery' field has been set, false otherwise.
      */
    public boolean hasExpectedDelivery() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'expectedDelivery' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder clearExpectedDelivery() {
      expectedDelivery = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'decision' field.
      * @return The value.
      */
    public java.lang.String getDecision() {
      return decision;
    }

    /**
      * Sets the value of the 'decision' field.
      * @param value The value of 'decision'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder setDecision(java.lang.String value) {
      validate(fields()[2], value);
      this.decision = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'decision' field has been set.
      * @return True if the 'decision' field has been set, false otherwise.
      */
    public boolean hasDecision() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'decision' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.order.avro.ApprovalDetails.Builder clearDecision() {
      decision = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ApprovalDetails build() {
      try {
        ApprovalDetails record = new ApprovalDetails();
        record.acceptedAt = fieldSetFlags()[0] ? this.acceptedAt : (java.lang.Long) defaultValue(fields()[0]);
        record.expectedDelivery = fieldSetFlags()[1] ? this.expectedDelivery : (java.lang.Long) defaultValue(fields()[1]);
        record.decision = fieldSetFlags()[2] ? this.decision : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ApprovalDetails>
    WRITER$ = MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ApprovalDetails>
    READER$ = MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}