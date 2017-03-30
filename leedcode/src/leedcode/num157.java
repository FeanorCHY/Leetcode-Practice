package leedcode;

public class num157 {
	private int read4(char[] buf){
		
		return 0;
	}
    public int read(char[] buf, int n) {
    	int count=0;
    	int index=0;
    	char[] buf4=new char[4];
    	int r4=read4(buf4);
    	while(index<n&&r4==4){
    		count=Math.min(n, r4+count);
    		for(int i=0;i<4&&index<n;i++){
    			buf[index++]=buf4[i];
    		}
    		r4=read4(buf4);
    	}
    	if(r4>0){
    		count=Math.min(n, r4+count);
    		for(int i=0;i<r4&&index<n;i++){
    			buf[index++]=buf4[i];
    		}
    	}
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
