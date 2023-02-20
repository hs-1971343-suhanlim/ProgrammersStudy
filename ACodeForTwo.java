class Solution {
    // 시간 복잡도 O(n^2) 공간 복잡도 O(n)
    public boolean isSkip(char skipArray[],char input){
        for (char c: skipArray) {
            if(input==c)
                return true;
        }
        return false;
    }
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder("");
        char sArray[] = s.toCharArray();
        char skipArray[] = skip.toCharArray();

        for (char sApa: sArray) {
            for(int i=0;i<index;i++){
                if(sApa=='z')
                    sApa='a'-1;
                sApa++;
                if(isSkip(skipArray,sApa))
                    i--;
            }
            answer.append(sApa);
        }
        return answer.toString();
    }
}
public class ACodeForTwo {
}
