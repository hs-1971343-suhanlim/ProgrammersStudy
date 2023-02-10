import java.util.*;
import java.util.stream.Collectors;

class Solution {
    // 시간 복잡도 O(n*m) 공간 복잡도 O(n)
    public int[] solution(String s) {
        ArrayList<String> units = new ArrayList<String>();
        // 업 캐스팅 자식 타입 객체가 부모 객체로 형변환
        List<String> sortedUnits = new ArrayList<String>();
        String tmp = s.substring(1,s.length()-1);
        // 괄호를 제거한 튜플의 각 원소들을 리스트 형태로 추출
        units = getUnits(tmp);
        // 문자열 길이에 따른 정렬
        sortedUnits=units.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());

        return makeTuple(sortedUnits);
    }
    // 시간 복잡도 O(1) 공간 복잡도 O(n)
    private ArrayList<String> getUnits(String s){
        ArrayList<String> ans = new ArrayList<String>();
        int frontBraCapIndex = 0;
        int beforeBraCapIndex = 0;
        while(true){
            frontBraCapIndex=s.indexOf("{",frontBraCapIndex);
            beforeBraCapIndex=s.indexOf("}",beforeBraCapIndex);
            if(frontBraCapIndex==-1||beforeBraCapIndex==-1) break;
            ans.add(s.substring((frontBraCapIndex++)+1,beforeBraCapIndex++));
        }
        return ans;
    }
    // 시간 복잡도 O(n*m) 공간 복잡도 O(n)
    private int[] makeTuple(List<String> sortedUnits){
        int tuple[] = new int[sortedUnits.size()];
        HashSet<Integer> duplicateChecker = new HashSet<Integer>();
        int tupleIndex = 0;
        for (String unit:sortedUnits) {
            String numArray[] = unit.split(",");
            for (String num: numArray) {
                int transNum = Integer.parseInt(num);
                if(!duplicateChecker.contains(transNum))
                    tuple[tupleIndex++]=transNum;
                duplicateChecker.add(transNum);
            }
        }
        //System.out.println("test");
        return tuple;
    }
}
public class _2019_Kakao_Developer_Winter_Internship_level2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        //String test = "123";
        //String testA[] = test.split(",");
        //System.out.println(testA[0]);
        //String tmp = "{{123,2,3},{123},{2,123}}";
        //String tmp = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String tmp = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        s.solution(tmp);
        String arr[] = {"abcdef","a","abcd","abc","abcde"};
        //Arrays.sort(arr, (a, b)->{return b.length()-a.length();});
        //System.out.println("test");
        // 오름차순
        //String arr[] = {"abcdef","a","abcd","abc","abcde"};
        List<String> units = Arrays.asList(arr);
        List<String> sortedUnits;
// 문자열 추가 작업 생략
        sortedUnits=units.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        arr = sortedUnits.toArray(new String[sortedUnits.size()]);

// 내림 차순
        String arr2[] = {"abcdef","a","abcd","abc","abcde"};
        List<String> units2 = Arrays.asList(arr);
        List<String> sortedUnits2;
        sortedUnits2=units2.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        arr2 = sortedUnits2.toArray(new String[sortedUnits.size()]);
        System.out.println("test");
    }
}
