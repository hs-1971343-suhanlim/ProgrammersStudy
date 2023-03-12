class Solution {
    // 시간 복잡도 O(n) 공간 복잡도 O(1)
    public long solution(int a, int b) {
        long answer = 0;
        for(int i=(a>=b ? b : a);i<=(a>=b  ? a : b);i++)
            answer+=i;
        return answer;
    }
}
class Solution {
    // 시간 복잡도 O(1) 공간 복잡도 O(1) 
    public long solution(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
}