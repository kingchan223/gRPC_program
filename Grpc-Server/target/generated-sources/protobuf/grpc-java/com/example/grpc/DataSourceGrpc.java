package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *Data부분 Service정의
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: ExampleService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataSourceGrpc {

  private DataSourceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.DataSource";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.DataRequest,
      com.example.grpc.DataResponse> getGetListDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getListData",
      requestType = com.example.grpc.DataRequest.class,
      responseType = com.example.grpc.DataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.DataRequest,
      com.example.grpc.DataResponse> getGetListDataMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.DataRequest, com.example.grpc.DataResponse> getGetListDataMethod;
    if ((getGetListDataMethod = DataSourceGrpc.getGetListDataMethod) == null) {
      synchronized (DataSourceGrpc.class) {
        if ((getGetListDataMethod = DataSourceGrpc.getGetListDataMethod) == null) {
          DataSourceGrpc.getGetListDataMethod = getGetListDataMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.DataRequest, com.example.grpc.DataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getListData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.DataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.DataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataSourceMethodDescriptorSupplier("getListData"))
              .build();
        }
      }
    }
    return getGetListDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Course,
      com.example.grpc.Message> getAddCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addCourse",
      requestType = com.example.grpc.Course.class,
      responseType = com.example.grpc.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Course,
      com.example.grpc.Message> getAddCourseMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Course, com.example.grpc.Message> getAddCourseMethod;
    if ((getAddCourseMethod = DataSourceGrpc.getAddCourseMethod) == null) {
      synchronized (DataSourceGrpc.class) {
        if ((getAddCourseMethod = DataSourceGrpc.getAddCourseMethod) == null) {
          DataSourceGrpc.getAddCourseMethod = getAddCourseMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Course, com.example.grpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Course.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Message.getDefaultInstance()))
              .setSchemaDescriptor(new DataSourceMethodDescriptorSupplier("addCourse"))
              .build();
        }
      }
    }
    return getAddCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Student,
      com.example.grpc.Message> getAddStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addStudent",
      requestType = com.example.grpc.Student.class,
      responseType = com.example.grpc.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Student,
      com.example.grpc.Message> getAddStudentMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Student, com.example.grpc.Message> getAddStudentMethod;
    if ((getAddStudentMethod = DataSourceGrpc.getAddStudentMethod) == null) {
      synchronized (DataSourceGrpc.class) {
        if ((getAddStudentMethod = DataSourceGrpc.getAddStudentMethod) == null) {
          DataSourceGrpc.getAddStudentMethod = getAddStudentMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Student, com.example.grpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Student.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Message.getDefaultInstance()))
              .setSchemaDescriptor(new DataSourceMethodDescriptorSupplier("addStudent"))
              .build();
        }
      }
    }
    return getAddStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Course,
      com.example.grpc.Message> getDeleteCourseByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteCourseById",
      requestType = com.example.grpc.Course.class,
      responseType = com.example.grpc.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Course,
      com.example.grpc.Message> getDeleteCourseByIdMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Course, com.example.grpc.Message> getDeleteCourseByIdMethod;
    if ((getDeleteCourseByIdMethod = DataSourceGrpc.getDeleteCourseByIdMethod) == null) {
      synchronized (DataSourceGrpc.class) {
        if ((getDeleteCourseByIdMethod = DataSourceGrpc.getDeleteCourseByIdMethod) == null) {
          DataSourceGrpc.getDeleteCourseByIdMethod = getDeleteCourseByIdMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Course, com.example.grpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCourseById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Course.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Message.getDefaultInstance()))
              .setSchemaDescriptor(new DataSourceMethodDescriptorSupplier("deleteCourseById"))
              .build();
        }
      }
    }
    return getDeleteCourseByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Student,
      com.example.grpc.Message> getDeleteStudentByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteStudentById",
      requestType = com.example.grpc.Student.class,
      responseType = com.example.grpc.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Student,
      com.example.grpc.Message> getDeleteStudentByIdMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Student, com.example.grpc.Message> getDeleteStudentByIdMethod;
    if ((getDeleteStudentByIdMethod = DataSourceGrpc.getDeleteStudentByIdMethod) == null) {
      synchronized (DataSourceGrpc.class) {
        if ((getDeleteStudentByIdMethod = DataSourceGrpc.getDeleteStudentByIdMethod) == null) {
          DataSourceGrpc.getDeleteStudentByIdMethod = getDeleteStudentByIdMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Student, com.example.grpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteStudentById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Student.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Message.getDefaultInstance()))
              .setSchemaDescriptor(new DataSourceMethodDescriptorSupplier("deleteStudentById"))
              .build();
        }
      }
    }
    return getDeleteStudentByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.StuAndCourseInfo,
      com.example.grpc.Message> getRegisterCourseByStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerCourseByStudent",
      requestType = com.example.grpc.StuAndCourseInfo.class,
      responseType = com.example.grpc.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.StuAndCourseInfo,
      com.example.grpc.Message> getRegisterCourseByStudentMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.StuAndCourseInfo, com.example.grpc.Message> getRegisterCourseByStudentMethod;
    if ((getRegisterCourseByStudentMethod = DataSourceGrpc.getRegisterCourseByStudentMethod) == null) {
      synchronized (DataSourceGrpc.class) {
        if ((getRegisterCourseByStudentMethod = DataSourceGrpc.getRegisterCourseByStudentMethod) == null) {
          DataSourceGrpc.getRegisterCourseByStudentMethod = getRegisterCourseByStudentMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.StuAndCourseInfo, com.example.grpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registerCourseByStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StuAndCourseInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Message.getDefaultInstance()))
              .setSchemaDescriptor(new DataSourceMethodDescriptorSupplier("registerCourseByStudent"))
              .build();
        }
      }
    }
    return getRegisterCourseByStudentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataSourceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataSourceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataSourceStub>() {
        @java.lang.Override
        public DataSourceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataSourceStub(channel, callOptions);
        }
      };
    return DataSourceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataSourceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataSourceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataSourceBlockingStub>() {
        @java.lang.Override
        public DataSourceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataSourceBlockingStub(channel, callOptions);
        }
      };
    return DataSourceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataSourceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataSourceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataSourceFutureStub>() {
        @java.lang.Override
        public DataSourceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataSourceFutureStub(channel, callOptions);
        }
      };
    return DataSourceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Data부분 Service정의
   * </pre>
   */
  public static abstract class DataSourceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *과목 또는 학생 정보 리스트 전달하기
     * </pre>
     */
    public void getListData(com.example.grpc.DataRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.DataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListDataMethod(), responseObserver);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public void addCourse(com.example.grpc.Course request,
        io.grpc.stub.StreamObserver<com.example.grpc.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCourseMethod(), responseObserver);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public void addStudent(com.example.grpc.Student request,
        io.grpc.stub.StreamObserver<com.example.grpc.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddStudentMethod(), responseObserver);
    }

    /**
     * <pre>
     *delete Course
     * </pre>
     */
    public void deleteCourseById(com.example.grpc.Course request,
        io.grpc.stub.StreamObserver<com.example.grpc.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCourseByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *delete Student
     * </pre>
     */
    public void deleteStudentById(com.example.grpc.Student request,
        io.grpc.stub.StreamObserver<com.example.grpc.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteStudentByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *수강신청
     * </pre>
     */
    public void registerCourseByStudent(com.example.grpc.StuAndCourseInfo request,
        io.grpc.stub.StreamObserver<com.example.grpc.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterCourseByStudentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetListDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.DataRequest,
                com.example.grpc.DataResponse>(
                  this, METHODID_GET_LIST_DATA)))
          .addMethod(
            getAddCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Course,
                com.example.grpc.Message>(
                  this, METHODID_ADD_COURSE)))
          .addMethod(
            getAddStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Student,
                com.example.grpc.Message>(
                  this, METHODID_ADD_STUDENT)))
          .addMethod(
            getDeleteCourseByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Course,
                com.example.grpc.Message>(
                  this, METHODID_DELETE_COURSE_BY_ID)))
          .addMethod(
            getDeleteStudentByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Student,
                com.example.grpc.Message>(
                  this, METHODID_DELETE_STUDENT_BY_ID)))
          .addMethod(
            getRegisterCourseByStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.StuAndCourseInfo,
                com.example.grpc.Message>(
                  this, METHODID_REGISTER_COURSE_BY_STUDENT)))
          .build();
    }
  }

  /**
   * <pre>
   *Data부분 Service정의
   * </pre>
   */
  public static final class DataSourceStub extends io.grpc.stub.AbstractAsyncStub<DataSourceStub> {
    private DataSourceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataSourceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataSourceStub(channel, callOptions);
    }

    /**
     * <pre>
     *과목 또는 학생 정보 리스트 전달하기
     * </pre>
     */
    public void getListData(com.example.grpc.DataRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.DataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetListDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public void addCourse(com.example.grpc.Course request,
        io.grpc.stub.StreamObserver<com.example.grpc.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public void addStudent(com.example.grpc.Student request,
        io.grpc.stub.StreamObserver<com.example.grpc.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *delete Course
     * </pre>
     */
    public void deleteCourseById(com.example.grpc.Course request,
        io.grpc.stub.StreamObserver<com.example.grpc.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCourseByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *delete Student
     * </pre>
     */
    public void deleteStudentById(com.example.grpc.Student request,
        io.grpc.stub.StreamObserver<com.example.grpc.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStudentByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *수강신청
     * </pre>
     */
    public void registerCourseByStudent(com.example.grpc.StuAndCourseInfo request,
        io.grpc.stub.StreamObserver<com.example.grpc.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterCourseByStudentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Data부분 Service정의
   * </pre>
   */
  public static final class DataSourceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataSourceBlockingStub> {
    private DataSourceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataSourceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataSourceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *과목 또는 학생 정보 리스트 전달하기
     * </pre>
     */
    public com.example.grpc.DataResponse getListData(com.example.grpc.DataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public com.example.grpc.Message addCourse(com.example.grpc.Course request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCourseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public com.example.grpc.Message addStudent(com.example.grpc.Student request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddStudentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *delete Course
     * </pre>
     */
    public com.example.grpc.Message deleteCourseById(com.example.grpc.Course request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCourseByIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *delete Student
     * </pre>
     */
    public com.example.grpc.Message deleteStudentById(com.example.grpc.Student request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStudentByIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *수강신청
     * </pre>
     */
    public com.example.grpc.Message registerCourseByStudent(com.example.grpc.StuAndCourseInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterCourseByStudentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Data부분 Service정의
   * </pre>
   */
  public static final class DataSourceFutureStub extends io.grpc.stub.AbstractFutureStub<DataSourceFutureStub> {
    private DataSourceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataSourceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataSourceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *과목 또는 학생 정보 리스트 전달하기
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.DataResponse> getListData(
        com.example.grpc.DataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetListDataMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Message> addCourse(
        com.example.grpc.Course request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Message> addStudent(
        com.example.grpc.Student request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddStudentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *delete Course
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Message> deleteCourseById(
        com.example.grpc.Course request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCourseByIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *delete Student
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Message> deleteStudentById(
        com.example.grpc.Student request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStudentByIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *수강신청
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.Message> registerCourseByStudent(
        com.example.grpc.StuAndCourseInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterCourseByStudentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LIST_DATA = 0;
  private static final int METHODID_ADD_COURSE = 1;
  private static final int METHODID_ADD_STUDENT = 2;
  private static final int METHODID_DELETE_COURSE_BY_ID = 3;
  private static final int METHODID_DELETE_STUDENT_BY_ID = 4;
  private static final int METHODID_REGISTER_COURSE_BY_STUDENT = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataSourceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataSourceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LIST_DATA:
          serviceImpl.getListData((com.example.grpc.DataRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.DataResponse>) responseObserver);
          break;
        case METHODID_ADD_COURSE:
          serviceImpl.addCourse((com.example.grpc.Course) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Message>) responseObserver);
          break;
        case METHODID_ADD_STUDENT:
          serviceImpl.addStudent((com.example.grpc.Student) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Message>) responseObserver);
          break;
        case METHODID_DELETE_COURSE_BY_ID:
          serviceImpl.deleteCourseById((com.example.grpc.Course) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Message>) responseObserver);
          break;
        case METHODID_DELETE_STUDENT_BY_ID:
          serviceImpl.deleteStudentById((com.example.grpc.Student) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Message>) responseObserver);
          break;
        case METHODID_REGISTER_COURSE_BY_STUDENT:
          serviceImpl.registerCourseByStudent((com.example.grpc.StuAndCourseInfo) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.Message>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DataSourceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataSourceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.ExampleService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataSource");
    }
  }

  private static final class DataSourceFileDescriptorSupplier
      extends DataSourceBaseDescriptorSupplier {
    DataSourceFileDescriptorSupplier() {}
  }

  private static final class DataSourceMethodDescriptorSupplier
      extends DataSourceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataSourceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DataSourceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataSourceFileDescriptorSupplier())
              .addMethod(getGetListDataMethod())
              .addMethod(getAddCourseMethod())
              .addMethod(getAddStudentMethod())
              .addMethod(getDeleteCourseByIdMethod())
              .addMethod(getDeleteStudentByIdMethod())
              .addMethod(getRegisterCourseByStudentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
