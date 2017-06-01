import java.util.HashMap;

public class num149 {
    //intergrate slop Time O(N^2)
   public int maxPoints(Point[] points) {
        if(points==null||points.length==0)
            return 0;
        int max=0;
        for(int i=0;i<points.length;i++){
            int tem=0,same=0,pp=1,hoz=1;
            HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<Integer,HashMap<Integer,Integer>>();
            for(int j=i+1;j<points.length;j++){
                if(points[j].y==points[i].y&&points[j].x==points[i].x){
                    same++;
                }
                else if(points[j].x==points[i].x){
                    pp++;
                }
                else if(points[j].y==points[i].y){
                    hoz++;
                }
                else{
                    int y=points[j].y-points[i].y;
                    int x=points[j].x-points[i].x;
                    int key=getKey(y,x);
                    x=x/key;
                    y=y/key;
                    if(!map.containsKey(y)){
                        map.put(y,new HashMap<Integer,Integer>());
                        map.get(y).put(x,1);
                    }
                    else if(!map.get(y).containsKey(x)){
                        map.get(y).put(x,1);
                    }
                    map.get(y).put(x,map.get(y).get(x)+1);
                    tem=Math.max(map.get(y).get(x),tem);
                }
            }
            max=Math.max(tem+same,max);
            max=Math.max(pp+same,max);
            max=Math.max(hoz+same,max);
        }
        return max;
    }
    private int getKey(int a,int b){
        int sign=1;
        if(a<0&&b<0){
            sign=-1;
        }
        else if(a<0)
            sign=-1;
        a=Math.abs(a);
        b=Math.abs(b);
    	if(b==a)
    	    return a*sign;
	    if(a<b){
	        int tem=b;
	        b=a;
	        a=tem;
	    }
	    if(b==1)
	        return sign;
        while(b>0){//zero not one!!!!!
            int tem=a%b;
            a=b;
            b=tem;
        }
        return a*sign;
    }

    private int getKey2(int a,int b){

    	if (b==0) return a;
    	else return getKey(b,a%b);
    	
    }
	public static void main(String[] args) {
		num149 sol=new num149();
		System.out.println(sol.getKey(70, 23));
//		int[][] test={{2,3},{3,3},{-5,3}};
//		int[][] test={{0,0},{94911151,94911150},{94911152,94911151}};
//		int[][] test={{0,0},{-1,-1},{2,2}};
		int[][] test=
				{{0,9},{138,429},{115,359},{115,359},{-30,-102},{230,709},{-150,-686},{-135,-613},{-60,-248},{-161,-481},{207,639},{23,79},{-230,-691},{-115,-341},{92,289},{60,336},{-105,-467},{135,701},{-90,-394},{-184,-551},{150,774}};
//				{{-4,1},{-7,7},{-1,5},{9,-25}};
//				{{-4,-4},{-8,-582},{-3,3},{-9,-651},{9,591}};
		for(int i=0;i<test.length;i++){
			int t=0;
			for(int j=i+1;j<test.length;j++){
				int y=test[j][1]-test[i][1];
				int x=test[j][0]-test[i][0];
				int key1=sol.getKey(y, x);
				int key2=sol.getKey2(y, x);
				if(y!=0&&x!=0&&y/key1==70)
					System.out.println(t++);
				System.out.println("i: "+i+" j:"+j);
				System.out.println("get1: "+sol.getKey(y, x));
				System.out.println("get2: "+sol.getKey2(y, x));
				System.out.println();
			}
		}
		Point points[]=new Point[test.length];
		for(int i=0;i<test.length;i++){
			points[i]=new Point(test[i][0],test[i][1]);
		}
		System.out.print(sol.maxPoints(points));
		
		
//		System.out.println(sol.getKey2(5, 1));
//		System.out.println(sol.getKey2(2, 7));
	}

}
