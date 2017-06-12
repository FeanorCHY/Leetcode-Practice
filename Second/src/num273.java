
public class num273 {

    public String numberToWords(int num) {
        if(num<=0)
            return "Zero";
        String[] map={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven", "Twelve", "Thirteen" ,"Fourteen","Fifteen", "Sixteen","Seventeen", "Eighteen", "Nineteen"};
        String[] small={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    	String[] large={""," Thousand"," Million"," Billion"};
    	int idx=0;
    	StringBuilder res=new StringBuilder();
    	while(num>0){
    	    int cur=num%100;
    	    String str="";
    	    if(cur<20){
    	        str=map[cur];
    	    }
    	    else{
    	        str=small[cur/10];
    	        if(cur%10>0)
    	            str=str+" "+map[cur%10];
    	    }
    	    int ad=(num/100)%10;
    	    if(ad>0){
    	        if(cur>0)
    	            str=" "+str;
    	        str=map[ad]+" Hundred"+str;
    	    }
    	    if(res.length()>0&&str.length()>0)
    	        res.insert(0," ");
	        if(str.length()>0)
    	        res.insert(0,str+large[idx]);
    	    num/=1000;
    	    idx++;
    	}
    	return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
