package leedcode;

import java.util.LinkedList;
import java.util.Queue;

public class num210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	int[] map=new int[numCourses];
    	for(int i=0;i<prerequisites.length;i++){
    		map[prerequisites[i][0]]++;
    	}
    	Queue<Integer> que=new LinkedList<Integer>();
    	for(int i=0;i<map.length;i++){
    		if(map[i]==0)
    			que.add(i);
    	}
    	int[] course=new int[numCourses];
    	int index=0;
    	while(!que.isEmpty()){
    		int begin=que.remove();
    		course[index++]=begin;
        	for(int i=0;i<prerequisites.length;i++){
        		if(prerequisites[i][1]==begin){
        			map[prerequisites[i][0]]--;
        			if(map[prerequisites[i][0]]==0){
        				que.add(prerequisites[i][0]);
        			}
        		}
        	}
    	}
    	if(index==numCourses)
    		return course;
    	else 
    		return new int[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
