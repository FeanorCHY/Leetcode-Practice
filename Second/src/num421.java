import java.util.HashSet;
import java.util.Set;

class XORTrie{
    XORTrie[] next=new XORTrie[2];
}
public class num421 {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 4; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
	public static void main(String[] args) {
		int[] test={3,10,5,25,2,8};
		num421 sol=new num421();
		System.out.println(sol.findMaximumXOR(test));
	}

}
