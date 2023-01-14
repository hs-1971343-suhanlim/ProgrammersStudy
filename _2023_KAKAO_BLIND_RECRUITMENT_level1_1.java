import java.util.Vector;
// split() 함수를 안쓰는 이유는 시간적으로 소모가 크기 때문 가급적 substring()으로 해결
class Solution {
    // "1971.12.01" 형식의 날짜를 day 수로 변환하는 함수
    private int getParseIntDay(String date){
        int day = 0;
        day+=Integer.parseInt(date.substring(0,4))*28*12;
        day+=Integer.parseInt(date.substring(5,7))*28;
        day+=Integer.parseInt(date.substring(8,10));
        return day;
    }
    // 시간 복잡도 O(n+m) 공간 복잡도 O(n+m);
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.
        int[] answer = {};
        int dDay = getParseIntDay(today); // 마감기한 구하기
        int[] privaciesInt = new int[privacies.length]; // 저장할 제품기간의 공간
        Vector<Integer> v = new Vector<Integer>(); // 폐기해야 할 데이터의 번호들을 효과적을 저장할 자료구조
        // 제품의 유통기한을 day 수로 변환하여 저장
        for(int i=0;i<privaciesInt.length;i++)
            privaciesInt[i] = getParseIntDay(privacies[i].substring(0,10));
        // (브루트 포스) 모든 경우 검사
        for(int i=0;i< privacies.length;i++){
            for(int j=0;j< terms.length;j++) {
                // 만약 제품의 약관 종류가 같다면 해당 약관의 day만큼 추가
                if (privacies[i].charAt(privacies[i].length()-1)==
                        terms[j].charAt(0)){
                    String mouth = terms[j].substring(2,terms[j].length());
                    privaciesInt[i]+=Integer.parseInt(mouth)*28;
                }
            }
        }
        // 폐기해야할 제품 번호 저장
        for(int i=0;i<privaciesInt.length;i++){
            if(dDay>=privaciesInt[i])
                v.add(i+1);
        }

        int ans[] = new int[v.size()];
        for(int i=0;i<ans.length;i++)
            ans[i] = v.get(i);
        answer = ans;

        return answer;
    }
}
public class _2023_KAKAO_BLIND_RECRUITMENT_level1_1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        //int tmp = s.getParseIntDay("1000.01.01");
        String tmp1 = "2020.01.01";
        String tmp2[] = {"Z 3", "D 5"};
        String tmp3[] = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        s.solution(tmp1,tmp2,tmp3);
    }
}