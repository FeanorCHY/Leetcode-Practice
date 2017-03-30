package leedcode;

public class num273 {
    public String numberToWords(int num) {
    	String[] three={""," Thousand"," Million"," Billion"};
    	String[] ele={"Ten","Eleven", "Twelve", "Thirteen" ,"Fourteen","Fifteen", "Sixteen","Seventeen", "Eighteen", "Nineteen"};
    	String[] two={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    	String[] one={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    	if(num==0)
    		return "Zero";
    	long div=1000;
    	long q=num;
    	int index3=0;
    	String res="";
    	while(q>0){
    		int rem=(int)(q%div);
    		q=q/div;
    		if(rem>0){
    			StringBuilder str=new StringBuilder();
    			if(rem/100>0){
    				str.append(one[rem/100-1]);
    				str.append(" Hundred");
    			}
    			rem=rem%100;
    			if(rem/10==1){
    				if(str.length()>0)
    					str.append(" ");
    				str.append(ele[rem%10]);
    			}
    			else{
    				if(str.length()>0&&rem>0)//
    					str.append(" ");
    				str.append(two[rem/10]);
    				if(rem%10>0){
    					if(rem/10>0)
    						str.append(" ");
    					str.append(one[rem%10-1]);
    				}
    			}
    			str.append(three[index3]);
    			res=str.toString()+(res.length()==0?"":" ")+res;
    		}
    		index3++;
    	}
    	
        return res;
    }
	public static void main(String[] args) {
		num273 sol=new num273();
		System.out.println(sol.numberToWords(101));
	}

}
