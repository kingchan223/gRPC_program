// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ExampleService.proto

package com.example.grpc;

public final class ExampleService {
  private ExampleService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_MenuRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_MenuRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_MenuResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_MenuResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_StudentListResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_StudentListResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_CourseListResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_CourseListResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_ChoiceRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_ChoiceRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_ResultOfChoiceResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_ResultOfChoiceResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_Course_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_Course_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_Student_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_Student_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_StatusCode_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_StatusCode_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_CourseId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_CourseId_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_StudentId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_StudentId_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_Request_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_Request_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_Response_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_ListDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_ListDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_ListDataResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_ListDataResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_CourseInfoString_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_CourseInfoString_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_StudentInfoString_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_StudentInfoString_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_StudentAndCourseId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_StudentAndCourseId_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024ExampleService.proto\022\020com.example.grpc" +
      "\"\036\n\013MenuRequest\022\017\n\007request\030\001 \001(\t\" \n\014Menu" +
      "Response\022\020\n\010menuList\030\001 \003(\t\"*\n\023StudentLis" +
      "tResponse\022\023\n\013studentList\030\001 \003(\t\"(\n\022Course" +
      "ListResponse\022\022\n\ncourseList\030\001 \003(\t\"\037\n\rChoi" +
      "ceRequest\022\016\n\006number\030\001 \001(\t\"(\n\026ResultOfCho" +
      "iceResponse\022\016\n\006result\030\001 \001(\t\"I\n\006Course\022\n\n" +
      "\002id\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\021\n\tprof_name\030\003 \001" +
      "(\t\022\022\n\npreCourses\030\004 \003(\t\"2\n\007Student\022\n\n\002id\030" +
      "\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\r\n\005major\030\003 \001(\t\"1\n\nSt" +
      "atusCode\022\022\n\nstatusCode\030\001 \001(\t\022\017\n\007message\030" +
      "\002 \001(\t\"\034\n\010CourseId\022\020\n\010courseId\030\001 \001(\t\"\036\n\tS" +
      "tudentId\022\021\n\tstudentId\030\001 \001(\t\"\032\n\007Request\022\017" +
      "\n\007request\030\001 \001(\t\"\034\n\010Response\022\020\n\010response\030" +
      "\001 \001(\t\"*\n\017ListDataRequest\022\027\n\017studentOrCou" +
      "rse\030\001 \001(\t\" \n\020ListDataResponse\022\014\n\004data\030\001 " +
      "\003(\t\"&\n\020CourseInfoString\022\022\n\ncourseInfo\030\001 " +
      "\001(\t\"(\n\021StudentInfoString\022\023\n\013studentInfo\030" +
      "\001 \001(\t\"9\n\022StudentAndCourseId\022\021\n\tstudentId" +
      "\030\001 \001(\t\022\020\n\010courseId\030\002 \001(\t2\212\005\n\037StudentCour" +
      "seRegistrationSystem\022H\n\007getMenu\022\035.com.ex" +
      "ample.grpc.MenuRequest\032\036.com.example.grp" +
      "c.MenuResponse\022T\n\013getListData\022!.com.exam" +
      "ple.grpc.ListDataRequest\032\".com.example.g" +
      "rpc.ListDataResponse\022C\n\tputCourse\022\030.com." +
      "example.grpc.Course\032\034.com.example.grpc.S" +
      "tatusCode\022E\n\nputStudent\022\031.com.example.gr" +
      "pc.Student\032\034.com.example.grpc.StatusCode" +
      "\022L\n\020deleteCourseById\022\032.com.example.grpc." +
      "CourseId\032\034.com.example.grpc.StatusCode\022N" +
      "\n\021deleteStudentById\022\033.com.example.grpc.S" +
      "tudentId\032\034.com.example.grpc.StatusCode\022]" +
      "\n\027updateStudentWithCourse\022$.com.example." +
      "grpc.StudentAndCourseId\032\034.com.example.gr" +
      "pc.StatusCode\022>\n\005close\022\031.com.example.grp" +
      "c.Request\032\032.com.example.grpc.Response2\330\005" +
      "\n\013DataService\022T\n\013getListData\022!.com.examp" +
      "le.grpc.ListDataRequest\032\".com.example.gr" +
      "pc.ListDataResponse\022K\n\016getStudentById\022\033." +
      "com.example.grpc.StudentId\032\034.com.example" +
      ".grpc.StatusCode\022I\n\rgetCourseById\022\032.com." +
      "example.grpc.CourseId\032\034.com.example.grpc" +
      ".StatusCode\022M\n\tputCourse\022\".com.example.g" +
      "rpc.CourseInfoString\032\034.com.example.grpc." +
      "StatusCode\022O\n\nputStudent\022#.com.example.g" +
      "rpc.StudentInfoString\032\034.com.example.grpc" +
      ".StatusCode\022L\n\020deleteCourseById\022\032.com.ex" +
      "ample.grpc.CourseId\032\034.com.example.grpc.S" +
      "tatusCode\022N\n\021deleteStudentById\022\033.com.exa" +
      "mple.grpc.StudentId\032\034.com.example.grpc.S" +
      "tatusCode\022]\n\027updateStudentWithCourse\022$.c" +
      "om.example.grpc.StudentAndCourseId\032\034.com" +
      ".example.grpc.StatusCode\022>\n\005close\022\031.com." +
      "example.grpc.Request\032\032.com.example.grpc." +
      "ResponseB\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_example_grpc_MenuRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_grpc_MenuRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_MenuRequest_descriptor,
        new java.lang.String[] { "Request", });
    internal_static_com_example_grpc_MenuResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_example_grpc_MenuResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_MenuResponse_descriptor,
        new java.lang.String[] { "MenuList", });
    internal_static_com_example_grpc_StudentListResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_example_grpc_StudentListResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_StudentListResponse_descriptor,
        new java.lang.String[] { "StudentList", });
    internal_static_com_example_grpc_CourseListResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_example_grpc_CourseListResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_CourseListResponse_descriptor,
        new java.lang.String[] { "CourseList", });
    internal_static_com_example_grpc_ChoiceRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_example_grpc_ChoiceRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_ChoiceRequest_descriptor,
        new java.lang.String[] { "Number", });
    internal_static_com_example_grpc_ResultOfChoiceResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_example_grpc_ResultOfChoiceResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_ResultOfChoiceResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_com_example_grpc_Course_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_com_example_grpc_Course_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_Course_descriptor,
        new java.lang.String[] { "Id", "Name", "ProfName", "PreCourses", });
    internal_static_com_example_grpc_Student_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_com_example_grpc_Student_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_Student_descriptor,
        new java.lang.String[] { "Id", "Name", "Major", });
    internal_static_com_example_grpc_StatusCode_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_com_example_grpc_StatusCode_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_StatusCode_descriptor,
        new java.lang.String[] { "StatusCode", "Message", });
    internal_static_com_example_grpc_CourseId_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_com_example_grpc_CourseId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_CourseId_descriptor,
        new java.lang.String[] { "CourseId", });
    internal_static_com_example_grpc_StudentId_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_com_example_grpc_StudentId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_StudentId_descriptor,
        new java.lang.String[] { "StudentId", });
    internal_static_com_example_grpc_Request_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_com_example_grpc_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_Request_descriptor,
        new java.lang.String[] { "Request", });
    internal_static_com_example_grpc_Response_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_com_example_grpc_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_Response_descriptor,
        new java.lang.String[] { "Response", });
    internal_static_com_example_grpc_ListDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_com_example_grpc_ListDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_ListDataRequest_descriptor,
        new java.lang.String[] { "StudentOrCourse", });
    internal_static_com_example_grpc_ListDataResponse_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_com_example_grpc_ListDataResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_ListDataResponse_descriptor,
        new java.lang.String[] { "Data", });
    internal_static_com_example_grpc_CourseInfoString_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_com_example_grpc_CourseInfoString_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_CourseInfoString_descriptor,
        new java.lang.String[] { "CourseInfo", });
    internal_static_com_example_grpc_StudentInfoString_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_com_example_grpc_StudentInfoString_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_StudentInfoString_descriptor,
        new java.lang.String[] { "StudentInfo", });
    internal_static_com_example_grpc_StudentAndCourseId_descriptor =
      getDescriptor().getMessageTypes().get(17);
    internal_static_com_example_grpc_StudentAndCourseId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_StudentAndCourseId_descriptor,
        new java.lang.String[] { "StudentId", "CourseId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
