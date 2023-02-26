import java.util.HashMap;

class Solution {
    // 시간 복잡도 O(mn) 공간 복잡도 O(n)
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        // 시간 복잡도 O(keymap.length()*keymap[n].length)
        for (String keyUnit: keymap) {
            for(int i=0;i<keyUnit.length();i++) {
                char key = keyUnit.charAt(i);
                int value = i+1;
                if(map.containsKey(key))
                    value = Math.min(value, map.get(key));
                map.put(key,value);
            }
        }

        // 시간 복잡도 O(targets.length()*targets[n].length)
        for(int i=0;i<targets.length;i++){
            char[] alphas = targets[i].toCharArray();
            int tmp = 0;
            for (char alpha: alphas) {
                if(!map.containsKey(alpha)){
                    tmp = -1;
                    break;
                }
                tmp += map.get(alpha);
            }
            answer[i] = tmp;
        }
        return answer;
    }
}
public class ARoughKeyboard {
    public static void main(String[] args) {
        Solution s = new Solution();
        String tmp1[] = {"AA"};
        String tmp2[] = {"B"};
        int nums[] = s.solution(tmp1,tmp2);
        for (int num: nums) {
            System.out.print(num);
        }
    }
}
