package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *Server부분 데이터 정의
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.40.1)",
    comments = "Source: ExampleService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StudentCourseRegistrationSystemGrpc {

  private StudentCourseRegistrationSystemGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.StudentCourseRegistrationSystem";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.MenuRequest,
      com.example.grpc.MenuResponse> getGetMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMenu",
      requestType = com.example.grpc.MenuRequest.class,
      responseType = com.example.grpc.MenuResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.MenuRequest,
      com.example.grpc.MenuResponse> getGetMenuMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.MenuRequest, com.example.grpc.MenuResponse> getGetMenuMethod;
    if ((getGetMenuMethod = StudentCourseRegistrationSystemGrpc.getGetMenuMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getGetMenuMethod = StudentCourseRegistrationSystemGrpc.getGetMenuMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getGetMenuMethod = getGetMenuMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.MenuRequest, com.example.grpc.MenuResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.MenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.MenuResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("getMenu"))
              .build();
        }
      }
    }
    return getGetMenuMethod;
  }

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
    if ((getGetListDataMethod = StudentCourseRegistrationSystemGrpc.getGetListDataMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getGetListDataMethod = StudentCourseRegistrationSystemGrpc.getGetListDataMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getGetListDataMethod = getGetListDataMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.ListDataRequest, com.example.grpc.ListDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getListData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ListDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ListDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("getListData"))
              .build();
        }
      }
    }
    return getGetListDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Course,
      com.example.grpc.StatusCode> getPutCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putCourse",
      requestType = com.example.grpc.Course.class,
      responseType = com.example.grpc.StatusCode.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Course,
      com.example.grpc.StatusCode> getPutCourseMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Course, com.example.grpc.StatusCode> getPutCourseMethod;
    if ((getPutCourseMethod = StudentCourseRegistrationSystemGrpc.getPutCourseMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getPutCourseMethod = StudentCourseRegistrationSystemGrpc.getPutCourseMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getPutCourseMethod = getPutCourseMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Course, com.example.grpc.StatusCode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Course.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StatusCode.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("putCourse"))
              .build();
        }
      }
    }
    return getPutCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Student,
      com.example.grpc.StatusCode> getPutStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putStudent",
      requestType = com.example.grpc.Student.class,
      responseType = com.example.grpc.StatusCode.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Student,
      com.example.grpc.StatusCode> getPutStudentMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Student, com.example.grpc.StatusCode> getPutStudentMethod;
    if ((getPutStudentMethod = StudentCourseRegistrationSystemGrpc.getPutStudentMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getPutStudentMethod = StudentCourseRegistrationSystemGrpc.getPutStudentMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getPutStudentMethod = getPutStudentMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Student, com.example.grpc.StatusCode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Student.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StatusCode.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("putStudent"))
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
    if ((getDeleteCourseByIdMethod = StudentCourseRegistrationSystemGrpc.getDeleteCourseByIdMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getDeleteCourseByIdMethod = StudentCourseRegistrationSystemGrpc.getDeleteCourseByIdMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getDeleteCourseByIdMethod = getDeleteCourseByIdMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.CourseId, com.example.grpc.StatusCode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCourseById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CourseId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StatusCode.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("deleteCourseById"))
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
    if ((getDeleteStudentByIdMethod = StudentCourseRegistrationSystemGrpc.getDeleteStudentByIdMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getDeleteStudentByIdMethod = StudentCourseRegistrationSystemGrpc.getDeleteStudentByIdMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getDeleteStudentByIdMethod = getDeleteStudentByIdMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.StudentId, com.example.grpc.StatusCode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteStudentById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StudentId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StatusCode.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("deleteStudentById"))
              .build();
        }
      }
    }
    return getDeleteStudentByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.StudentAndCourseId,
      com.example.grpc.StatusCode> getUpdateStudentWithCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateStudentWithCourse",
      requestType = com.example.grpc.StudentAndCourseId.class,
      responseType = com.example.grpc.StatusCode.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.StudentAndCourseId,
      com.example.grpc.StatusCode> getUpdateStudentWithCourseMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.StudentAndCourseId, com.example.grpc.StatusCode> getUpdateStudentWithCourseMethod;
    if ((getUpdateStudentWithCourseMethod = StudentCourseRegistrationSystemGrpc.getUpdateStudentWithCourseMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getUpdateStudentWithCourseMethod = StudentCourseRegistrationSystemGrpc.getUpdateStudentWithCourseMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getUpdateStudentWithCourseMethod = getUpdateStudentWithCourseMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.StudentAndCourseId, com.example.grpc.StatusCode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateStudentWithCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StudentAndCourseId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StatusCode.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("updateStudentWithCourse"))
              .build();
        }
      }
    }
    return getUpdateStudentWithCourseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentCourseRegistrationSystemStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentCourseRegistrationSystemStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentCourseRegistrationSystemStub>() {
        @java.lang.Override
        public StudentCourseRegistrationSystemStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentCourseRegistrationSystemStub(channel, callOptions);
        }
      };
    return StudentCourseRegistrationSystemStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentCourseRegistrationSystemBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentCourseRegistrationSystemBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentCourseRegistrationSystemBlockingStub>() {
        @java.lang.Override
        public StudentCourseRegistrationSystemBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentCourseRegistrationSystemBlockingStub(channel, callOptions);
        }
      };
    return StudentCourseRegistrationSystemBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentCourseRegistrationSystemFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentCourseRegistrationSystemFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentCourseRegistrationSystemFutureStub>() {
        @java.lang.Override
        public StudentCourseRegistrationSystemFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentCourseRegistrationSystemFutureStub(channel, callOptions);
        }
      };
    return StudentCourseRegistrationSystemFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Server부분 데이터 정의
   * </pre>
   */
  public static abstract class StudentCourseRegistrationSystemImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 메뉴출력
     * </pre>
     */
    public void getMenu(com.example.grpc.MenuRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.MenuResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     *학생, 과목 리스트 출력
     * </pre>
     */
    public void getListData(com.example.grpc.ListDataRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ListDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListDataMethod(), responseObserver);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public void putCourse(com.example.grpc.Course request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutCourseMethod(), responseObserver);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public void putStudent(com.example.grpc.Student request,
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
    public void updateStudentWithCourse(com.example.grpc.StudentAndCourseId request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateStudentWithCourseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMenuMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.MenuRequest,
                com.example.grpc.MenuResponse>(
                  this, METHODID_GET_MENU)))
          .addMethod(
            getGetListDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.ListDataRequest,
                com.example.grpc.ListDataResponse>(
                  this, METHODID_GET_LIST_DATA)))
          .addMethod(
            getPutCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Course,
                com.example.grpc.StatusCode>(
                  this, METHODID_PUT_COURSE)))
          .addMethod(
            getPutStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Student,
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
                com.example.grpc.StudentAndCourseId,
                com.example.grpc.StatusCode>(
                  this, METHODID_UPDATE_STUDENT_WITH_COURSE)))
          .build();
    }
  }

  /**
   * <pre>
   *Server부분 데이터 정의
   * </pre>
   */
  public static final class StudentCourseRegistrationSystemStub extends io.grpc.stub.AbstractAsyncStub<StudentCourseRegistrationSystemStub> {
    private StudentCourseRegistrationSystemStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentCourseRegistrationSystemStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentCourseRegistrationSystemStub(channel, callOptions);
    }

    /**
     * <pre>
     * 메뉴출력
     * </pre>
     */
    public void getMenu(com.example.grpc.MenuRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.MenuResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *학생, 과목 리스트 출력
     * </pre>
     */
    public void getListData(com.example.grpc.ListDataRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ListDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetListDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public void putCourse(com.example.grpc.Course request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public void putStudent(com.example.grpc.Student request,
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
    public void updateStudentWithCourse(com.example.grpc.StudentAndCourseId request,
        io.grpc.stub.StreamObserver<com.example.grpc.StatusCode> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStudentWithCourseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Server부분 데이터 정의
   * </pre>
   */
  public static final class StudentCourseRegistrationSystemBlockingStub extends io.grpc.stub.AbstractBlockingStub<StudentCourseRegistrationSystemBlockingStub> {
    private StudentCourseRegistrationSystemBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentCourseRegistrationSystemBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentCourseRegistrationSystemBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 메뉴출력
     * </pre>
     */
    public com.example.grpc.MenuResponse getMenu(com.example.grpc.MenuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *학생, 과목 리스트 출력
     * </pre>
     */
    public com.example.grpc.ListDataResponse getListData(com.example.grpc.ListDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public com.example.grpc.StatusCode putCourse(com.example.grpc.Course request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutCourseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public com.example.grpc.StatusCode putStudent(com.example.grpc.Student request) {
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
    public com.example.grpc.StatusCode updateStudentWithCourse(com.example.grpc.StudentAndCourseId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStudentWithCourseMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Server부분 데이터 정의
   * </pre>
   */
  public static final class StudentCourseRegistrationSystemFutureStub extends io.grpc.stub.AbstractFutureStub<StudentCourseRegistrationSystemFutureStub> {
    private StudentCourseRegistrationSystemFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentCourseRegistrationSystemFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentCourseRegistrationSystemFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 메뉴출력
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.MenuResponse> getMenu(
        com.example.grpc.MenuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *학생, 과목 리스트 출력
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.ListDataResponse> getListData(
        com.example.grpc.ListDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetListDataMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *add Course
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.StatusCode> putCourse(
        com.example.grpc.Course request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutCourseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *add Student
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.StatusCode> putStudent(
        com.example.grpc.Student request) {
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
        com.example.grpc.StudentAndCourseId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStudentWithCourseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MENU = 0;
  private static final int METHODID_GET_LIST_DATA = 1;
  private static final int METHODID_PUT_COURSE = 2;
  private static final int METHODID_PUT_STUDENT = 3;
  private static final int METHODID_DELETE_COURSE_BY_ID = 4;
  private static final int METHODID_DELETE_STUDENT_BY_ID = 5;
  private static final int METHODID_UPDATE_STUDENT_WITH_COURSE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentCourseRegistrationSystemImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentCourseRegistrationSystemImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MENU:
          serviceImpl.getMenu((com.example.grpc.MenuRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.MenuResponse>) responseObserver);
          break;
        case METHODID_GET_LIST_DATA:
          serviceImpl.getListData((com.example.grpc.ListDataRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.ListDataResponse>) responseObserver);
          break;
        case METHODID_PUT_COURSE:
          serviceImpl.putCourse((com.example.grpc.Course) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.StatusCode>) responseObserver);
          break;
        case METHODID_PUT_STUDENT:
          serviceImpl.putStudent((com.example.grpc.Student) request,
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
          serviceImpl.updateStudentWithCourse((com.example.grpc.StudentAndCourseId) request,
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

  private static abstract class StudentCourseRegistrationSystemBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentCourseRegistrationSystemBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.ExampleService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentCourseRegistrationSystem");
    }
  }

  private static final class StudentCourseRegistrationSystemFileDescriptorSupplier
      extends StudentCourseRegistrationSystemBaseDescriptorSupplier {
    StudentCourseRegistrationSystemFileDescriptorSupplier() {}
  }

  private static final class StudentCourseRegistrationSystemMethodDescriptorSupplier
      extends StudentCourseRegistrationSystemBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentCourseRegistrationSystemMethodDescriptorSupplier(String methodName) {
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
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentCourseRegistrationSystemFileDescriptorSupplier())
              .addMethod(getGetMenuMethod())
              .addMethod(getGetListDataMethod())
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
