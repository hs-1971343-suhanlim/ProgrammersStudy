class Solution {
    // 시간 복잡도 O(log n) 10^x = n 공간 복잡도 O(1)
    public boolean solution(int x) {
        int digitSum = 0;
        int save = x;
        while(save>0){
            digitSum+=save%10;
            save/=10;
        }
        return x%digitSum==0;
    }
    // 시간 복잡도 O(n) 공간 복잡도 O(n)
    public boolean solution2(int x){
        int sum = String.valueOf(x).chars().map(ch->ch-'0').sum();
        return sum%x==0;
    }
}
public class HashadNumber {
}
