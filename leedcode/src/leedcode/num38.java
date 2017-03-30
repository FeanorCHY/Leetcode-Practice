package leedcode;

public class num38 {	
    public String countAndSay(int n) {
    	String begin="1";
    	String count="1";
    	for(int i=0;i<n-1;i++)
    	{
    		count="";
    		int rest=Integer.parseInt(begin.substring(begin.length()-1));
    		begin=begin.substring(0,begin.length()-1);
    		long count_digit=1;
    		if(begin.equals("")){
    			count="11";
    		}
    		while(!begin.equals(""))
    		{
    			if(Integer.parseInt(begin.substring(begin.length()-1))==rest){
    				count_digit++;
    			}
    			else{
    				count=count_digit+""+rest+""+count;
					count_digit=1;
    			}
    			rest=Integer.parseInt(begin.substring(begin.length()-1));
        		begin=begin.substring(0,begin.length()-1);
    			if(begin.equals("")){
    				count=count_digit+""+rest+""+count;
    			}
    		}
    		begin=count;
    	}
    	
        return count;
    }
	public static void main(String[] args) {
//		String str="123456";
//		System.out.println(str.substring(str.length()-1));
		num38 sol=new num38();
		System.out.println(sol.countAndSay(10));
	}

}
