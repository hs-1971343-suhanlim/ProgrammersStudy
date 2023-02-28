class Solution {
    // 시간 복잡도 O(log n) Math.sqrt()가 log n이기 때문에 공간 복잡도 O(1)
    public long solution(long n) {
        if(Math.sqrt(n)!=(int)Math.sqrt(n))
            return -1;
        return (long)Math.pow(Math.sqrt(n)+1,2);
    }
}
public class WholeNumberRoot {
}
