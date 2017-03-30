package leedcode;

public class num158 extends Reader4  {
	char[] buffer=new char[4];
	int bindex=4;
	int maxB=4;
    public int read(char[] buf, int n) {
    	int index=0;
    	while(index<n&&(maxB==4||(bindex<maxB))){
    		if(bindex==4){
    			bindex=0;
    			maxB=read4(buffer);
    		}
    		while(bindex<maxB&&index<n){
    			buf[index++]=buffer[bindex++];
    		}
    	}
    	
        return index;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
