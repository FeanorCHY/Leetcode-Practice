
public class num003 {

    //follow up: how many space between. is space in the ending? one word? Empty input?" " input?null input
    public String reverseWords(String s) {
        if(s==null)
            return "";
        char[] arr=s.toCharArray();
        reverse(arr,0,arr.length-1);
        reverseS(arr);
        return cleanSpace(arr);
    }
    private String cleanSpace(char[] arr){
        int i=0,j=0;
        while(j<arr.length&&arr[j]==' ')
            j++;
        while(j<arr.length){
            while(j<arr.length&&arr[j]!=' '){
                arr[i++]=arr[j++];
            }
            while(j<arr.length&&arr[j]==' ')
                j++;
            if(j<arr.length)
                arr[i++]=' ';
        }
        return new String(arr).substring(0,i);
    }
    private void reverseS(char[] arr){
        int i=0,j=0;
        while(j<arr.length){
            while(i<j||(i<arr.length&&arr[i]==' '))
                i++;
            j=i+1;
            // System.out.println("i:"+i);
            while(j<i||(j<arr.length&&arr[j]!=' '))
                j++;
            reverse(arr,i,j-1);
        }
        // System.out.println("out2");
    }
    private void reverse(char[] arr,int i,int j){
        while(i<j&&j<arr.length){
            char tem=arr[i];
            arr[i]=arr[j];
            arr[j]=tem;
            i++;
            j--;
        }
    }
}
