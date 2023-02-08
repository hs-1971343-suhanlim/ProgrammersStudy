import java.util.*;

class Solution {
    // 시간 복잡도 O(n) 공간 복잡도 O(1)
    private void deleteFirstFail(HashSet<String> cash){
        Iterator<String> it = cash.iterator();
        cash.remove(it.next());
    }
    public int solutionFail(int cacheSize, String[] cities) {
        int answer = 0;
        HashSet<String> cash = new HashSet<String>();
        for (String citie:cities) {
            String city = citie.toUpperCase();
            // 캐쉬에 없는 요소 접근
            if(!cash.contains(city)){
                if(cash.size()!=0&&cash.size()>=cacheSize)
                    deleteFirstFail(cash);
                answer+=5;
            }
            // 캐쉬에 있는 요소 접근
            else {
                cash.remove(city);
                answer++;
            }
            // 공통되는 부분이므로 밖으로 빼냄
            cash.add(city);
        }
        return answer;
    }

    // 시간 복잡도 O(n^2) LinkedList.contains의 시간 복잡도는 O(n)이기 때문
    // 공간 복잡도 O(1)
    public int solution(int cacheSize, String[] cities) {
        // 캐쉬 사이즈 0일 때의 예외 처리
        if(cacheSize==0)
            return cities.length*5;

        int answer = 0;
        Queue<String> cash = new LinkedList<String>();
        for (String citie:cities) {
            String city = citie.toUpperCase();
            // 캐쉬에 없는 요소 접근
            if(!cash.contains(city)){
                if(cash.size()!=0&&cash.size()>=cacheSize)
                    cash.remove();
                answer+=5;
            }
            // 캐쉬에 있는 요소 접근
            else
                answer++;

            cash.offer(city);
        }
        return answer;
    }
}
public class _2018_KAKAO_BLIND_RECRUITMENT_Level2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String tmp[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        s.solution(3,tmp);
    }
}
