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
public final class DataServiceGrpc {

  private DataServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.DataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.ListDataRequest,
      com.example.grpc.ListDataResponse> getGetListDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getListData",
      requestType = com.example.grpc.ListDataRequest.class,
      responseType = com.example.grpc.ListDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.ListDataRequest,
      com.example.grpc.ListDataResponse> getGetListDataMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.ListDataRequest, com.example.grpc.ListDataResponse> getGetListDataMethod;
    if ((getGetListDataMethod = DataServiceGrpc.getGetListDataMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetListDataMethod = DataServiceGrpc.getGetListDataMethod) == null) {
          DataServiceGrpc.getGetListDataMethod = getGetListDataMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.ListDataRequest, com.example.grpc.ListDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getListData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ListDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ListDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("getListData"))
              .build();
        }
      }
    }
    return getGetListDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.StudentId,
      com.example.grpc.StudentInfoString> getGetStudentByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStudentById",
      requestType = com.example.grpc.StudentId.class,
      responseType = com.example.grpc.StudentInfoString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.StudentId,
      com.example.grpc.StudentInfoString> getGetStudentByIdMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.StudentId, com.example.grpc.StudentInfoString> getGetStudentByIdMethod;
    if ((getGetStudentByIdMethod = DataServiceGrpc.getGetStudentByIdMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetStudentByIdMethod = DataServiceGrpc.getGetStudentByIdMethod) == null) {
          DataServiceGrpc.getGetStudentByIdMethod = getGetStudentByIdMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.StudentId, com.example.grpc.StudentInfoString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getStudentById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StudentId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StudentInfoString.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("getStudentById"))
              .build();
        }
      }
    }
    return getGetStudentByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.CourseId,
      com.example.grpc.CourseInfoString> getGetCourseByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCourseById",
      requestType = com.example.grpc.CourseId.class,
      responseType = com.example.grpc.CourseInfoString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.CourseId,
      com.example.grpc.CourseInfoString> getGetCourseByIdMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.CourseId, com.example.grpc.CourseInfoString> getGetCourseByIdMethod;
    if ((getGetCourseByIdMethod = DataServiceGrpc.getGetCourseByIdMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetCourseByIdMethod = DataServiceGrpc.getGetCourseByIdMethod) == null) {
          DataServiceGrpc.getGetCourseByIdMethod = getGetCourseByIdMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.CourseId, com.example.grpc.CourseInfoString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCourseById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CourseId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CourseInfoString.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("getCourseById"))
              .build();
        }
      }
    }
    return getGetCourseByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.CourseInfoString,
      com.example.grpc.StatusCode> getPutCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putCourse",
      requestType = com.example.grpc.CourseInfoString.class,
      responseType = com.example.grpc.StatusCode.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.CourseInfoString,
      com.example.grpc.StatusCode> getPutCourseMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.CourseInfoString, com.example.grpc.StatusCode> getPutCourseMethod;
    if ((getPutCourseMethod = DataServiceGrpc.getPutCourseMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutCourseMethod = DataServiceGrpc.getPutCourseMethod) == null) {
          DataServiceGrpc.getPutCourseMethod = getPutCourseMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.CourseInfoString, com.example.grpc.StatusCode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CourseInfoString.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StatusCode.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("putCourse"))
              .build();
        }
      }
    }
    return getPutCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.StudentInfoString,
      com.example.grpc.StatusCode> getPutStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putStudent",
      requestType = com.example.grpc.StudentInfoString.class,
      responseType = com.example.grpc.StatusCode.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.StudentInfoString,
      com.example.grpc.StatusCode> getPutStudentMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.StudentInfoString, com.example.grpc.StatusCode> getPutStudentMethod;
    if ((getPutStudentMethod = DataServiceGrpc.getPutStudentMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutStudentMethod = DataServiceGrpc.getPutStudentMethod) == null) {
          DataServiceGrpc.getPutStudentMethod = getPutStudentMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.StudentInfoString, com.example.grpc.StatusCode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StudentInfoString.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StatusCode.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("putStudent"))
              .build();
        }
      }
    }
    return getPutStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.CourseId,
      com.example.grpc.StatusCode> getDeleteCourseByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteCourseById",
      requestType = com.example.grpc.CourseId.class,
      responseType = com.example.grpc.StatusCode.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.CourseId,
      com.example.grpc.StatusCode> getDeleteCourseByIdMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.CourseId, com.example.grpc.StatusCode> getDeleteCourseByIdMethod;
    if ((getDeleteCourseByIdMethod = DataServiceGrpc.getDeleteCourseByIdMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getDeleteCourseByIdMethod = DataServiceGrpc.getDeleteCourseByIdMethod) == null) {
          DataServiceGrpc.getDeleteCourseByIdMethod = getDeleteCourseByIdMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.CourseId, com.example.grpc.StatusCode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCourseById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CourseId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StatusCode.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("deleteCourseById"))
              .build();
        }
      }
    }
    return getDeleteCourseByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.StudentId,
      com.example.grpc.StatusCode> getDeleteStudentByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteStudentById",
      requestType = com.example.grpc.StudentId.class,
      responseType = com.example.grpc.StatusCode.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.StudentId,
      com.example.grpc.StatusCode> getDeleteStudentByIdMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.StudentId, com.example.grpc.StatusCode> getDeleteStudentByIdMethod;
    if ((getDeleteStudentByIdMethod = DataServiceGrpc.getDeleteStudentByIdMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getDeleteStudentByIdMethod = DataServiceGrpc.getDeleteStudentByIdMethod) == null) {
          DataServiceGrpc.getDeleteStudentByIdMethod = getDeleteStudentByIdMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.StudentId, com.example.grpc.StatusCode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteStudentById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StudentId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StatusCode.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("deleteStudentById"))
              .build();
        }
      }
    }
    return getDeleteStudentByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.EditStudentInfoString,
      com.example.grpc.StatusCode> getUpdateStudentWithCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateStudentWithCourse",
      requestType = com.example.grpc.EditStudentInfoString.class,
      responseType = com.example.grpc.StatusCode.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.EditStudentInfoString,
      com.example.grpc.StatusCode> getUpdateStudentWithCourseMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.EditStudentInfoString, com.example.grpc.StatusCode> getUpdateStudentWithCourseMethod;
    if ((getUpdateStudentWithCourseMethod = DataServiceGrpc.getUpdateStudentWithCourseMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getUpdateStudentWithCourseMethod = DataServiceGrpc.getUpdateStudentWithCourseMethod) == null) {
          DataServiceGrpc.getUpdateStudentWithCourseMethod = getUpdateStudentWithCourseMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.EditStudentInfoString, com.example.grpc.StatusCode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateStudentWithCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.EditStudentInfoString.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StatusCode.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("updateStudentWithCourse"))
              .build();
        }
      }
    }
    return getUpdateStudentWithCourseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceStub>() {
        @java.lang.Override
        public DataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceStub(channel, callOptions);
        }
      };
    return DataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceBlockingStub>() {
        @java.lang.Override
        public DataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceBlockingStub(channel, callOptions);
        }
      };
    return DataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceFutureStub>() {
        @java.lang.Override
        public DataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceFutureStub(channel, callOptions);
        }
      };
    return DataServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Data부분 Service정의
   * </pre>
   */
  public static abstract class DataServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *과목 또는 학생 정보 리스트 전달하기
     * </pre>
     */
    public void getListData(com.example.grpc.ListDataRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ListDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListDataMethod(), responseObserver);
    }

    /**
     */
    public void getStudentById(com.example.grpc.StudentId request,
        io.grpc.stub.StreamObserver<com.example.grpc.StudentInfoString> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStudentByIdMethod(), responseObserver);
    }

    /**
     */
    public void getCourseById(com.example.grpc.CourseId request,
        io.grpc.stub.StreamObserver<com.example.grpc.CourseInfoString> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCourseByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public void putCourse(com.example.grpc.CourseInfoString request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutCourseMethod(), responseObserver);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public void putStudent(com.example.grpc.StudentInfoString request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutStudentMethod(), responseObserver);
    }

    /**
     * <pre>
     *delete Course
     * </pre>
     */
    public void deleteCourseById(com.example.grpc.CourseId request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCourseByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *delete Student
     * </pre>
     */
    public void deleteStudentById(com.example.grpc.StudentId request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteStudentByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *수강신청
     * </pre>
     */
    public void updateStudentWithCourse(com.example.grpc.EditStudentInfoString request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateStudentWithCourseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetListDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.ListDataRequest,
                com.example.grpc.ListDataResponse>(
                  this, METHODID_GET_LIST_DATA)))
          .addMethod(
            getGetStudentByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.StudentId,
                com.example.grpc.StudentInfoString>(
                  this, METHODID_GET_STUDENT_BY_ID)))
          .addMethod(
            getGetCourseByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.CourseId,
                com.example.grpc.CourseInfoString>(
                  this, METHODID_GET_COURSE_BY_ID)))
          .addMethod(
            getPutCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.CourseInfoString,
                com.example.grpc.StatusCode>(
                  this, METHODID_PUT_COURSE)))
          .addMethod(
            getPutStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.StudentInfoString,
                com.example.grpc.StatusCode>(
                  this, METHODID_PUT_STUDENT)))
          .addMethod(
            getDeleteCourseByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.CourseId,
                com.example.grpc.StatusCode>(
                  this, METHODID_DELETE_COURSE_BY_ID)))
          .addMethod(
            getDeleteStudentByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.StudentId,
                com.example.grpc.StatusCode>(
                  this, METHODID_DELETE_STUDENT_BY_ID)))
          .addMethod(
            getUpdateStudentWithCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.EditStudentInfoString,
                com.example.grpc.StatusCode>(
                  this, METHODID_UPDATE_STUDENT_WITH_COURSE)))
          .build();
    }
  }

  /**
   * <pre>
   *Data부분 Service정의
   * </pre>
   */
  public static final class DataServiceStub extends io.grpc.stub.AbstractAsyncStub<DataServiceStub> {
    private DataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *과목 또는 학생 정보 리스트 전달하기
     * </pre>
     */
    public void getListData(com.example.grpc.ListDataRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ListDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetListDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudentById(com.example.grpc.StudentId request,
        io.grpc.stub.StreamObserver<com.example.grpc.StudentInfoString> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStudentByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourseById(com.example.grpc.CourseId request,
        io.grpc.stub.StreamObserver<com.example.grpc.CourseInfoString> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCourseByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public void putCourse(com.example.grpc.CourseInfoString request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public void putStudent(com.example.grpc.StudentInfoString request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *delete Course
     * </pre>
     */
    public void deleteCourseById(com.example.grpc.CourseId request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCourseByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *delete Student
     * </pre>
     */
    public void deleteStudentById(com.example.grpc.StudentId request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStudentByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *수강신청
     * </pre>
     */
    public void updateStudentWithCourse(com.example.grpc.EditStudentInfoString request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStudentWithCourseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Data부분 Service정의
   * </pre>
   */
  public static final class DataServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataServiceBlockingStub> {
    private DataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *과목 또는 학생 정보 리스트 전달하기
     * </pre>
     */
    public com.example.grpc.ListDataResponse getListData(com.example.grpc.ListDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.StudentInfoString getStudentById(com.example.grpc.StudentId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStudentByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.CourseInfoString getCourseById(com.example.grpc.CourseId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCourseByIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public com.example.grpc.StatusCode putCourse(com.example.grpc.CourseInfoString request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutCourseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public com.example.grpc.StatusCode putStudent(com.example.grpc.StudentInfoString request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutStudentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *delete Course
     * </pre>
     */
    public com.example.grpc.StatusCode deleteCourseById(com.example.grpc.CourseId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCourseByIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *delete Student
     * </pre>
     */
    public com.example.grpc.StatusCode deleteStudentById(com.example.grpc.StudentId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStudentByIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *수강신청
     * </pre>
     */
    public com.example.grpc.StatusCode updateStudentWithCourse(com.example.grpc.EditStudentInfoString request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStudentWithCourseMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Data부분 Service정의
   * </pre>
   */
  public static final class DataServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataServiceFutureStub> {
    private DataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *과목 또는 학생 정보 리스트 전달하기
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.ListDataResponse> getListData(
        com.example.grpc.ListDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetListDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.StudentInfoString> getStudentById(
        com.example.grpc.StudentId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStudentByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.CourseInfoString> getCourseById(
        com.example.grpc.CourseId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCourseByIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.StatusCode> putCourse(
        com.example.grpc.CourseInfoString request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutCourseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.StatusCode> putStudent(
        com.example.grpc.StudentInfoString request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutStudentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *delete Course
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.StatusCode> deleteCourseById(
        com.example.grpc.CourseId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCourseByIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *delete Student
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.StatusCode> deleteStudentById(
        com.example.grpc.StudentId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStudentByIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *수강신청
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.StatusCode> updateStudentWithCourse(
        com.example.grpc.EditStudentInfoString request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStudentWithCourseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LIST_DATA = 0;
  private static final int METHODID_GET_STUDENT_BY_ID = 1;
  private static final int METHODID_GET_COURSE_BY_ID = 2;
  private static final int METHODID_PUT_COURSE = 3;
  private static final int METHODID_PUT_STUDENT = 4;
  private static final int METHODID_DELETE_COURSE_BY_ID = 5;
  private static final int METHODID_DELETE_STUDENT_BY_ID = 6;
  private static final int METHODID_UPDATE_STUDENT_WITH_COURSE = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LIST_DATA:
          serviceImpl.getListData((com.example.grpc.ListDataRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.ListDataResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENT_BY_ID:
          serviceImpl.getStudentById((com.example.grpc.StudentId) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.StudentInfoString>) responseObserver);
          break;
        case METHODID_GET_COURSE_BY_ID:
          serviceImpl.getCourseById((com.example.grpc.CourseId) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.CourseInfoString>) responseObserver);
          break;
        case METHODID_PUT_COURSE:
          serviceImpl.putCourse((com.example.grpc.CourseInfoString) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.StatusCode>) responseObserver);
          break;
        case METHODID_PUT_STUDENT:
          serviceImpl.putStudent((com.example.grpc.StudentInfoString) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.StatusCode>) responseObserver);
          break;
        case METHODID_DELETE_COURSE_BY_ID:
          serviceImpl.deleteCourseById((com.example.grpc.CourseId) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.StatusCode>) responseObserver);
          break;
        case METHODID_DELETE_STUDENT_BY_ID:
          serviceImpl.deleteStudentById((com.example.grpc.StudentId) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.StatusCode>) responseObserver);
          break;
        case METHODID_UPDATE_STUDENT_WITH_COURSE:
          serviceImpl.updateStudentWithCourse((com.example.grpc.EditStudentInfoString) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.StatusCode>) responseObserver);
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

  private static abstract class DataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.ExampleService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataService");
    }
  }

  private static final class DataServiceFileDescriptorSupplier
      extends DataServiceBaseDescriptorSupplier {
    DataServiceFileDescriptorSupplier() {}
  }

  private static final class DataServiceMethodDescriptorSupplier
      extends DataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataServiceFileDescriptorSupplier())
              .addMethod(getGetListDataMethod())
              .addMethod(getGetStudentByIdMethod())
              .addMethod(getGetCourseByIdMethod())
              .addMethod(getPutCourseMethod())
              .addMethod(getPutStudentMethod())
              .addMethod(getDeleteCourseByIdMethod())
              .addMethod(getDeleteStudentByIdMethod())
              .addMethod(getUpdateStudentWithCourseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
