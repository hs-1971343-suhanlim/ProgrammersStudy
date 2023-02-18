class Solution {
    // 시간 복잡도 O(n) 공간 복잡도 O(n)
    public int[] solution(long n) {
        String num = String.valueOf(n);
        char array[] = num.toCharArray();
        int[] answer = new int[array.length];
        int index=0;
        for(int i=array.length-1;i>=0;i--){
                answer[index++]=Integer.parseInt(array[i]+"");
        }

        System.out.println("kest");
        return answer;
    }
}

class Solution2{
    // 시간 복잡도 O(n) 공간 복잡도 O(n)
    public int[] solution(long n){
        String a = ""+n;
        int answer[] = new int[a.length()];
        int index = 0;
        while(n>0){
            answer[index++] = (int)(n%10);
            n/=10;
        }
        return answer;
    }
}
public class ReverseArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        long n = 10000000;
        s.solution(n);
    }
}
