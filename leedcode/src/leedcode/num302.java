package leedcode;

public class num302 {
	int left=-1;
	int right=-1;
	int up=-1;
	int down=-1;
	boolean visit[][];
    public int minArea(char[][] image, int x, int y) {
    	if(left==-1){
    		down=x;
    		up=x;
    		left=y;
    		right=y;
    		if(image.length==0)
    			return 0;
    		visit=new boolean[image.length][image[0].length];
    		visit[x][y]=true;
    	}
    	else{
    		if(up>x)
    			up=x;
    		if(down<x)
    			down=x;
    		if(left>y)
    			left=y;
    		if(right<y)
    			right=y;
    	}
    	if(x>0&&!visit[x-1][y]&&image[x-1][y]=='1'){
    		visit[x-1][y]=true;
    		minArea(image,x-1,y);
    	}
    	if(x<image.length-1&&!visit[x+1][y]&&image[x+1][y]=='1'){
    		visit[x+1][y]=true;
    		minArea(image,x+1,y);
    	}
    	if(y>0&&!visit[x][y-1]&&image[x][y-1]=='1'){
    		visit[x][y-1]=true;
    		minArea(image,x,y-1);
    	}
    	if(y<image[0].length-1&&!visit[x][y+1]&&image[x][y+1]=='1'){
    		visit[x][y+1]=true;
    		minArea(image,x,y+1);
    	}
    	
    	
        return (down-up+1)*(right-left+1);
    }
	public static void main(String[] args) {
		char[][] test={"0010".toCharArray(),"0110".toCharArray(),"0100".toCharArray()};//{{'1'},{'1'}};
		num302 sol=new num302();
		System.out.println(sol.minArea(test, 0, 2));
	}

}
