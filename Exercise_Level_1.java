class Solution {
    // 시간 복잡도 O(n) 공간 복잡도 O(1)
    public int solution(int n) {
        int answer = 0;
        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                answer+=i;
        }
        return answer+=n<=1?n:n+1;
    }
}
public class Exercise_Level_1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}