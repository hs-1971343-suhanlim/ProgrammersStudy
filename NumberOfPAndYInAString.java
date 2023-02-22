
class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();
        int pCount = 0;
        int yCount = 0;
        char array[] = s.toCharArray();
        for (char unit : array) {
            if (unit == 'P')
                pCount++;
            if (unit == 'Y')
                yCount++;

        }
        return pCount==yCount;
    }
    boolean solution2(String s) {
        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }
}
public class NumberOfPAndYInAString {
    public static void main(String[] args) {

    }
}
