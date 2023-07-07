package util;

/**
 * Pattern, Matcher 클래스를 사용하여 정규 표현식을 다룰 수 있음
 * replaceAll 도 이용할 수 있음
 */
public class 정규식_모음 {
    // 숫자만 허용
    static final String REGEXP_NUMBER = "^[0-9]*$";
    // 숫자를 제외한 문자
    static final String REGEXP_NO_NUMBER = "[^0-9]*$";

    // 대소구분 없는 영문만 허용하는 정규식
    static final String REGEXP_EN = "^[a-z|A-Z]*$";

    // 소문자만 허용하는 정규식
    static final String REGEXP_LOWER_CASE = "^[a-z]*$";

    // 대문자만 허용하는 정규식
    static final String REGEXP_UPPER_CASE = "^[A-Z]*$";

    // 한글만 허용하는 정규식
    static final String REGEXP_KR = "^[ㄱ-ㅎ|가-힣]*$";

    // 대소구분 없는 영문과 한글만 허용하는 정규식
    static final String REGEXP_ONLY_CHAR = "^[a-z|A-Z|ㄱ-ㅎ|가-힣]*$";
    static final String REGEXP_ONLY_SPACE_CHAR = "^[a-z|A-Z|ㄱ-ㅎ|가-힣| ]*$";

    // 대소구분 없는 영문과 한글, 숫자를 허용하는 정규식
    static final String REGEXP_CHAR_NUM = "^[0-9a-zA-Zㄱ-ㅎ가-힣]*$";
    static final String REGEXP_CHAR_SPACE_NUM = "^[0-9a-zA-Zㄱ-ㅎ가-힣 ]*$";

    // 특수 문자 제거 용도
    static final String REGEXP_SPECIAL = "[~!@#$%^&*()=+\\['{\\]'}:?,<>/]";

    // \w : 알파멧, 숫자, _ = [a-zA-Z_0-9]
    public static void main(String[] args) {

    }
}
