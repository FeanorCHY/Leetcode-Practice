import java.util.Stack;

public class num277 {
	private boolean knows(int a,int b){
		return false;
	}
    //what if only one?
    //search with hashset O(N^2)
    // public int findCelebrity(int n) {
    //     if(n==1)
    //         return 1;
    //     HashSet<Integer> set=new HashSet<Integer>();
    //     for(int i=1;i<n;i++){
    //         if(knows(0,i))
    //             set.add(i);
    //     }
    //     int candi;
    //     if(set.isEmpty()){
    //         candi=0;
    //     }
    //     else{
    //         HashSet<Integer> tem=new HashSet<Integer>(set);
    //         for(int from:set){
    //             HashSet<Integer> tem2=new HashSet<Integer>();
    //             for(int to:tem){
    //                 if(to==from)
    //                     continue;
    //                 if(knows(from,to)){
    //                     tem2.add(to);
    //                 }
    //             }
    //             if(tem2.size()==0){
    //                 tem2.add(from);
    //                 tem=tem2;
    //                 break;
    //             }
    //             tem=tem2;
    //         }
    //         if(tem.size()==0)
    //             return -1;
    //         candi=tem.iterator().next();
    //     }
        
    //     for(int i=0;i<n;i++){
    //         if(i!=candi&&!knows(i,candi))
    //             return -1;
    //     }
    //     for(int i=0;i<n;i++){
    //         if(i!=candi&&knows(candi,i))
    //             return -1;
    //     }
    //     return candi;
    // }
    
    
    
    
    //two pass O(N)
    // public int findCelebrity(int n) {
    //     if(n==1)
    //         return 1;
    //     int candi=0;
    //     for(int i=1;i<n;i++){
    //         if(knows(candi,i))
    //             candi=i;
    //     }
    //     for(int i=0;i<candi;i++){
    //         if(knows(candi,i))
    //             return -1;
    //     }
    //     for(int i=0;i<n;i++){
    //         if(i!=candi&&!knows(i,candi))
    //             return -1;
    //     }
    //     return candi;
    // }
    
    
    
    //using stack
    public int findCelebrity(int n) {
        // base case
        if (n <= 0) return -1;
        if (n == 1) return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        // put all people to the stack
        for (int i = 0; i < n; i++) stack.push(i);
        
        int a = 0, b = 0;
        
        while (stack.size() > 1) {
            a = stack.pop(); b = stack.pop();
            
            if (knows(a, b)) 
                // a knows b, so a is not the celebrity, but b may be
                stack.push(b);
            else 
                // a doesn't know b, so b is not the celebrity, but a may be
                stack.push(a);
        }
        
        // double check the potential celebrity
        int c = stack.pop();
        
        for (int i = 0; i < n; i++)
            // c should not know anyone else
            if (i != c && (knows(c, i) || !knows(i, c)))
                return -1;
        
        return c;
    }
	public static void main(String[] args) {
		
		
	}

}
