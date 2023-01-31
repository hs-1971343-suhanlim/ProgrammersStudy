import java.util.Arrays;

class Solution {
    public int[] solutionFail(int N, int[] stages) {
        int[] answer = new int[N];
        int maxPeople = stages.length;
        double[] failureRate = new double[N];
        int i=0; int j=0;
        Arrays.sort(stages); // n*log n
        // 전체 스테이지 탐색
        for(int stage=1;stage<=N;stage++) {
            // 실패율의 분자
            int numerator = 0;
            for (i = 0; i < maxPeople; i++) {
                if(stage==stages[i])
                    numerator++;
                if(stage<stages[i])
                    break;
            }
            // 예외 처리
            if(i==0)
                failureRate[stage] = 0;
            else{
                // 실패율의 분모 (통과한 인원 수)
                int denominator = maxPeople-i+numerator;
                failureRate[stage-1] = (double) numerator/denominator;
            }
        }
        System.out.println("qf");
        for(i=0;i<answer.length;i++) {
            double tmp = -1; int index=-1;
            for (j = 0; j < failureRate.length; j++) {
                if(tmp<failureRate[j]){
                    tmp=failureRate[j];
                    index = j;
                }
            }
            failureRate[index] = -1;
            answer[i] = index+1;
        }
        System.out.println("qf");
        return answer;
    }

    public int[] solution(int N, int[] stages) {
        // 정수 범위를 벗어나는 경우 때문에 안됨
        int[] answer = new int[N];
        int maxPeople = stages.length;
        // 분자, 분모 순으로 저장
        long[][] failureRate = new long[N][2];
        int i=0; int j=0;
        Arrays.sort(stages); // n*log n
        // 전체 스테이지 탐색
        int numerator,denominator;
        for(int stage=1;stage<=N;stage++) {
            // 실패율의 분자
            numerator = 0;
            for (i = 0; i < maxPeople; i++) {
                if(stage==stages[i])
                    numerator++;
                if(stage<stages[i])
                    break;
            }
            // 실패율의 분모 (통과한 인원 수)
            if(numerator==0)
                denominator=1;
            else
                denominator = maxPeople-i+numerator;
            //failureRate[stage-1] = (float) numerator/denominator;
            failureRate[stage-1][0] = numerator;
            failureRate[stage-1][1] = denominator;
        }
        System.out.println("qf");
        for(i=0;i<answer.length;i++) {
            long tmp[] = {-1,1}; int index=-1;
            for (j = 0; j < failureRate.length; j++) {
                if(tmp[0]*failureRate[j][1]<failureRate[j][0]*tmp[1]){
                    tmp[0]=failureRate[j][0];
                    tmp[1]=failureRate[j][1];
                    index = j;
                }
            }
            failureRate[index][0] = -1;
            failureRate[index][1] = 1;
            answer[i] = index+1;
        }

        return answer;
    }
}
public class _2019_KAKAO_BLIND_RECRUITMENT_Level1_1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        //5	[2, 1, 2, 6, 2, 4, 3, 3]
        int tmp[] = {2,1,2,6,2,4,3,3};
        s.solutionFail(5,tmp);
        int tmp1[] = {1,1,1,1,1,1,1,1};
        s.solution(6,tmp1);
        System.out.println("Hello world!");
    }
}