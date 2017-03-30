package leedcode;

public class num423 {
    public String originalDigits(String s) {
    	String digit[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    	int[] order={0,2,6,4,5,7,3,8,9,1};
    	char[] key="zwxufvrtio".toCharArray();
    	char[] arr=s.toCharArray();
    	int[] map=new int[26];
    	int[] out=new int[10];
    	for(int i=0;i<arr.length;i++){
    		map[arr[i]-'a']++;
    	}
    	for(int i=0;i<order.length;i++){
    		int cur=order[i];
    		out[cur]=map[key[i]-'a'];
    		int num=map[key[i]-'a'];
    		for(int j=0;j<digit[cur].length();j++){
    			map[digit[cur].charAt(j)-'a']-=num;
    		}
    	}
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<out.length;i++){
    		for(int j=0;j<out[i];j++){
    			sb.append(i);
    		}
    	}
        return sb.toString();
    }
	public static void main(String[] args) {
		num423 sol=new num423();
		System.out.println(sol.originalDigits("owoztneoer"));
	}

}
