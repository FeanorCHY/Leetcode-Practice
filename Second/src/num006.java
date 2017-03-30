
public class num006 {

    //what is numRows is even number? is the zigzag way only one character? 
    public String convert(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");   //init every sb element **important step!!!!
        }
        int incre=1;
        int index=0;
        for(int i=0;i<s.length();i++){
            sb[index].append(s.charAt(i));
            if(index==0){incre=1;}
            if(index==numRows-1){incre=-1;}
            index+=incre;
        }
       StringBuilder res=new StringBuilder(); 
        for(int i=0;i<sb.length;i++){
            res.append(sb[i].toString());
        }
        return res.toString();
    }
    // public String convert(String s, int numRows) {
    //     if(s==null)
    //         return null;
    //     char[] arr=s.toCharArray();
    //     if(arr.length<=numRows)
    //         return s;
    //     if(numRows==1)
    //         return s;
    //     int mid=numRows-2;
    //     StringBuilder sb=new StringBuilder();
    //     for(int i=0;i<numRows;i++){
    //         for(int j=i;j<arr.length;j+=numRows+mid){
    //             sb.append(arr[j]);
    //             if(i!=0&&i!=numRows-1&&(j/(numRows+mid)+1)*(numRows+mid)-i<arr.length){
    //                 sb.append(arr[(j/(numRows+mid)+1)*(numRows+mid)-i]);
    //             }
    //         }
    //     }
    //     return sb.toString();
    // }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
