package leedcode;

public class num365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if(x>y){
        	int tem=x;
        	x=y;
        	y=tem;
        }
        if(x==z||y==z)
        	return true;
        if(x+y<z)
        	return false;
        if(x==0||y==0){
        	if(x+y!=z)
        		return false;
    		else 
        		return true;
        }
        int be=x;
        int to=y;
        while(to%be!=0){
        	int tem=be;
        	be=to%be;
        	to=tem;
        }
        if(z%be==0)
        	return true;
    	else
    		return false;
    }
	public static void main(String[] args) {
		num365 sol=new num365();
		System.out.println(sol.canMeasureWater(6, 9, 1));
	}

}
