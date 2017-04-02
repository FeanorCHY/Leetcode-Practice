import java.util.Arrays;
import java.util.Comparator;

public class num452 {

    public int findMinArrowShots(int[][] points) {
        if(points==null||points.length==0)
            return 0;
        int res=1;
        Arrays.sort(points,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[0]==b[0])
                    return a[1]-b[1];
                return a[0]-b[0];
            }
        });
        int end=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>end){
                end=points[i][1];
                res++;
            }
            else
                end=Math.min(end,points[i][1]);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
