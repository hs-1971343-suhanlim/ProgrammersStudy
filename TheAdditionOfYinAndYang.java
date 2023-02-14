class Solution {
    // 시간 복잡도 O(n) 공간 복잡도 O(1)
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i=0;i<absolutes.length;i++){
            answer+=absolutes[i]*(signs[i]?1:-1);
        }
        return answer;
    }
}
public class TheAdditionOfYinAndYang {
}
