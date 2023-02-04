import java.util.Arrays;
import java.util.HashSet;

class Solution {
    // 시간 복잡도 O(n) 공간 복잡도 O(n)
    public int[] solution1(int[] lottos, int[] win_nums){
        int []answer = new int[2];
        HashSet<Integer> set = new HashSet<Integer>();
        int zeroCount = 0;
        int correctCount = 0;
        for (int lotto:lottos) {
            if(lotto==0)
                zeroCount++;
            else
                set.add(lotto);
        }
        for (int num: win_nums) {
            if(set.contains(num))
                correctCount++;
        }

        int maxCorrect = zeroCount+correctCount;
        int maxRank = 7-maxCorrect;
        answer[0] = maxRank>=6?6:maxRank;

        int minRank = 7-correctCount;
        answer[1] = minRank>=6?6:minRank;

        return answer;

    }
    // 시간 복잡도 O(nlog n) 공간 복잡도 O(n)
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(win_nums);
        int zeroCount = 0;
        int correctCount = 0;
        for (int lotto: lottos) {
            if(lotto==0)
                zeroCount++;
            else
                break;
        }

        //zeroCount = zeroCount==0?1:zeroCount;
        for (int num:win_nums) {
            int first = zeroCount;
            int last = lottos.length-1;
            while(first<=last){
                int mid = (first+last)/2;
                if(lottos[mid]>num)
                    last = mid-1;
                else if(lottos[mid]<num)
                    first = mid+1;
                else {
                    correctCount++;
                    break;
                }
            }
        }

        int maxCorrect = zeroCount+correctCount;
        int maxRank = 7-maxCorrect;
        answer[0] = maxRank>=6?6:maxRank;

        int minRank = 7-correctCount;
        answer[1] = minRank>=6?6:minRank;

        return answer;
    }
}
public class _2021_Dev_Matching_Level1 {
    public static void main(String[] args) {
        // [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]
        Solution s = new Solution();
        int tmp1[] = {44, 1, 0, 0, 31, 25};
        int tmp2[] = {31, 10, 45, 1, 6, 19};
        s.solution(tmp1,tmp2);
        System.out.println("Hello world!");
    }
}