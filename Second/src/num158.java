
public class num158 {

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     //O(N)
	int read4(char[] buf){
		return 0;
	}
    char[] buff=new char[4];
    int idx=4;
    int len=4;
    //what if buf length!=n
    public int read(char[] buf, int n) {
        if(n<=0||buf==null)
            return 0;
        for(int i=0;i<n;i++){
            if(idx==len){
                len=read4(buff);
                idx=0;
            }
            if(len==0)
                return i;
            buf[i]=buff[idx++];
        }
        return n;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
