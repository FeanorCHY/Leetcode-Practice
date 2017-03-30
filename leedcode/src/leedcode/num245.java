package leedcode;

public class num245 {

    public int shortestWordDistance(String[] words, String word1, String word2) {
    	int in1=-1;
    	int in2=-1;
    	int shor=Integer.MAX_VALUE;
    	for(int i=0;i<words.length;i++){
    		if(!word1.equals(word2)){
	    		if(words[i].equals(word1))
	    			in1=i;
	    		else if(words[i].equals(word2))
	    			in2=i;
    		}
    		else{
    			if(words[i].equals(word1)){
	    			if(in1<0)
	    				in1=i;
	    			else{
	    				in2=in1;
	    				in1=i;
	    			}
    			}
    		}
    		if(in1>=0&&in2>=0&&Math.abs(in1-in2)<shor){
    			shor=Math.abs(in2-in1);
    		}
    	}
    	
    	return shor;
    }
	public static void main(String[] args) {
		String[] arr={"the","quick","brown","fox","quick"};
		num245 sol=new num245();
		System.out.println(sol.shortestWordDistance(arr, "quick", "quick"));

	}

}
