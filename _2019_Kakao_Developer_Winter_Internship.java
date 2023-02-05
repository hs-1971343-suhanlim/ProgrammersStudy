import java.util.ArrayList;

class Solution {
    private int pickUp(int [][]board, int num){
        int doll=0;
        for(int i=0;i<board.length;i++){
            if(board[i][num-1]!=0){
                doll = board[i][num-1];
                board[i][num-1] = 0;
                break;
            }
        }
        return doll;
    }
    // 시간 복잡도 O(n*m) 공간 복잡도 O(n)
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> collections = new ArrayList<Integer>();
        // length-1 = -1 방지
        collections.add(0);
        for(int i=0;i<moves.length;i++){
            int lastIndex = collections.size()-1;
            int before = collections.get(lastIndex);
            int curr = pickUp(board,moves[i]);
            if(curr == 0)
                continue;
            if(before==curr) {
                collections.remove(lastIndex);
                answer+=2;
            }
            else
                collections.add(curr);
        }

        return answer;
    }
}
public class _2019_Kakao_Developer_Winter_Internship {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}