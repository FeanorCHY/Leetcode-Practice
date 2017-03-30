import java.util.LinkedList;
import java.util.List;

public class num386 {
    //recursive
    public List<Integer> lexicalOrder(int n) {  
        List<Integer> res=new LinkedList<Integer>();
        for(int i=1;i<10;i++){
            search(res,n,i);
        }
        return res;
    }
    private void search(List<Integer> res,int n,int x){
        if(x>n)
            return;
        else{
            // System.out.println(x);
            res.add(x);
            for(int i=0;i<10;i++){
                if(x*10+i>n)
                    return;
                search(res,n,x*10+i);
            }
        }
    }




    //what if n<1? 
    //iterative
    // public List<Integer> lexicalOrder(int n) {  
    //     List<Integer> res=new LinkedList<Integer>();
    //     int x=1;
    //     while(x<=n){
    //         res.add(x);
    //         if(x*10<=n)
    //             x*=10;
    //         else{
    //             while(x>0&&(x>=n||x%10==9))
    //                 x=x/10;
    //             if(x==0)
    //                 break;
    //             x++;
    //         }   
    //     }
    //     return res;
    // }
	public static void main(String[] args) {
		num386 sol=new num386();
		System.out.print(sol.lexicalOrder(23));
	}

}
