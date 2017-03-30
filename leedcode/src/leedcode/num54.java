package leedcode;

import java.util.ArrayList;
import java.util.List;

public class num54 {

    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> list=new ArrayList<Integer>();
        if(matrix.length==0)
            return list;
        if(matrix.length==1&&matrix[0].length==1){
        	list.add(matrix[0][0]);
            return list;
        }
        
    	int right=matrix[0].length-1;
    	int down=matrix.length-1;
    	int left=0;
    	int up=1;
    	int x=0;
    	int y=-1;
    	int status=0;
        if(matrix.length>1&&matrix[0].length==1){
        	status=1;
        	x=-1;
        	y=0;
        }
    	while(!((status==1&&x==down)||(status==2&&y==left)||(status==3&&x==up)||(status==0&&y==right))){
    		switch(status){
    			case 0:for(y=y+1;y<=right;y++){
    				list.add(matrix[x][y]);
    			}
    			y--;
				right--;
    			break;
    			case 1:for(x=x+1;x<=down;x++){
    				list.add(matrix[x][y]);
    			}
    			x--;
				down--;
    			break;
    			case 2:for(y=y-1;y>=left;y--){
    				list.add(matrix[x][y]);
    			}
    			y++;
				left++;
    			break;
    			case 3:for(x=x-1;x>=up;x--){
    				list.add(matrix[x][y]);
    			}
    			x++;
				up++;
    			break;
    		}
    		status=(status+1)%4;
    	}
        return list;
    }
	public static void main(String[] args) {
		num54 sol=new num54();
		int[][] test={{2},{4}};
		System.out.println(sol.spiralOrder(test));

	}

}
