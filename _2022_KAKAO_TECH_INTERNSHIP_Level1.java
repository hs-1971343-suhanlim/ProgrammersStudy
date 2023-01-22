import java.util.HashMap;

class Solution {
    // 시간복잡도 O(n) 공간 복잡도 O(n)
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder("");
        // survey의 원소는 "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" 중 하나입니다.
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("RT",0); map.put("TR",0); map.put("FC",1); map.put("CF",1);
        map.put("MJ",2); map.put("JM",2); map.put("AN",3); map.put("NA",3);
        // 1 ≤ choices의 원소 ≤ 7
        // 추가해야 할 자료형: 이차원 정수형 배열
        int characterPoints[][] = new int[4][2];
        //{{R,T},{C,F},{J,M},{A,N}}
        /*
        1번 지표	라이언형(R), 튜브형(T)
        2번 지표	콘형(C), 프로도형(F)
        3번 지표	제이지형(J), 무지형(M)
        4번 지표	어피치형(A), 네오형(N)
         */
        // 일차원 문자열 배열
        String characterUnion[] = {"RT","CF","JM","AN"};
        // {{RT},{CF},{JM},{AN}}
        /*
        1	매우 비동의 -3
        2	비동의 -2
        3	약간 비동의 -1
        4	모르겠음
        5	약간 동의 -1
        6	동의 -2
        7	매우 동의 -3
         */
        // 해야 할일: swich 문 사용
        for(int i=0;i<choices.length;i++){
            int dIndex = map.get(survey[i]);
            int oFindex = characterUnion[dIndex].equals(survey[i])?0:1;
            int oSindex = oFindex==0?1:0;


            switch (choices[i]){
                case 1: characterPoints[dIndex][oFindex] +=3; break;
                case 2: characterPoints[dIndex][oFindex] +=2; break;
                case 3: characterPoints[dIndex][oFindex] +=1; break;
                case 5: characterPoints[dIndex][oSindex] +=1; break;
                case 6: characterPoints[dIndex][oSindex] +=2; break;
                case 7: characterPoints[dIndex][oSindex] +=3; break;
                default: break;
            }
        }
        /*
        최종적인 작업: 이차원 배열을 만큼을 반복문 해서
        처음 것이 크면 answer.append(subString(0,1))
        다음 것이 크면 answer.append(subString(1,2))
         */
        for(int i=0;i<characterPoints.length;i++){
            if(characterPoints[i][0]>=characterPoints[i][1])
                answer.append(characterUnion[i].substring(0,1));
            else
                answer.append(characterUnion[i].substring(1,2));
        }

        return answer.toString();
    }
}
public class _2022_KAKAO_TECH_INTERNSHIP_Level1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        //	["AN", "CF", "MJ", "RT", "NA"], [5, 3, 2, 7, 5]
        String tmp[] = {"AN", "CF", "MJ", "RT", "NA"};
        int tmp2[] = {5, 3, 2, 7, 5};
        //["TR", "RT", "TR"]	[7, 1, 3]
        String tm3[] = {"TR", "RT", "TR"};
        int tmp4[] = {7, 1, 3};

        System.out.println(s.solution(tmp,tmp2));
        System.out.println(s.solution(tm3,tmp4));

        System.out.println("Hello world!");
    }
}