import java.util.Arrays;
import java.util.HashMap;

public class num399 {
    //is here a loop?
    //HashMap Time O(nk) Space O(nk) k:length of equations
    HashMap<String,HashMap<String,Double>> map=new HashMap<String,HashMap<String,Double>>();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if(queries==null||equations==null||values==null||queries.length==0)
            return new double[0];
        int n=queries.length;
        double[] res=new double[n];
        for(int i=0;i<equations.length;i++){
            if(!map.containsKey(equations[i][0]))
                map.put(equations[i][0],new HashMap<String,Double>());
            map.get(equations[i][0]).put(equations[i][1],values[i]);
            if(!map.containsKey(equations[i][1]))
                map.put(equations[i][1],new HashMap<String,Double>());
            map.get(equations[i][1]).put(equations[i][0],1.0/values[i]);
        }
        for(int i=0;i<n;i++){
            if(!map.containsKey(queries[i][0])||!map.containsKey(queries[i][1]))
                res[i]=-1.0;
            else if(queries[i][0].equals(queries[i][1]))
                res[i]=1.0;
            else
                res[i]=search(queries[i][0],queries[i][1],"");
        }
        return res;
    }
    private double search(String from,String Target,String pre){
        if(map.get(from).containsKey(Target))
            return map.get(from).get(Target);
        for(String each:map.get(from).keySet()){
            // if(map.get(from).get(each)==-1.0)
            //     continue;
            if(each.equals(pre))
                continue;
            double tem=search(each,Target,from);
            if(tem!=-1.0){
                map.get(from).put(Target,map.get(from).get(each)*tem);
                return map.get(from).get(each)*tem;
            }
        }
        // map.get(from).put(Target,-1.0);//no pruning
        return -1.0;
    }
	public static void main(String[] args) {
//		String eq[][]
//				={{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
//		double[] values=
//				{3.0,4.0,5.0,6.0};
//		String queries[][]=
//				{{"x1","x5"},{"x5","x2"},{"x2","x4"},{"x2","x2"},{"x2","x9"},{"x9","x9"}};
		String eq[][]
				={{"a","b"},{"c","d"},{"e","f"},{"g","h"}};
		double[] values=
				{4.5,2.3,8.9,0.44};
		String queries[][]=
				{{"a","c"},{"d","f"},{"h","e"},{"b","e"},{"d","h"},{"g","f"},{"c","g"}};
		num399 sol=new num399();
		System.out.println(Arrays.toString(sol.calcEquation(eq, values, queries)));
	}

}
