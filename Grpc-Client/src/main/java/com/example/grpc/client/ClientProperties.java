package com.example.grpc.client;

public interface ClientProperties {
    public static final String  LINE ="===============================================";
    public static final String EXIT = "프로그램을 종료합니다.";
    public static final String WRONG_NUM = "❗️❗️❗없는 메뉴를 선택하셨습니다❗️❗️❗";
    public static final String INPUT_ID_MSG = "ID를 입력하세요:";
    public static final String INPUT_NAME_MSG = "이름을 입력하세요:";
    public static final String INPUT_COURSENAME_MSG = "강좌명을 입력하세요:";
    public static final String INPUT_PRECOURSE_MSG = "선수과목의 ID를 입력하세요 ('/'로 구분. 예시: 1010/1011 ) :";
    public static final String INPUT_PROFNAME_MSG = "담당 교수를 입력하세요:";
    public static final String INPUT_MAJOR_MSG = "전공을 입력하세요:";
    public static final String REGISTER_COURSE_STDID = "수강신청을 진행할 학생의 ID를 입력하세요 :";
    public static final String REGISTER_COURSE_COURSEID = "수강신청할 과목의 ID를 입력하세요:";
    public static final String INPUT_NUMBER = "❗️❗️❗숫자를 입력해주세요❗️❗️❗️";
    public static final String INPUT_STUDENT_NUM_AGAIN = "❗️❗️❗학생번호를 다시 입력해주세요❗️❗️❗️";
    public static final String INPUT_COURSE_NUM_AGAIN = "❗️❗️❗강좌번호를 다시 입력해주세요❗️❗️❗️";
    public static final String NULL_DATA_INPUT_AGAIN = "❗️❗️❗ 입력하지 않은 데이터가 있습니다. 다시 시도해주세요.❗️❗️❗️";
    public static final String NOTexistIDstd = "❗️❗️❗존재하지 않는 학생 아이디를 입력하셨습니다❗️❗️❗️";
    public static final String alreadyEcourse = "❗️❗️❗이미 등록된 강좌번호를 입력하셨습니다❗️❗️❗️";
    public static final String alreadyEstd = "❗️❗️❗이미 등록된 학생번호를 입력하셨습니다❗️❗️❗️";
    public static final String NOTexistIDcourse = "❗️❗️❗존재하지 않는 강좌번호를 입력하셨습니다❗️❗️❗";
    public static final String success = "🥳 성공적으로 반영되었습니다! 🥳";
    public static final String fail = "❗️❗️❗실패하였습니다. 다시 시도해주세요❗️❗️❗";
    public static final String NOTexistID = "❗️❗️❗알 수 없는 이유로 실패하였습니다. 다시 시도해주세요❗️❗️❗";
    public static final String HaveToTakePre = "❗️❗️❗선수과목을 수강하지 않았습니다.❗️❗️❗️";
}
