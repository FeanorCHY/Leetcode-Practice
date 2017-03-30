import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class num332 {
    //DFS
    // HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<Integer,PriorityQueue<Integer>>();
    // List<String> res=new LinkedList<String>();
    // public List<String> findItinerary(String[][] tickets) {
    //     if(tickets==null||tickets.length==0)
    //         return res;
    //     for(String[] ticket:tickets){
    //         int from=transform(ticket[0]);
    //         int to=transform(ticket[1]);
    //         if(!map.containsKey(from))
    //             map.put(from,new PriorityQueue<Integer>());
    //         map.get(from).add(to);
    //     }
    //     res.add("JFK");
    //     search(transform("JFK"),tickets.length);
    //     return res;
    // }
    // private boolean search(int from,int rem){
    //     if(rem==0)
    //         return true;
    //     if(!map.containsKey(from)||map.get(from).isEmpty())
    //         return false;
    //     PriorityQueue<Integer> pq=map.get(from);
    //     int first=pq.poll();
    //     res.add(transformback(first));
    //     if(search(first,rem-1))
    //         return true;
    //     res.remove(res.size()-1);
    //     if(pq.isEmpty()){
    //         pq.add(first);
    //         return false;
    //     }
    //     int second=pq.poll();
    //     pq.add(first);
    //     res.add(transformback(second));
    //     if(search(second,rem-1))
    //         return true;
    //     pq.add(second);
    //     res.remove(res.size()-1);
    //     return false;
    // }
    // private int transform(String city){
    //     char[] arr=city.toCharArray();
    //     int res=0;
    //     for(char c:arr){
    //         res=(res<<10)+c-'A';
    //     }
    //     return res;
    // }
    // private String transformback(int num){
    //     StringBuilder sb=new StringBuilder();
    //     sb.append((char)('A'+((num&(31<<20))>>20)));
    //     sb.append((char)('A'+((num&(31<<10))>>10)));
    //     sb.append((char)('A'+(num&31)));
    //     return sb.toString();
    // }
    
    
    
    
    
    
    //DFS SMART method
    // HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<Integer,PriorityQueue<Integer>>();
    // List<String> res=new LinkedList<String>();
    // public List<String> findItinerary(String[][] tickets) {
    //     if(tickets==null||tickets.length==0)
    //         return res;
    //     for(String[] ticket:tickets){
    //         int from=transform(ticket[0]);
    //         int to=transform(ticket[1]);
    //         if(!map.containsKey(from))
    //             map.put(from,new PriorityQueue<Integer>());
    //         map.get(from).add(to);
    //     }
    //     search(transform("JFK"));
    //     return res;
    // }
    // private void search(int from){
    //     while(map.containsKey(from)&&!map.get(from).isEmpty())
    //         search(map.get(from).poll());
    //     res.add(0,transformback(from));
    // }
    // private int transform(String city){
    //     char[] arr=city.toCharArray();
    //     int res=0;
    //     for(char c:arr){
    //         res=(res<<10)+c-'A';
    //     }
    //     return res;
    // }
    // private String transformback(int num){
    //     StringBuilder sb=new StringBuilder();
    //     sb.append((char)('A'+((num&(31<<20))>>20)));
    //     sb.append((char)('A'+((num&(31<<10))>>10)));
    //     sb.append((char)('A'+(num&31)));
    //     return sb.toString();
    // }
    
    
    
    
    
    //DFS SMART method without transform
    // HashMap<String,PriorityQueue<String>> map=new HashMap<String,PriorityQueue<String>>();
    // List<String> res=new LinkedList<String>();
    // public List<String> findItinerary(String[][] tickets) {
    //     if(tickets==null||tickets.length==0)
    //         return res;
    //     for(String[] ticket:tickets){
    //         if(!map.containsKey(ticket[0]))
    //             map.put(ticket[0],new PriorityQueue<String>());
    //         map.get(ticket[0]).add(ticket[1]);
    //     }
    //     search("JFK");
    //     return res;
    // }
    // private void search(String from){
    //     while(map.containsKey(from)&&!map.get(from).isEmpty())
    //         search(map.get(from).poll());
    //     res.add(0,from);
    // }
    
    
    
    
    
    
    //DFS SMART method without transform iterative
    public List<String> findItinerary(String[][] tickets) {
        List<String> res=new LinkedList<String>();
        if(tickets==null||tickets.length==0)
            return res;
        HashMap<String,PriorityQueue<String>> map=new HashMap<String,PriorityQueue<String>>();
        Stack<String> st=new Stack<String>();
        for(String[] ticket:tickets){
            if(!map.containsKey(ticket[0]))
                map.put(ticket[0],new PriorityQueue<String>());
            map.get(ticket[0]).add(ticket[1]);
        }
        st.push("JFK");
        while(!st.isEmpty()){
            while(map.containsKey(st.peek())&&!map.get(st.peek()).isEmpty())
                st.push(map.get(st.peek()).poll());
            res.add(0,st.pop());
        }
        return res;
    }
	public static void main(String[] args) {
		String[][] test=
			{{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
		num332 sol=new num332();
		System.out.println(sol.findItinerary(test));
	}

}
