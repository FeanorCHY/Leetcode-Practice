package leedcode;

public class num11 {
//    int min=0;
//    int max=0;
//    for(int i=0;i<height.length;i++)
//    {
//        for(int j=i;j<height.length;j++)
//        {
//            if(((j-i)*Math.min(height[i],height[j]))>max)
//                max=(j-i)*Math.min(height[i],height[j]);
//        }
//    }
//    return (max);
    static int maxArea(int[] height) {
//    	int maxIndex=0;
//    	int maxDiff=0;
//    	for(int i=0;i<height.length-1;i++)
//    	{
//    		if((height[i]-i)>maxDiff)
//    		{
//    			maxDiff=height[i]-i;
//    			maxIndex=i;
//    		}
//    	}
//    	int firstMax=maxDiff;
//    	int firstMaxIndex=maxIndex;
//    	int maxArea=0;
//    	for(int i=height.length-1;i>firstMaxIndex;i--)
//    	{
//    		if((i-firstMaxIndex)*Math.min(height[firstMaxIndex],height[i])>maxArea)
//    		{
//    			maxArea=(i-firstMaxIndex)*Math.min(height[firstMaxIndex],height[i]);
//    			maxIndex=i;
//    		}
//    	}
//    	firstMax=maxDiff;
//    	firstMaxIndex=maxIndex;
//    	for(int i=0;i>firstMaxIndex;i++)
//    	{
//    		if((firstMaxIndex-1)*Math.min(height[firstMaxIndex],height[i])>maxArea)
//    		{
//    			maxArea=(i-firstMaxIndex)*Math.min(height[firstMaxIndex],height[i]);
//    			maxIndex=i;
//    		}
//    	}
    	
    	int min=Integer.MAX_VALUE;
    	int max=Integer.MIN_VALUE;
    	for(int i=0;i<height.length;i++)
    	{
    		if(max<height[i])
    			max=height[i];
    		if(min>height[i])
    			min=height[i];
    	}
    	boolean success=false;
    	int indexL=0;
    	int indexR=height.length-1;
    	int level=Math.min(height[indexL],height[indexR]);
    	int vol=(height.length-1)*level;
    	int dis=0;
    	level=level+1;
    	while(level<=max)
    	{
        	dis=vol/level+1;
        	if(height[indexL]<height[indexR])
        	{
            	int index=indexL;
            	boolean inFindL=true;
            	int temL=0;
            	int temR=0;
	        	while(index<indexR&&index+dis<=indexR&&inFindL)
	        	{
	        		if(height[index]>=level){
	        			temL=index;
	        			inFindL=false;
	        		}
	        		index++;
	        	}
	        	index=indexR;
	        	boolean inFindR=true;
	        	while(index>temL&&index-dis>=temL&&inFindR)
	        	{
	        		if(height[index]>=level){
	        			temR=index;
	        			inFindR=false;
	        		}
	        		index--;
	        	}
	        	if(inFindR==false&&inFindL==false)
	        	{
	        		success=true;
	        		indexL=temL;
	            	indexR=temR;
	        	}
        	}
        	else
        	{
            	int index=indexR;
            	int temL=0;
            	int temR=0;
	        	boolean inFindR=true;
	        	while(index>indexL&&index-dis>=indexL&&inFindR)
	        	{
	        		if(height[index]>=level){
	        			temR=index;
	        			inFindR=false;
	        		}
	        		index--;
	        	}
	        	index=indexL;
            	boolean inFindL=true;
	        	while(index<temR&&index+dis<=temR&&inFindL)
	        	{
	        		if(height[index]>=level){
	        			temL=index;
	        			inFindL=false;
	        		}
	        		index++;
	        	}
	        	if(inFindR==false&&inFindL==false)
	        	{
	        		success=true;
	        		indexL=temL;
	            	indexR=temR;
	        	}
        	}
        	if(success==true){
	        	level=Math.min(height[indexL],height[indexR]);
	        	vol=(indexR-indexL)*level;
        	}
        	success=false;
        	level=level+1;
    	}
    	
    	return vol;
    	
    	
    	
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test={1,2,3,4,4,3,2,1};
		System.out.println(maxArea(test));
	}

}
