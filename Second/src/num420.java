import java.util.Comparator;
import java.util.PriorityQueue;

public class num420 {
    public int strongPasswordChecker(String s) {
        if(s==null)
            return 0;
        boolean low=false,high=false,digit=false;
        char[] arr=s.toCharArray();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o1%3-o2%3;
            }
        });
        int count=0;
        char r='\0';
        for(char c:arr){
            if(c==r)
                count++;
            else{
                if(count>=3)
                    pq.add(count);
                count=1;
                r=c;
            }
            if(c>='a'&&c<='z')
                low=true;
            else if(c>='A'&&c<='Z')
                high=true;
            else if(c>='0'&&c<='9')
                digit=true;
        }
        if(count>=3)
            pq.add(count);
        int res=0;
        int len=arr.length;
        int add=(low?0:1)+(high?0:1)+(digit?0:1);
        if(len<6){
            res=Math.max(6-len,add);
            
        }
        else if(len>=6&&len<=20){
            int num=0;
            while(!pq.isEmpty()){
                num+=pq.poll()/3;
            }
            res=Math.max(add,num);
        }
        else{
            int diff=len-20;
            while(!pq.isEmpty()&&diff>0){
                int num=pq.poll();
                res+=Math.min(num%3+1,diff);
                int tem=num-Math.min(num%3+1,diff);
                diff-=Math.min(num%3+1,diff);
                if(tem>=3)
                    pq.add(tem);
            }
            if(diff==0){
                int num=0;
                while(!pq.isEmpty()){
                    num+=pq.poll()/3;
                }
                res+=Math.max(add,num);
            }
            else{
                res+=diff+add;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		num420 sol=new num420();
		System.out.println(sol.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"));
	}

}
