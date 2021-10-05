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
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.PrintMenuRequest,
      com.example.grpc.PrintMenuResponse> getPrintMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "printMenu",
      requestType = com.example.grpc.PrintMenuRequest.class,
      responseType = com.example.grpc.PrintMenuResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.PrintMenuRequest,
      com.example.grpc.PrintMenuResponse> getPrintMenuMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.PrintMenuRequest, com.example.grpc.PrintMenuResponse> getPrintMenuMethod;
    if ((getPrintMenuMethod = StudentCourseRegistrationSystemGrpc.getPrintMenuMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getPrintMenuMethod = StudentCourseRegistrationSystemGrpc.getPrintMenuMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getPrintMenuMethod = getPrintMenuMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.PrintMenuRequest, com.example.grpc.PrintMenuResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "printMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.PrintMenuRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.PrintMenuResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("printMenu"))
              .build();
        }
      }
    }
    return getPrintMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.ChoiceRequest,
      com.example.grpc.ResultOfChoiceResponse> getSelectMenuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "selectMenu",
      requestType = com.example.grpc.ChoiceRequest.class,
      responseType = com.example.grpc.ResultOfChoiceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.ChoiceRequest,
      com.example.grpc.ResultOfChoiceResponse> getSelectMenuMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.ChoiceRequest, com.example.grpc.ResultOfChoiceResponse> getSelectMenuMethod;
    if ((getSelectMenuMethod = StudentCourseRegistrationSystemGrpc.getSelectMenuMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getSelectMenuMethod = StudentCourseRegistrationSystemGrpc.getSelectMenuMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getSelectMenuMethod = getSelectMenuMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.ChoiceRequest, com.example.grpc.ResultOfChoiceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "selectMenu"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ChoiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ResultOfChoiceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("selectMenu"))
              .build();
        }
      }
    }
    return getSelectMenuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Request,
      com.example.grpc.StudentListResponse> getPrintStudentListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "printStudentList",
      requestType = com.example.grpc.Request.class,
      responseType = com.example.grpc.StudentListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Request,
      com.example.grpc.StudentListResponse> getPrintStudentListMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Request, com.example.grpc.StudentListResponse> getPrintStudentListMethod;
    if ((getPrintStudentListMethod = StudentCourseRegistrationSystemGrpc.getPrintStudentListMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getPrintStudentListMethod = StudentCourseRegistrationSystemGrpc.getPrintStudentListMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getPrintStudentListMethod = getPrintStudentListMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Request, com.example.grpc.StudentListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "printStudentList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StudentListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("printStudentList"))
              .build();
        }
      }
    }
    return getPrintStudentListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.Request,
      com.example.grpc.CourseListResponse> getPrintCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "printCourseList",
      requestType = com.example.grpc.Request.class,
      responseType = com.example.grpc.CourseListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.Request,
      com.example.grpc.CourseListResponse> getPrintCourseListMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.Request, com.example.grpc.CourseListResponse> getPrintCourseListMethod;
    if ((getPrintCourseListMethod = StudentCourseRegistrationSystemGrpc.getPrintCourseListMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getPrintCourseListMethod = StudentCourseRegistrationSystemGrpc.getPrintCourseListMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getPrintCourseListMethod = getPrintCourseListMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Request, com.example.grpc.CourseListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "printCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CourseListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("printCourseList"))
              .build();
        }
      }
    }
    return getPrintCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.StudentIdRequest,
      com.example.grpc.StudentIdResponse> getStudentCourseListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "studentCourseList",
      requestType = com.example.grpc.StudentIdRequest.class,
      responseType = com.example.grpc.StudentIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.StudentIdRequest,
      com.example.grpc.StudentIdResponse> getStudentCourseListMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.StudentIdRequest, com.example.grpc.StudentIdResponse> getStudentCourseListMethod;
    if ((getStudentCourseListMethod = StudentCourseRegistrationSystemGrpc.getStudentCourseListMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getStudentCourseListMethod = StudentCourseRegistrationSystemGrpc.getStudentCourseListMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getStudentCourseListMethod = getStudentCourseListMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.StudentIdRequest, com.example.grpc.StudentIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "studentCourseList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StudentIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StudentIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("studentCourseList"))
              .build();
        }
      }
    }
    return getStudentCourseListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.CourseIdRequest,
      com.example.grpc.CourseIdResponse> getCourseIdStudentListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "courseIdStudentList",
      requestType = com.example.grpc.CourseIdRequest.class,
      responseType = com.example.grpc.CourseIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.CourseIdRequest,
      com.example.grpc.CourseIdResponse> getCourseIdStudentListMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.CourseIdRequest, com.example.grpc.CourseIdResponse> getCourseIdStudentListMethod;
    if ((getCourseIdStudentListMethod = StudentCourseRegistrationSystemGrpc.getCourseIdStudentListMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getCourseIdStudentListMethod = StudentCourseRegistrationSystemGrpc.getCourseIdStudentListMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getCourseIdStudentListMethod = getCourseIdStudentListMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.CourseIdRequest, com.example.grpc.CourseIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "courseIdStudentList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CourseIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.CourseIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("courseIdStudentList"))
              .build();
        }
      }
    }
    return getCourseIdStudentListMethod;
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
    if ((getAddCourseMethod = StudentCourseRegistrationSystemGrpc.getAddCourseMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getAddCourseMethod = StudentCourseRegistrationSystemGrpc.getAddCourseMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getAddCourseMethod = getAddCourseMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Course, com.example.grpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Course.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Message.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("addCourse"))
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
    if ((getAddStudentMethod = StudentCourseRegistrationSystemGrpc.getAddStudentMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getAddStudentMethod = StudentCourseRegistrationSystemGrpc.getAddStudentMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getAddStudentMethod = getAddStudentMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Student, com.example.grpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Student.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Message.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("addStudent"))
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
    if ((getDeleteCourseByIdMethod = StudentCourseRegistrationSystemGrpc.getDeleteCourseByIdMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getDeleteCourseByIdMethod = StudentCourseRegistrationSystemGrpc.getDeleteCourseByIdMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getDeleteCourseByIdMethod = getDeleteCourseByIdMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Course, com.example.grpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCourseById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Course.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Message.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("deleteCourseById"))
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
    if ((getDeleteStudentByIdMethod = StudentCourseRegistrationSystemGrpc.getDeleteStudentByIdMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getDeleteStudentByIdMethod = StudentCourseRegistrationSystemGrpc.getDeleteStudentByIdMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getDeleteStudentByIdMethod = getDeleteStudentByIdMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.Student, com.example.grpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteStudentById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Student.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Message.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("deleteStudentById"))
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
    if ((getRegisterCourseByStudentMethod = StudentCourseRegistrationSystemGrpc.getRegisterCourseByStudentMethod) == null) {
      synchronized (StudentCourseRegistrationSystemGrpc.class) {
        if ((getRegisterCourseByStudentMethod = StudentCourseRegistrationSystemGrpc.getRegisterCourseByStudentMethod) == null) {
          StudentCourseRegistrationSystemGrpc.getRegisterCourseByStudentMethod = getRegisterCourseByStudentMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.StuAndCourseInfo, com.example.grpc.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registerCourseByStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StuAndCourseInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.Message.getDefaultInstance()))
              .setSchemaDescriptor(new StudentCourseRegistrationSystemMethodDescriptorSupplier("registerCourseByStudent"))
              .build();
        }
      }
    }
    return getRegisterCourseByStudentMethod;
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
    public void printMenu(com.example.grpc.PrintMenuRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.PrintMenuResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrintMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     * 메뉴선택
     * </pre>
     */
    public void selectMenu(com.example.grpc.ChoiceRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ResultOfChoiceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSelectMenuMethod(), responseObserver);
    }

    /**
     * <pre>
     *학생 리스트 출력
     * </pre>
     */
    public void printStudentList(com.example.grpc.Request request,
        io.grpc.stub.StreamObserver<com.example.grpc.StudentListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrintStudentListMethod(), responseObserver);
    }

    /**
     * <pre>
     *과목 리스트 출력
     * </pre>
     */
    public void printCourseList(com.example.grpc.Request request,
        io.grpc.stub.StreamObserver<com.example.grpc.CourseListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrintCourseListMethod(), responseObserver);
    }

    /**
     * <pre>
     * 학생 별 수강과목 리스트
     * </pre>
     */
    public void studentCourseList(com.example.grpc.StudentIdRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.StudentIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStudentCourseListMethod(), responseObserver);
    }

    /**
     * <pre>
     * 과목 별 수강 학생 리스트
     * </pre>
     */
    public void courseIdStudentList(com.example.grpc.CourseIdRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.CourseIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCourseIdStudentListMethod(), responseObserver);
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
            getPrintMenuMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.PrintMenuRequest,
                com.example.grpc.PrintMenuResponse>(
                  this, METHODID_PRINT_MENU)))
          .addMethod(
            getSelectMenuMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.ChoiceRequest,
                com.example.grpc.ResultOfChoiceResponse>(
                  this, METHODID_SELECT_MENU)))
          .addMethod(
            getPrintStudentListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Request,
                com.example.grpc.StudentListResponse>(
                  this, METHODID_PRINT_STUDENT_LIST)))
          .addMethod(
            getPrintCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.Request,
                com.example.grpc.CourseListResponse>(
                  this, METHODID_PRINT_COURSE_LIST)))
          .addMethod(
            getStudentCourseListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.StudentIdRequest,
                com.example.grpc.StudentIdResponse>(
                  this, METHODID_STUDENT_COURSE_LIST)))
          .addMethod(
            getCourseIdStudentListMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.CourseIdRequest,
                com.example.grpc.CourseIdResponse>(
                  this, METHODID_COURSE_ID_STUDENT_LIST)))
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
    public void printMenu(com.example.grpc.PrintMenuRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.PrintMenuResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPrintMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 메뉴선택
     * </pre>
     */
    public void selectMenu(com.example.grpc.ChoiceRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ResultOfChoiceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSelectMenuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *학생 리스트 출력
     * </pre>
     */
    public void printStudentList(com.example.grpc.Request request,
        io.grpc.stub.StreamObserver<com.example.grpc.StudentListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPrintStudentListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *과목 리스트 출력
     * </pre>
     */
    public void printCourseList(com.example.grpc.Request request,
        io.grpc.stub.StreamObserver<com.example.grpc.CourseListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPrintCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 학생 별 수강과목 리스트
     * </pre>
     */
    public void studentCourseList(com.example.grpc.StudentIdRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.StudentIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStudentCourseListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 과목 별 수강 학생 리스트
     * </pre>
     */
    public void courseIdStudentList(com.example.grpc.CourseIdRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.CourseIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCourseIdStudentListMethod(), getCallOptions()), request, responseObserver);
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
    public com.example.grpc.PrintMenuResponse printMenu(com.example.grpc.PrintMenuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPrintMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 메뉴선택
     * </pre>
     */
    public com.example.grpc.ResultOfChoiceResponse selectMenu(com.example.grpc.ChoiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSelectMenuMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *학생 리스트 출력
     * </pre>
     */
    public com.example.grpc.StudentListResponse printStudentList(com.example.grpc.Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPrintStudentListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *과목 리스트 출력
     * </pre>
     */
    public com.example.grpc.CourseListResponse printCourseList(com.example.grpc.Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPrintCourseListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 학생 별 수강과목 리스트
     * </pre>
     */
    public com.example.grpc.StudentIdResponse studentCourseList(com.example.grpc.StudentIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStudentCourseListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 과목 별 수강 학생 리스트
     * </pre>
     */
    public com.example.grpc.CourseIdResponse courseIdStudentList(com.example.grpc.CourseIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCourseIdStudentListMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.PrintMenuResponse> printMenu(
        com.example.grpc.PrintMenuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPrintMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 메뉴선택
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.ResultOfChoiceResponse> selectMenu(
        com.example.grpc.ChoiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSelectMenuMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *학생 리스트 출력
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.StudentListResponse> printStudentList(
        com.example.grpc.Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPrintStudentListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *과목 리스트 출력
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.CourseListResponse> printCourseList(
        com.example.grpc.Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPrintCourseListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 학생 별 수강과목 리스트
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.StudentIdResponse> studentCourseList(
        com.example.grpc.StudentIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStudentCourseListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 과목 별 수강 학생 리스트
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.CourseIdResponse> courseIdStudentList(
        com.example.grpc.CourseIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCourseIdStudentListMethod(), getCallOptions()), request);
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

  private static final int METHODID_PRINT_MENU = 0;
  private static final int METHODID_SELECT_MENU = 1;
  private static final int METHODID_PRINT_STUDENT_LIST = 2;
  private static final int METHODID_PRINT_COURSE_LIST = 3;
  private static final int METHODID_STUDENT_COURSE_LIST = 4;
  private static final int METHODID_COURSE_ID_STUDENT_LIST = 5;
  private static final int METHODID_ADD_COURSE = 6;
  private static final int METHODID_ADD_STUDENT = 7;
  private static final int METHODID_DELETE_COURSE_BY_ID = 8;
  private static final int METHODID_DELETE_STUDENT_BY_ID = 9;
  private static final int METHODID_REGISTER_COURSE_BY_STUDENT = 10;

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
        case METHODID_PRINT_MENU:
          serviceImpl.printMenu((com.example.grpc.PrintMenuRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.PrintMenuResponse>) responseObserver);
          break;
        case METHODID_SELECT_MENU:
          serviceImpl.selectMenu((com.example.grpc.ChoiceRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.ResultOfChoiceResponse>) responseObserver);
          break;
        case METHODID_PRINT_STUDENT_LIST:
          serviceImpl.printStudentList((com.example.grpc.Request) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.StudentListResponse>) responseObserver);
          break;
        case METHODID_PRINT_COURSE_LIST:
          serviceImpl.printCourseList((com.example.grpc.Request) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.CourseListResponse>) responseObserver);
          break;
        case METHODID_STUDENT_COURSE_LIST:
          serviceImpl.studentCourseList((com.example.grpc.StudentIdRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.StudentIdResponse>) responseObserver);
          break;
        case METHODID_COURSE_ID_STUDENT_LIST:
          serviceImpl.courseIdStudentList((com.example.grpc.CourseIdRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.CourseIdResponse>) responseObserver);
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
              .addMethod(getPrintMenuMethod())
              .addMethod(getSelectMenuMethod())
              .addMethod(getPrintStudentListMethod())
              .addMethod(getPrintCourseListMethod())
              .addMethod(getStudentCourseListMethod())
              .addMethod(getCourseIdStudentListMethod())
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
