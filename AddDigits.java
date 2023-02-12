import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String tmp = String.valueOf(n);
        char digits[] = tmp.toCharArray();
        for (char digit: digits)
            answer+=Integer.parseInt(digit+"");

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java"+tmp);

        return answer;
    }
}
public class AddDigits {
    public static void main(String[] args) {
        int n = 1210;
        String tmp = String.valueOf(n);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java"+tmp);

    }
}
