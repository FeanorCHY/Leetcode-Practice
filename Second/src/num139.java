import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class num139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
	public static void main(String[] args) {
		String test[]={"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa"};
		List<String> wordDict=new ArrayList<String>();
		for(String str:test){
			wordDict.add(str);
		}
		num139 sol=new num139();
		System.out.println(sol.wordBreak("aaaaaaaad", wordDict));
	}

}
