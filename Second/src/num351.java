import java.util.ArrayList;
import java.util.List;

public class num351 {
    //list all so slow
    // int m;
    // int n;
    // int res=0;
    // List<Integer>[] reach;
    // public int numberOfPatterns(int m, int n) {
    //     if(m<=0||n>9)
    //         return 0;
    //     this.m=m;
    //     this.n=n;
    //     reach=new List[9];
    //     int key[][]={{2,4,5,6,8,0,0,0},{1,3,4,5,6,7,9,0},{2,4,5,6,8,0,0,0},{1,2,3,5,7,8,9,0},{1,2,3,4,6,7,8,9},{1,2,3,5,7,8,9,0},{2,4,5,6,8,0,0,0},{1,3,4,5,6,7,9,0},{2,4,5,6,8,0,0,0}};
    //     for(int i=0;i<9;i++){
    //         reach[i]=new ArrayList<Integer>(9);
    //         int idx=0;
    //         while(idx<8&&key[i][idx]!=0)
    //             reach[i].add(key[i][idx++]-1);
    //     }
        
    //     for(int i=0;i<9;i++)
    //         search(1,i,(1<<i));//initiate visit
    //     return res;
    // }
    // private void search(int count,int cur,int visit){
    //     if(count>=m&&count<=n)
    //         res++;
    //     if(count==n)
    //         return;
    //     if(cur==1){
    //         reach[0].add(2);
    //         reach[2].add(0);
    //     }
    //     else if(cur==3){
    //         reach[0].add(6);
    //         reach[6].add(0);
    //     }
    //     else if(cur==4){
    //         reach[0].add(8);
    //         reach[8].add(0);
    //         reach[1].add(7);
    //         reach[7].add(1);
    //         reach[2].add(6);
    //         reach[6].add(2);
    //         reach[3].add(5);
    //         reach[5].add(3);
    //     }
    //     else if(cur==5){
    //         reach[2].add(8);
    //         reach[8].add(2);
    //     }
    //     else if(cur==7){
    //         reach[6].add(8);
    //         reach[8].add(6);
    //     }
    //     int size=reach[cur].size();
    //     for(int i=0;i<size;i++){
    //         int next=reach[cur].get(i);
    //         if(((1<<next)&visit)==0){
    //             search(count+1,next,visit|(1<<next));
    //         }
    //     }
    //     if(cur==1){
    //         reach[0].remove(new Integer(2));
    //         reach[2].remove(new Integer(0));
    //     }
    //     else if(cur==3){
    //         reach[0].remove(new Integer(6));
    //         reach[6].remove(new Integer(0));
    //     }
    //     else if(cur==4){
    //         reach[0].remove(new Integer(8));
    //         reach[8].remove(new Integer(0));
    //         reach[1].remove(new Integer(7));
    //         reach[7].remove(new Integer(1));
    //         reach[2].remove(new Integer(6));
    //         reach[6].remove(new Integer(2));
    //         reach[3].remove(new Integer(5));
    //         reach[5].remove(new Integer(3));
    //     }
    //     else if(cur==5){
    //         reach[2].remove(new Integer(8));
    //         reach[8].remove(new Integer(2));
    //     }
    //     else if(cur==7){
    //         reach[6].remove(new Integer(8));
    //         reach[8].remove(new Integer(6));
    //     }
    // }
    
    //smart filter
    // int m;
    // int n;
    // int res=0;
    // List<Integer>[] reach;
    // public int numberOfPatterns(int m, int n) {
    //     if(m<=0||n>9)
    //         return 0;
    //     this.m=m;
    //     this.n=n;
    //     for(int i=1;i<=9;i++)
    //         search(1,i,(1<<i));//initiate visit
    //     return res;
    // }
    // private void search(int count,int cur,int visit){
    //     if(count>=m&&count<=n)
    //         res++;
    //     if(count==n)
    //         return;
    //     for(int i=1;i<=9;i++){
    //         int mid=(i+cur)/2;
    //         if(i==cur)
    //             continue;
    //         if((((1<<mid)&visit)==0)){
    //             if(i%2==0){
    //                 if(i+cur==10)
    //                     continue;
    //             }
    //             else{
    //                 if(cur%2==1&&i!=5&&cur!=5)
    //                     continue;
    //             }
    //         }
    //         if((((1<<i)&visit)==0))
    //             search(count+1,i,visit|(1<<i));
    //     }
    // }
    
    
    //optimized with saving similar search
    int m;
    int n;
    List<Integer>[] reach;
    public int numberOfPatterns(int m, int n) {
        if(m<=0||n>9)
            return 0;
        this.m=m;
        this.n=n;
        int res=0;
        res+=4*search(1,1,(1<<1));
        res+=4*search(1,2,(1<<2));
        res+=search(1,5,(1<<5));
        return res;
    }
    private int search(int count,int cur,int visit){
        int res=0;
        if(count>=m&&count<=n)
            res++;
        if(count==n)
            return res;
        for(int i=1;i<=9;i++){
            int mid=(i+cur)/2;
            if(i==cur)
                continue;
            if((((1<<mid)&visit)==0)){
                if(i%2==0){
                    if(i+cur==10)
                        continue;
                }
                else{
                    if(cur%2==1&&i!=5&&cur!=5)
                        continue;
                }
            }
            if((((1<<i)&visit)==0))
                res+=search(count+1,i,visit|(1<<i));
        }
        return res;
    }
    
	public static void main(String[] args) {
		num351 sol=new num351();
		System.out.println(sol.numberOfPatterns(1, 3));
	}

}
