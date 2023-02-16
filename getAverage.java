import java.util.Arrays;
import java.lang.*;
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for (int n: arr) {
            answer+=(double)n/arr.length;
        }
        return answer;
    }
    public double solution2(int[] arr){
        return Arrays.stream(arr).average().getAsDouble();
    }
}
public class getAverage {
}
