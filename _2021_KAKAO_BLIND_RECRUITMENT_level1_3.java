import java.util.stream.Stream;

class Solution {
    // 시간 복잡도 O(n) 공간 복잡도 O(1)
    public String solution(String new_id) {
        // step 1
        // 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id=new_id.toLowerCase();
        // step 2
        // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id=new_id.replaceAll("[^[a-z][0-9]-._]","");
        // step 3
        // 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < new_id.length()-1; i++) {
            if(new_id.charAt(i)=='.'&&new_id.charAt(i+1)=='.')
                continue;
            ans.append(new_id.charAt(i));
        }
        if(new_id.charAt(new_id.length()-1)!='.')
            ans.append(new_id.charAt(new_id.length()-1));
        // new_id=new_id.replaceAll("[.]{2,}",".");
        // step 4
        // new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(ans.length()!=0){
            if(ans.charAt(0)=='.')
                ans.deleteCharAt(0);
            if(ans.charAt(ans.length()-1)=='.')
                ans.deleteCharAt(ans.length()-1);
        }
        // new_id=new_id.replaceAll("^[.]|[.]$","");
        // step 5
        // new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(ans.length()==0)
            ans.append("a");
        // step 6
        // new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(ans.length()>=16)
            ans.delete(15,ans.length());
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(ans.charAt(ans.length()-1)=='.')
            ans.deleteCharAt(ans.length()-1);
        // step 7
        // new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(ans.length()<=2)
            while(ans.length()<3){
                ans.append(ans.charAt(ans.length()-1));
            }

        return ans.toString();
    }
}
public class _2021_KAKAO_BLIND_RECRUITMENT_level1_3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("=.="));
        String tmp = "aBD9559-1....13_1-";
        System.out.println(tmp);
        // .이 반복으로 들어간 경우를 제거
        tmp = tmp.replaceAll("[.]{2,}",".");
        System.out.println(tmp);
        // 알파벳 소문자 a~z 와 숫자 0~9와 -._을 제외하고 제거
        tmp=tmp.replaceAll("[^[a-z][0-9]-._]","");
        System.out.println(tmp);
        // 알파벳 소문자 a~z 와 -._을 제외하고 제거
        tmp=tmp.replaceAll("[^[a-z]-._]","");
        System.out.println(tmp);
        // -._ 문자 제거
        tmp=tmp.replaceAll("[-._]","");
        System.out.println(tmp);

    }
}