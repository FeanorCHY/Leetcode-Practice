
public class num423 {
	//O(N)
    public String originalDigits(String s) {
        if(s==null||s.length()==0)
            return "";
        int[] alp=new int[26];
        char[] arr=s.toCharArray();
        for(char c:arr)
            alp[c-'a']++;
        int nums[]=new int[10];
        String number[]={"zero","six","two","seven","four","five","three","one","eight","nine"};
        char[] key={'z','x','w','s','u','f','r','o','t','i'};
        int[] pos={0,6,2,7,4,5,3,1,8,9};
        for(int i=0;i<10;i++){
            if(alp[key[i]-'a']>0){
                nums[pos[i]]=alp[key[i]-'a'];
                for(char c:number[i].toCharArray())
                    alp[c-'a']-=nums[pos[i]];
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<10;i++){
            for(int j=0;j<nums[i];j++)
                res.append(i);
        }
        return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
