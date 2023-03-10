import java.util.TreeSet;

class Solution {
    // 시간 복잡도 O(n^2) 공간 복잡도 O(n)
    public int[] solution(String[] wallpaper) {
        TreeSet<Integer> x = new TreeSet<Integer>();
        TreeSet<Integer> y = new TreeSet<Integer>();
        for (int col=0;col<wallpaper.length;col++) {
            char []units = wallpaper[col].toCharArray();
            for(int row=0;row<units.length;row++){
                if(units[row]=='#'){
                    x.add(row);
                    y.add(col);
                }
            }
        }

        return new int[]{y.first(),x.first(),y.last()+1,x.last()+1};
    }
    // 시간 복잡도 O(n^2) 공간 복잡도 O(1)
    public int[] solutionOtimal(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=0; i< wallpaper.length;i++ ){
            for(int j=0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        return new int[]{minX,minY,maxX+1,maxY+1};
    }
}
public class CleanUpDesktop {
}
