import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution2(long n) {
        long answer = 0;
        String tmp = Long.toString(n);
        char array[] = tmp.toCharArray();
        Integer toIntArray[] = new Integer[array.length];
        for (int i=0;i<array.length;i++)
            toIntArray[i] = Integer.parseInt(array[i]+"");
        Arrays.sort(toIntArray,Collections.reverseOrder());

        for (int i=toIntArray.length;i>=1;i--)
            answer += Math.pow(10,i-1)*toIntArray[toIntArray.length-i];

        return answer;
    }

    public long solution3(long n) {
        String tmp = Long.toString(n);
        char[] array = tmp.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (char unit : array) sb.insert(0,unit);
        return Long.parseLong(sb.toString());
    }
    public long solutionOtimal(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.insert(0,aList);

        return Long.parseLong(sb.toString());
    }
}
public class SortingInteger {
}
