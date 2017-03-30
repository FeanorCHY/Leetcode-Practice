import java.util.ArrayList;
import java.util.List;

public class num229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        int num1=-1;
        int num2=-2;
        int count1=0;
        int count2=0;
        for(int each:nums){
            if(each==num1)
                count1++;
            else if(each==num2)
                count2++;
            else if(count1==0){
                num1=each;
                count1=1;
            }
            else if(count2==0){
                num2=each;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int each:nums){
            if(each==num1)
                count1++;
            else if(each==num2)
                count2++;
        }
        int fre=nums.length/3;
        if(count1>fre)
            res.add(num1);
        if(count2>fre)
            res.add(num2);
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
