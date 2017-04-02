
public class num393 {
    public boolean validUtf8(int[] data) {
        if(data==null)
            return false;
        int len=0;
        for(int i=0;i<data.length;i++){
            int num=data[i];
            if(num>247)
                return false;
            if(len>0){
                if((num&192)!=128)
                    return false;
                len--;
            }
            else{
                if((num&128)>0){
                    if((num&64)>0){
                        len++;
                        if((num&32)>0){
                            len++;
                            if((num&16)>0){
                                len++;
                                if((num&8)>0)
                                    return false;
                            }
                        }
                    }
                    else
                        return false;
                }
            }
        }
        return len==0;
    }
	public static void main(String[] args) {
		num393 sol=new num393();
		int[] test={197,130,1};
		System.out.println(sol.validUtf8(test));
	}

}
