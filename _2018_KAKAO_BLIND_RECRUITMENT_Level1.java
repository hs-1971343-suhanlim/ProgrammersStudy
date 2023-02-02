import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    private int pointCalculator(String chance){
        int point = 0;
        // 정수는 0~10사이의 정수 즉 한자리 수
        int tmp = Integer.parseInt(chance.substring(0,1));
        if(chance.charAt(1)=='S')
            point+=Math.pow(tmp,1);
        else if(chance.charAt(1)=='D')
            point+=Math.pow(tmp,2);
        else
            point+=Math.pow(tmp,3);

        if(chance.length()>=3) {
            if (chance.charAt(2) == '*')
                point *= 2;
            else
                point*=-1;
        }
        return point;
    }
    // 시간 복잡도 O(n) 공간 복잡도 O(n)
    public int solution(String dartResult) {
        int answer = 0;
        char charArray[] = dartResult.toCharArray();
        // 얻을 수 있는 point는 3종류 이지만 * 아이템을 처리 하기위해 맨 앞에 공간을 하나 더 만들어줌
        int points[] = new int[4];

        int turn = 1;
        int point = 0;
        for(int i=0;i<charArray.length;i++){
            // 점수 부분
            if(charArray[i]>='0'&&charArray[i]<='9') {
                if(charArray[i+1]>='0'&&charArray[i+1]<='9')
                    point += Integer.parseInt(charArray[i]+""+charArray[i+1]+"");
                else
                    point += Integer.parseInt(charArray[i] + "");
            }
            // 점수 보너스 부분
            else if(charArray[i]=='S'||charArray[i] == 'D'||charArray[i] == 'T'){
                if (charArray[i] == 'S')
                    point = (int)Math.pow(point, 1);
                else if (charArray[i] == 'D')
                    point = (int)Math.pow(point, 2);
                else
                    point = (int)Math.pow(point, 3);

                // 만약 다음 문자가 없거나 특수 문자가 아니라면 해당 점수를 저장하고 다음 점수로 파트로 넘아감
                if(i+1==charArray.length||(charArray[i+1]>='0'&&charArray[i+1]<='9')){
                    points[turn] = point;
                    turn++; point=0;
                }

            }
            // 특수 아이템 부분
            else{
                if(charArray[i]=='*') {
                    point *= 2;
                    points[turn-1]*=2;
                }
                else
                    point*=-1;

                points[turn] = point;
                point=0;
                turn++;

            }
        }

        for (int num: points) {
            answer+=num;
        }
        return answer;
    }
}

class SolutionOtimal {
    static int[] sum = new int[3];
    static int solution(String msg){
        String reg = "([0-9]{1,2}[S|T|D][*|#]{0,1})";
        Pattern p = Pattern.compile(reg+reg+reg);
        Matcher m = p.matcher(msg);
        m.find();
        for(int i=1; i<=m.groupCount(); i++){
            Pattern p1 = Pattern.compile("([0-9]{1,2})([S|T|D])([*|#]{0,1})");
            Matcher m1 = p1.matcher(m.group(i));
            m1.find();
            sum[i-1] = (int)Math.pow(Integer.parseInt(m1.group(1)), getpow(m1.group(2)));
            setting(i,m1.group(3));
        }
        return(sum[0]+ sum[1]+ sum[2]);
    }
    static void setting(int idx, String msg){
        if(msg.equals("*")){
            sum[idx - 1] *= 2;
            if(idx > 1 ){
                sum[idx - 2] *=2;
            }
        }
        else if(msg.equals("#")){
            sum[idx - 1] *=-1 ;
        }
    }
    static int getpow(String mag){
        if(mag.equals("S")){
            return 1;
        }
        else if(mag.equals("D")){
            return 2;
        }
        else {
            return 3;
        }

    }

}

public class _2018_KAKAO_BLIND_RECRUITMENT_Level1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("1D2S#10S");
        System.out.println(s.solution("1D2S#10S"));
        System.out.println("Hello world!");
        System.out.println(Character.isDigit('0'));
    }
}