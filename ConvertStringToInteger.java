class Solution {
    public int solution(String s) {
        return Integer.parseInt(s);
    }
}
class StrToInt {
    public int getStrToInt(String str) {
        boolean Sign = true;
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '-')
                Sign = false;
            else if(ch !='+')
                result = result * 10 + (ch - '0');
        }
        return Sign?1:-1 * result;
    }
}

public class ConvertStringToInteger {
}
