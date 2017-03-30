package leedcode;

public class num167 {
    public int[] twoSum(int[] numbers, int target) {
    	int index1=0;
    	int index2=numbers.length-1;
        while(index1<index2){
        	if(numbers[index1]+numbers[index2]==target){
        		int[] result=new int[2];
        		result[0]=index1+1;
        		result[1]=index2+1;
        		return result;
        	}
        	else if(numbers[index1]+numbers[index2]>target){
        		index2--;
        	}
        	else
        		index1++;
        }
    	
    	
    	
    	return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
