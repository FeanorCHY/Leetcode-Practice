
public class num365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z)
            return false;
        if(x==z||y==z||x+y==z)
            return true;
        if(x<y){
            x^=y;
            y^=x;
            x^=y;
        }
        return z%GCD(x,y)==0;
    }
    private int GCD(int x,int y){
        while(y>0){
            int tem=x%y;
            x=y;
            y=tem;
        }
        return x;
    }
	public static void main(String[] args) {
		num365 sol=new num365();
		System.out.println(sol.GCD(31237, 22003));
	}

}
