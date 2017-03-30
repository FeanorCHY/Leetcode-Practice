package leedcode;

import java.util.HashMap;

public class num351 {

	int m;
	int n;
	int sum=0;
    public int numberOfPatterns(int m, int n) {
    	int result=0;
    	this.m=m;
    	this.n=n;
    	boolean[] try1=new boolean[9];
    	boolean[] try2=new boolean[9];
    	boolean[] try5=new boolean[9];
    	try1[0]=true;
    	try2[1]=true;
    	try5[4]=true;
    	tryGo(try1,0,1);
    	result+=sum*4;
    	sum=0;
    	tryGo(try2,1,1);
    	result+=sum*4;
    	sum=0;
    	tryGo(try5,4,1);
    	result+=sum;
    	
        return result;
    }
    public void tryGo(boolean gone[],int last,int count){
    	if(count>=m&&count<=n)
    		sum++;
    	if(count==n)
    		return;
    	for(int i=0;i<9;i++){
    		if(gone[i])
    			continue;
    		if(i!=4&&last!=4){
    			if(i%2==0&&last%2==0){
    				if(!gone[(i+last)/2])
    					continue;
    			}
    			else if(last%2==1&&(i+last)==8){
    				if(!gone[4])
    					continue;
    			}
    		}
			gone[i]=true;
			tryGo(gone,i,count+1);
			gone[i]=false;
    		
    	}
    }
	public static void main(String[] args) {
		num351 sol=new num351();
		System.out.println(sol.numberOfPatterns(1, 3));
	}

}


//int key1[]={2,4,5,6,8};
//int key2[]={1,3,4,5,6,7,9};
//int key3[]={2,4,5,6,8};
//int key4[]={1,2,5,7,8};
//int key5[]={1,2,3,4,6,7,8,9};
//int key6[]={1,2,3,5,7,8,9};
//int key7[]={2,4,5,6,8};
//int key8[]={1,3,4,5,6,7,9};
//int key9[]={2,4,5,6,8};
//HashMap<Integer,int[]> map=new HashMap<Integer,int[]>();
//map.put(1, key1);
//map.put(2, key2);
//map.put(3, key3);
//map.put(4, key4);
//map.put(5, key5);
//map.put(6, key6);
//map.put(7, key7);
//map.put(8, key8);
//map.put(9, key9);
