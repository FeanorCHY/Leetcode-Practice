
public class num306 {

    //will the number over Integer limit? 
    public boolean isAdditiveNumber(String num) {
        if(num==null||num.length()<3)
            return false;
        char[] arr=num.toCharArray();
        char[] num1=null;
        char[] num2=null;
        char[] sum=null;
        for(int s1=0;s1<(arr.length-1)/2;s1++){
            num1=num.substring(0,s1+1).toCharArray();
            if(num1[0]=='0'&&num1.length>1)
                break;
            for(int s2=s1+1;s2<=(s1+arr.length)/2;s2++){
                int s3=s2+1;
                num1=num.substring(0,s1+1).toCharArray();
                num2=num.substring(s1+1,s2+1).toCharArray();
                if(num2[0]=='0'&&num2.length>1)
                    break;
                while(s3<arr.length){
                    sum=sum(num1,num2);
                    int index=0;
                    while(index<sum.length){
                        if(s3>=arr.length)
                            break;
                        if(arr[s3]==sum[index]){
                            index++;
                            s3++;
                        }
                        else
                            break;
                    }
                    if(index==sum.length){
                        num1=num2;
                        num2=sum;
                    }
                    else{
                        break;
                    }
                }
                if(s3==arr.length)
                    return true;
                
            }
        }
        return false;
        
    }
    private char[] sum(char[] num1,char[] num2){
        StringBuilder sb=new StringBuilder();
        int s1=num1.length-1;
        int s2=num2.length-1;
        int plus=0;
        while(s1>=0||s2>=0){
            int he=(s1>=0?num1[s1--]-'0':0)+(s2>=0?num2[s2--]-'0':0)+plus;
            plus=he/10;
            he=he%10;
            sb.insert(0,(char)(he+'0'));
        }
        if(plus>0)
            sb.insert(0,(char)(plus+'0'));
        System.out.println("num1:"+new String(num1));
        System.out.println("num2:"+new String(num2));
        System.out.println(sb.toString());
        return sb.toString().toCharArray();
    }
	public static void main(String[] args) {
		num306 sol=new num306();
		System.out.println(sol.isAdditiveNumber("111122335588143"));
	}

}
