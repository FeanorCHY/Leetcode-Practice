import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class num406 {
    //Array sort+insertion sort
    //Space O(N); Time:O(n^2)
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0])
                    return a[1]-b[1];
                return b[0]-a[0];
            }
        });
        // for(int i=0;i<people.length;i++)
        //     System.out.println(people[i][0]+" "+people[i][1]);
        ArrayList<int[]> list=new ArrayList<int[]>();
        // int[][] res=new int[people.length][people[0].length];
        for(int[] each:people){
            list.add(each[1],new int[]{each[0],each[1]});
        }
        for(int[] each:people){
            list.add(each[1],each);
        }
        // for(int i=0;i<people.length;i++)
        //     res[i]=list.get(i);
        for(int i=0;i<people.length;i++)
            people[i]=list.get(i);
        
        return people;
    }
    
    
    
    
    
    
    //Space O(N); Time:O(n^2)
    // public int[][] reconstructQueue(int[][] people) {
    //     Arrays.sort(people,new Comparator<int[]>(){
    //         @Override
    //         public int compare(int[] e1,int[] e2){
    //             return e1[1]-e2[1];
    //         }
    //     });
    //     ArrayList<int[]> list=new ArrayList<int[]>();
    //     for(int i=0;i<people.length;i++){
    //         int j=0;
    //         int count=0;
    //         for(;j<list.size();j++){
    //             if(people[i][0]<=list.get(j)[0])
    //                 count++;
    //             if(count>people[i][1])
    //                 break;
    //         }
    //         list.add(j,people[i]);
    //     }
    //     for(int i=0;i<people.length;i++){
    //         people[i]=list.get(i);
    //     }
    //     return people;
    // }
	public static void main(String[] args) {
		int[][] test=
				{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		num406 sol=new num406();
		sol.reconstructQueue(test);
	}

}
