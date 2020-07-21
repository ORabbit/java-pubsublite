// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/pubsublite/v1/cursor.proto

package com.google.cloud.pubsublite.proto;

/**
 *
 *
 * <pre>
 * A pair of a Cursor and the partition it is for.
 * </pre>
 *
 * Protobuf type {@code google.cloud.pubsublite.v1.PartitionCursor}
 */
public final class PartitionCursor extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.cloud.pubsublite.v1.PartitionCursor)
    PartitionCursorOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use PartitionCursor.newBuilder() to construct.
  private PartitionCursor(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private PartitionCursor() {}

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new PartitionCursor();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private PartitionCursor(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8:
            {
              partition_ = input.readInt64();
              break;
            }
          case 18:
            {
              com.google.cloud.pubsublite.proto.Cursor.Builder subBuilder = null;
              if (cursor_ != null) {
                subBuilder = cursor_.toBuilder();
              }
              cursor_ =
                  input.readMessage(
                      com.google.cloud.pubsublite.proto.Cursor.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(cursor_);
                cursor_ = subBuilder.buildPartial();
              }

              break;
            }
          default:
            {
              if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.cloud.pubsublite.proto.CursorProto
        .internal_static_google_cloud_pubsublite_v1_PartitionCursor_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.pubsublite.proto.CursorProto
        .internal_static_google_cloud_pubsublite_v1_PartitionCursor_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.pubsublite.proto.PartitionCursor.class,
            com.google.cloud.pubsublite.proto.PartitionCursor.Builder.class);
  }

  public static final int PARTITION_FIELD_NUMBER = 1;
  private long partition_;
  /**
   *
   *
   * <pre>
   * The partition this is for.
   * </pre>
   *
   * <code>int64 partition = 1;</code>
   *
   * @return The partition.
   */
  @java.lang.Override
  public long getPartition() {
    return partition_;
  }

  public static final int CURSOR_FIELD_NUMBER = 2;
  private com.google.cloud.pubsublite.proto.Cursor cursor_;
  /**
   *
   *
   * <pre>
   * The value of the cursor.
   * </pre>
   *
   * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
   *
   * @return Whether the cursor field is set.
   */
  @java.lang.Override
  public boolean hasCursor() {
    return cursor_ != null;
  }
  /**
   *
   *
   * <pre>
   * The value of the cursor.
   * </pre>
   *
   * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
   *
   * @return The cursor.
   */
  @java.lang.Override
  public com.google.cloud.pubsublite.proto.Cursor getCursor() {
    return cursor_ == null
        ? com.google.cloud.pubsublite.proto.Cursor.getDefaultInstance()
        : cursor_;
  }
  /**
   *
   *
   * <pre>
   * The value of the cursor.
   * </pre>
   *
   * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
   */
  @java.lang.Override
  public com.google.cloud.pubsublite.proto.CursorOrBuilder getCursorOrBuilder() {
    return getCursor();
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (partition_ != 0L) {
      output.writeInt64(1, partition_);
    }
    if (cursor_ != null) {
      output.writeMessage(2, getCursor());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (partition_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, partition_);
    }
    if (cursor_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getCursor());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.cloud.pubsublite.proto.PartitionCursor)) {
      return super.equals(obj);
    }
    com.google.cloud.pubsublite.proto.PartitionCursor other =
        (com.google.cloud.pubsublite.proto.PartitionCursor) obj;

    if (getPartition() != other.getPartition()) return false;
    if (hasCursor() != other.hasCursor()) return false;
    if (hasCursor()) {
      if (!getCursor().equals(other.getCursor())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PARTITION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getPartition());
    if (hasCursor()) {
      hash = (37 * hash) + CURSOR_FIELD_NUMBER;
      hash = (53 * hash) + getCursor().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.cloud.pubsublite.proto.PartitionCursor prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * A pair of a Cursor and the partition it is for.
   * </pre>
   *
   * Protobuf type {@code google.cloud.pubsublite.v1.PartitionCursor}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.cloud.pubsublite.v1.PartitionCursor)
      com.google.cloud.pubsublite.proto.PartitionCursorOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.cloud.pubsublite.proto.CursorProto
          .internal_static_google_cloud_pubsublite_v1_PartitionCursor_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.pubsublite.proto.CursorProto
          .internal_static_google_cloud_pubsublite_v1_PartitionCursor_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.pubsublite.proto.PartitionCursor.class,
              com.google.cloud.pubsublite.proto.PartitionCursor.Builder.class);
    }

    // Construct using com.google.cloud.pubsublite.proto.PartitionCursor.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      partition_ = 0L;

      if (cursorBuilder_ == null) {
        cursor_ = null;
      } else {
        cursor_ = null;
        cursorBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.cloud.pubsublite.proto.CursorProto
          .internal_static_google_cloud_pubsublite_v1_PartitionCursor_descriptor;
    }

    @java.lang.Override
    public com.google.cloud.pubsublite.proto.PartitionCursor getDefaultInstanceForType() {
      return com.google.cloud.pubsublite.proto.PartitionCursor.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.cloud.pubsublite.proto.PartitionCursor build() {
      com.google.cloud.pubsublite.proto.PartitionCursor result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.cloud.pubsublite.proto.PartitionCursor buildPartial() {
      com.google.cloud.pubsublite.proto.PartitionCursor result =
          new com.google.cloud.pubsublite.proto.PartitionCursor(this);
      result.partition_ = partition_;
      if (cursorBuilder_ == null) {
        result.cursor_ = cursor_;
      } else {
        result.cursor_ = cursorBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.cloud.pubsublite.proto.PartitionCursor) {
        return mergeFrom((com.google.cloud.pubsublite.proto.PartitionCursor) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.cloud.pubsublite.proto.PartitionCursor other) {
      if (other == com.google.cloud.pubsublite.proto.PartitionCursor.getDefaultInstance())
        return this;
      if (other.getPartition() != 0L) {
        setPartition(other.getPartition());
      }
      if (other.hasCursor()) {
        mergeCursor(other.getCursor());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.cloud.pubsublite.proto.PartitionCursor parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.google.cloud.pubsublite.proto.PartitionCursor) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long partition_;
    /**
     *
     *
     * <pre>
     * The partition this is for.
     * </pre>
     *
     * <code>int64 partition = 1;</code>
     *
     * @return The partition.
     */
    @java.lang.Override
    public long getPartition() {
      return partition_;
    }
    /**
     *
     *
     * <pre>
     * The partition this is for.
     * </pre>
     *
     * <code>int64 partition = 1;</code>
     *
     * @param value The partition to set.
     * @return This builder for chaining.
     */
    public Builder setPartition(long value) {

      partition_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The partition this is for.
     * </pre>
     *
     * <code>int64 partition = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearPartition() {

      partition_ = 0L;
      onChanged();
      return this;
    }

    private com.google.cloud.pubsublite.proto.Cursor cursor_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.cloud.pubsublite.proto.Cursor,
            com.google.cloud.pubsublite.proto.Cursor.Builder,
            com.google.cloud.pubsublite.proto.CursorOrBuilder>
        cursorBuilder_;
    /**
     *
     *
     * <pre>
     * The value of the cursor.
     * </pre>
     *
     * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
     *
     * @return Whether the cursor field is set.
     */
    public boolean hasCursor() {
      return cursorBuilder_ != null || cursor_ != null;
    }
    /**
     *
     *
     * <pre>
     * The value of the cursor.
     * </pre>
     *
     * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
     *
     * @return The cursor.
     */
    public com.google.cloud.pubsublite.proto.Cursor getCursor() {
      if (cursorBuilder_ == null) {
        return cursor_ == null
            ? com.google.cloud.pubsublite.proto.Cursor.getDefaultInstance()
            : cursor_;
      } else {
        return cursorBuilder_.getMessage();
      }
    }
    /**
     *
     *
     * <pre>
     * The value of the cursor.
     * </pre>
     *
     * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
     */
    public Builder setCursor(com.google.cloud.pubsublite.proto.Cursor value) {
      if (cursorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        cursor_ = value;
        onChanged();
      } else {
        cursorBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The value of the cursor.
     * </pre>
     *
     * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
     */
    public Builder setCursor(com.google.cloud.pubsublite.proto.Cursor.Builder builderForValue) {
      if (cursorBuilder_ == null) {
        cursor_ = builderForValue.build();
        onChanged();
      } else {
        cursorBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The value of the cursor.
     * </pre>
     *
     * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
     */
    public Builder mergeCursor(com.google.cloud.pubsublite.proto.Cursor value) {
      if (cursorBuilder_ == null) {
        if (cursor_ != null) {
          cursor_ =
              com.google.cloud.pubsublite.proto.Cursor.newBuilder(cursor_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          cursor_ = value;
        }
        onChanged();
      } else {
        cursorBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The value of the cursor.
     * </pre>
     *
     * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
     */
    public Builder clearCursor() {
      if (cursorBuilder_ == null) {
        cursor_ = null;
        onChanged();
      } else {
        cursor_ = null;
        cursorBuilder_ = null;
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The value of the cursor.
     * </pre>
     *
     * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
     */
    public com.google.cloud.pubsublite.proto.Cursor.Builder getCursorBuilder() {

      onChanged();
      return getCursorFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * The value of the cursor.
     * </pre>
     *
     * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
     */
    public com.google.cloud.pubsublite.proto.CursorOrBuilder getCursorOrBuilder() {
      if (cursorBuilder_ != null) {
        return cursorBuilder_.getMessageOrBuilder();
      } else {
        return cursor_ == null
            ? com.google.cloud.pubsublite.proto.Cursor.getDefaultInstance()
            : cursor_;
      }
    }
    /**
     *
     *
     * <pre>
     * The value of the cursor.
     * </pre>
     *
     * <code>.google.cloud.pubsublite.v1.Cursor cursor = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.cloud.pubsublite.proto.Cursor,
            com.google.cloud.pubsublite.proto.Cursor.Builder,
            com.google.cloud.pubsublite.proto.CursorOrBuilder>
        getCursorFieldBuilder() {
      if (cursorBuilder_ == null) {
        cursorBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.cloud.pubsublite.proto.Cursor,
                com.google.cloud.pubsublite.proto.Cursor.Builder,
                com.google.cloud.pubsublite.proto.CursorOrBuilder>(
                getCursor(), getParentForChildren(), isClean());
        cursor_ = null;
      }
      return cursorBuilder_;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.cloud.pubsublite.v1.PartitionCursor)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.pubsublite.v1.PartitionCursor)
  private static final com.google.cloud.pubsublite.proto.PartitionCursor DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.cloud.pubsublite.proto.PartitionCursor();
  }

  public static com.google.cloud.pubsublite.proto.PartitionCursor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PartitionCursor> PARSER =
      new com.google.protobuf.AbstractParser<PartitionCursor>() {
        @java.lang.Override
        public PartitionCursor parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new PartitionCursor(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<PartitionCursor> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PartitionCursor> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.cloud.pubsublite.proto.PartitionCursor getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
