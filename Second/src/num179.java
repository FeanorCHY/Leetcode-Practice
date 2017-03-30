import java.util.Arrays;
import java.util.Comparator;

public class num179 {

	public static void main(String[] args) {
		String[] arr={"12","121"};
//		Arrays.sort(arr,new Comparator<String>(){
//		12112
//		12121
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return o1.compareTo(o2);
//			}
//		});
//		 Arrays.sort(arr);
        Arrays.sort(arr,new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                char[] arr1=o1.toCharArray();
                char[] arr2=o2.toCharArray();
                for(int i=0;i<Math.min(arr1.length,arr2.length);i++){
                    if(arr1[i]!=arr2[i])
                        return arr1[i]-arr2[i];
                }
                if(arr2.length==arr1.length)
                    return 0;
                int com=arr2.length<arr1.length?arr1[arr2.length]-arr2[0]:arr1[0]-arr2[arr1.length];
                System.out.println(o1+" com "+o2+":"+com);
                return com;
            }
        });
		System.out.println("12".compareTo("128"));
//        char[] arr1="128".toCharArray();
//        char[] arr2="12".toCharArray();
//		System.out.println(arr2.length<arr1.length?arr1[arr2.length]-arr2[0]:arr2[arr1.length]-arr2[0]);
	}

}
