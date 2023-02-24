import java.util.*;

class Solution {
    // 시간 복잡도 O(n) 공간 복잡도 O(n)
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        for(int i=1;i<n;i++)
            answer[i]=answer[i-1]+x;
        
        return answer;
    }
}