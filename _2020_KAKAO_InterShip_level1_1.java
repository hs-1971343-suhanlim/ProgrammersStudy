class Solution {
    //시간 복잡도 O(n), 공간 복잡도 O(1)
    public String whichIsNeer(int left[], int right[], int targetY, String samePoint){
        int pos[] = {2,targetY};
        int leftGap = Math.abs(pos[0]-left[0])+Math.abs(pos[1]-left[1]);
        int rightGap = Math.abs(pos[0]-right[0])+Math.abs(pos[1]-right[1]);
        if(rightGap<leftGap)
            return "R";
        else if(leftGap<rightGap)
            return "L";
        else return samePoint;
    }
    public String solution(int[] numbers, String hand) {
        String samePoint = hand.equals("right")?"R":"L";
        // 문자열길이를 수정할 때는 StringBuilder가 가장 효율적임
        StringBuilder answer = new StringBuilder("");
        // x,y좌표 저장
        //  1-1   2-1   3-1
        //  1-2   2-2   3-2
        //  1-3   2-3   3-3
        //  1-4   2-4   3-4
        int leftLocation[] = {1,4}; // 위에서 부터 1 2 3 4는 *
        int rightLocation[] = {3,4}; // 위에서 부터 1 2 3 4는 #

        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7) {
                answer.append("L");
                leftLocation[0] = 1;
                leftLocation[1] = (numbers[i]+2)/3;
            }
            else if(numbers[i]==3||numbers[i]==6||numbers[i]==9) {
                answer.append("R");
                rightLocation[0] = 3;
                rightLocation[1] = numbers[i]/3;
            }
            // 핵심
            else{
                int posY = 4;
                if(numbers[i]!=0)
                    posY=(numbers[i]+1)/3;
                String tmp = whichIsNeer(leftLocation,rightLocation,posY,samePoint);
                if(tmp.equals("L")) {
                    leftLocation[0] = 2;
                    leftLocation[1] = posY;
                }
                else {
                    rightLocation[0] = 2;
                    rightLocation[1] = posY;
                }
                answer.append(tmp);
            }
        }
        return answer.toString();
    }
}
public class _2020_KAKAO_InterShip_level1_1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int tmp[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        s.solution(tmp, "right");
        System.out.println("Hello world!");
    }
}