class Solution {
    // 시간 복잡도 O(1) 공간 복잡도 O(1)
    private String engSearchChange(String s){
        StringBuffer sForm = new StringBuffer(s);
        String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0;i<10;i++){
            while(sForm.indexOf(num[i])!=-1)
                sForm.replace(sForm.indexOf(num[i]),
                        sForm.indexOf(num[i])+num[i].length(), Integer.toString(i));
        }
        return sForm.toString();
    }
    public int solution(String s) {
        String tmp = engSearchChange(s);
        int answer = Integer.parseInt(tmp);
        return answer;
    }
    // 가장 극찬 받은 풀이의 코드
    public int solution2(String s) {
        String alp[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String digit[] = {"0","1","2","3","4","5","6","7","8","9"};

        for(int i=0;i<10;i++){
            s.replaceAll(alp[i],digit[i]);
        }
        return Integer.parseInt(s);
    }
}
public class _2021_KAKAO_BLIND_RECRUITMENT_level1_1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("23four5six7");
        String tmp = "12zero3";
        StringBuffer tb = new StringBuffer(tmp);
        System.out.println(tmp.indexOf("zero"));
        System.out.println(tb.replace(tmp.indexOf("zero"),tmp.indexOf("zero")+4,"0"));
        System.out.println("Hello world!");
    }
}