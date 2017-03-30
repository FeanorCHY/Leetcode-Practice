
public class num331 {
    // public boolean isValidSerialization(String preorder) {
    //     if(preorder==null||preorder.length()==0)
    //         return false;
    //     char[] arr=preorder.toCharArray();
    //     int num=0;
    //     int i=0;
    //     boolean left=true;
    //     // if(arr[0]=='#'){
    //     //     if(arr.length>1)
    //     //         return false;
    //     //     else
    //     //         return true;
    //     // }
    //     for(;i<arr.length;i++){
    //         if(arr[i]=='#'){
    //             if(left)
    //                 left=false;
    //             else{
    //                 num--;
    //                 if(num<0||(num==0&&i<arr.length-1))
    //                     return false;
    //             }
    //             i++;
    //         }
    //         else if(arr[i]==',')
    //             return false;
    //         else{
    //             if(left)
    //                 num++;
    //             else if(num==0)
    //                 return false;
    //             left=true;
    //             while(i<arr.length&&arr[i]!=',')
    //                 i++;
    //         }
    //         // System.out.println(num);
    //     }
    //     return num==0;
    // }
    
    
    //calculate difference
    
    public boolean isValidSerialization(String preorder) {
        if(preorder==null||preorder.length()==0)
            return false;
        char[] arr=preorder.toCharArray();
        int num=1;
        int i=0;
        boolean left=true;
        for(;i<arr.length;i++){
            if(arr[i]=='#'){
                num--;
                if(num<0)
                    return false;
                i++;
            }
            else if(arr[i]==',')
                return false;
            else{
                if(num==0)
                    return false;
                num+=1;
                while(i<arr.length&&arr[i]!=',')
                    i++;
            }
        }
        return num==0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
