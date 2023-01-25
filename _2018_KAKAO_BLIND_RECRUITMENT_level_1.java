class Solution {
    // 시간 복잡도 O(n^2) 공간 복잡도 O(n)
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder mapMaker = new StringBuilder("");
        // 벽의 정보는 이진법으로 저장되어 있음
        // or 연산을 통해 1개라도 벽이라면 벽으로 처리
        for(int i=0;i<n;i++)
            arr1[i] |= arr2[i];

        for(int j=0;j<n;j++){
            int target = arr1[j];
            // 제일 높은 지수의 자리 부터 판별
            for(int i=n-1;i>=0;i--){
                int mask = (int)Math.pow(2,i);
                if((target&mask)==0)
                    mapMaker.append(" ");
                else
                    mapMaker.append("#");
            }
            answer[j] = mapMaker.toString();
            mapMaker.delete(0,mapMaker.length());
        }

        return answer;
    }
}
public class _2018_KAKAO_BLIND_RECRUITMENT_level_1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}