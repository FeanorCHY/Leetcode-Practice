import java.util.LinkedList;
import java.util.List;

public class num451 {

    

    //sort O(N)
    // class Node{
    //     char c;
    //     int fre;
    //     public Node(char c,int fre){
    //         this.c=c;
    //         this.fre=fre;
    //     }
    // }
    // //only letter?
    // public String frequencySort(String s) {
    //     if(s==null||s.length()==0)
    //         return "";
    //     char[] arr=s.toCharArray();
    //     int[] step=new int[256];
    //     for(char c:arr)
    //         step[c]++;
    //     PriorityQueue<Node> pq=new PriorityQueue<Node>(new Comparator<Node>(){
    //         @Override
    //         public int compare(Node n1,Node n2){
    //             return n2.fre-n1.fre;
    //         }
    //     });
    //     for(int i=0;i<step.length;i++){
    //         if(step[i]>0){
    //             pq.add(new Node((char)i,step[i]));
    //         }
    //     }
    //     StringBuilder res=new StringBuilder();
    //     while(!pq.isEmpty()){
    //         Node node=pq.poll();
    //         for(int i=0;i<node.fre;i++){
    //             res.append(node.c);
    //         }
    //     }
    //     return res.toString();
    // }
    
    
    
    
    
    //bucket sort based O(N) Space O(N)
    //only letter?
    public String frequencySort(String s) {
        if(s==null||s.length()==0)
            return "";
        char[] arr=s.toCharArray();
        int[] step=new int[256];
        int max=0;
        for(char c:arr){
            step[c]++;
            max=Math.max(max,step[c]);
        }
        List<Character> list[]=new List[max+1];
        for(int i=0;i<step.length;i++){
            if(list[step[i]]==null)
                list[step[i]]=new LinkedList<Character>();
            list[step[i]].add((char)i);
        }
        StringBuilder res=new StringBuilder();
        for(int i=max;i>=0;i--){
            if(list[i]!=null){
                for(char c:list[i]){
                    for(int x=0;x<i;x++){
                        res.append(c);
                    }
                }
            }
        }
        return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
