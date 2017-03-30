package leedcode;

public class num243 {
    public int shortestDistance(String[] words, String word1, String word2) {
    	int in1=-1;
    	int in2=-1;
    	int shor=Integer.MAX_VALUE;
    	for(int i=0;i<words.length;i++){
    		if(words[i].equals(word1))
    			in1=i;
    		else if(words[i].equals(word2))
    			in2=i;
    		if(in1>=0&&in2>=0&&Math.abs(in1-in2)<shor){
    			shor=Math.abs(in2-in1);
    		}
    	}
    	
    	return shor;
    }
	public static void main(String[] args) {
		num243 sol=new num243();
		String[] words={"a","b"};
		
		System.out.println(sol.shortestDistance(words, "a", "b"));

	}

}
