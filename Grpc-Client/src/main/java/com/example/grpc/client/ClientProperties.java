package com.example.grpc.client;

public interface ClientProperties {
    public static final String  LINE ="===============================================";
    public static final String EXIT = "\n프로그램을 종료합니다.";
    public static final String WRONG_NUM = "\n❗️❗️❗없는 메뉴를 선택하셨습니다❗️❗️❗";
    public static final String INPUT_ID_MSG = "\nID를 입력하세요:";
    public static final String INPUT_NAME_MSG = "\n이름을 입력하세요:";
    public static final String INPUT_COURSENAME_MSG = "\n강좌명을 입력하세요:";
    public static final String INPUT_PRECOURSE_MSG = "\n선수과목의 ID를 입력하세요 ('/'로 구분. 예시: 1010/1011 ) :";
    public static final String INPUT_PROFNAME_MSG = "\n담당 교수를 입력하세요:";
    public static final String INPUT_MAJOR_MSG = "\n전공을 입력하세요:";
    public static final String REGISTER_COURSE_STDID = "\n수강신청을 진행할 학생의 ID를 입력하세요 :";
    public static final String REGISTER_COURSE_COURSEID = "\n수강신청할 과목의 ID를 입력하세요:";
    public static final String INPUT_NUMBER = "\n❗️❗️❗숫자를 입력해주세요❗️❗️❗️";
    public static final String INPUT_STUDENT_NUM_AGAIN = "\n❗️❗️❗학생번호를 다시 입력해주세요❗️❗️❗️";
    public static final String INPUT_COURSE_NUM_AGAIN = "\n❗️❗️❗강좌번호를 다시 입력해주세요❗️❗️❗️";
    public static final String NULL_DATA_INPUT_AGAIN = "\n❗️❗️❗ 입력하지 않은 데이터가 있습니다. 다시 시도해주세요.❗️❗️❗️";
    public static final String NOTexistIDstd = "\n❗️❗️❗존재하지 않는 학생 아이디를 입력하셨습니다❗️❗️❗️";
    public static final String NOTexistDefault = "\n❗️❗️❗존재하지 않는 아이디를 입력하셨습니다❗️❗️❗️";
    public static final String alreadyEcourse = "\n❗️❗️❗이미 등록된 강좌번호를 입력하셨습니다❗️❗️❗️";
    public static final String alreadyEstd = "\n❗️❗️❗이미 등록된 학생번호를 입력하셨습니다❗️❗️❗️";
    public static final String NOTexistIDcourse = "\n❗️❗️❗존재하지 않는 강좌번호를 입력하셨습니다❗️❗️❗";
    public static final String success = "\n🥳 성공적으로 반영되었습니다! 🥳";
    public static final String fail = "\n❗️❗️❗실패하였습니다. 다시 시도해주세요❗️❗️❗";
    public static final String NOTexistID = "\n❗️❗️❗알 수 없는 이유로 실패하였습니다. 다시 시도해주세요❗️❗️❗";
    public static final String HaveToTakePre = "\n❗️❗️❗선수과목을 수강하지 않았습니다.❗️❗️❗️";
    public static final int EXIT_NUM = 8;
    public static final String SEPARATOR = " ";
    public static final String EMPTY = "";
    public static final String STUDENT_DELETE_MESSAGE = "\n삭제할 학생의 ID를 입력하세요.";
    public static final String COURSE_DELETE_MESSAGE = "\n삭제할 강좌의 ID를 입력하세요.";

}
