import java.util.ArrayList;
import java.util.List;

public class num054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<Integer>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return res;
        int right=matrix[0].length-1;
        int left=0;
        int up=1;
        int bottom=matrix.length-1;
        int x=0;
        int y=0;
        while(y<=right){
            while(y<=right){
                res.add(matrix[x][y++]);
            }
            right--;
            y--;
            x++;
            if(x>bottom)
                break;
            while(x<=bottom)
                res.add(matrix[x++][y]);
            bottom--;
            x--;
            y--;
            if(y<left)
                break;
            while(y>=left)
                res.add(matrix[x][y--]);
            left++;
            y++;
            x--;
            if(x<up)
                break;
            while(x>=up)
                res.add(matrix[x--][y]);
            up++;
            x++;
            y++;
        }
        
        
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
