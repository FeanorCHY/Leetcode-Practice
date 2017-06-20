
public class num135 {

    //One Array Time O(n) Space o(n)
    // public int candy(int[] ratings) {
    //     if(ratings==null||ratings.length==0)
    //         return 0;
    //     int[] count=new int[ratings.length];
    //     count[0]=1;
    //     for(int i=1;i<ratings.length;i++){
    //         if(ratings[i]>ratings[i-1])
    //             count[i]=count[i-1]+1;
    //         else
    //             count[i]=1;
    //     }
    //     for(int i=ratings.length-2;i>=0;i--){
    //         if(ratings[i]>ratings[i+1])
    //             count[i]=Math.max(count[i+1]+1,count[i]);
    //     }
    //     int res=0;
    //     for(int c:count)
    //         res+=c;
    //     return res;
    // }
    
    
    //Time o(n) Space O(1)
    private int cal(int n){
        return n*(n+1)/2;
    }
    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0)
            return 0;
        if(ratings.length==1)
            return 1;
        int res=0;
        int old_slop=0,up=0,down=0;
        for(int i=1;i<ratings.length;i++){
            int new_slop=ratings[i]>ratings[i-1]?1:(ratings[i]<ratings[i-1]?-1:0);
            if((new_slop==0&&old_slop>0)||(new_slop>=0&&old_slop<0)){
                res+=cal(up)+cal(down)+Math.max(up,down);
                up=0;
                down=0;
            }
            if(new_slop>0)
                up++;
            else if(new_slop<0)
                down++;
            else
                res++;
            old_slop=new_slop;
        }
        res += cal(up) + cal(down) + Math.max(up, down)+1;
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
