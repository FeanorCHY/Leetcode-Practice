package leedcode;

public class num471 {
	public String encode(String s) {
	    String[][] dp = new String[s.length()][s.length()];
	    for(int l=1;l<=s.length();l++){
	    	for(int i=0;i<s.length()-l+1;i++){
	    		int j=i+l;
	    		String sub=s.substring(i,j);
	    		if(sub.length()<5)
	    			dp[i][j-1]=sub;
	    		else{
	    			dp[i][j-1]=sub;
	    			for(int k=i;k<j-1;k++){
	    				if(dp[i][j-1].length()>dp[i][k].length()+dp[k+1][j-1].length())
	    					dp[i][j-1]=dp[i][k]+dp[k+1][j-1];
	    			}
	    			for(int k=1;k<sub.length();k++){
	    				String subsub=sub.substring(0, k);
	    				if(subsub!=null
	    						&&sub.length()%subsub.length()==0
	    						&&sub.replaceAll(subsub, "").length()==0){
	    					String ss=sub.length()/subsub.length()+"["+dp[i][i+k-1]+"]";
	    					if(ss.length()<dp[i][j-1].length())
	    						dp[i][j-1]=ss;
	    				}
	    			}
	    		}
	    	}
	    }
	    
	    return dp[0][s.length()-1];
	}

	public String encode1(String s) {
	    String[][] dp = new String[s.length()][s.length()];
		for(int l=0;l<s.length();l++) {
		    for(int i=0;i<s.length()-l;i++) {
		        int j = i+l;
		        String substr = s.substring(i, j+1);
		        if(j - i < 4) {
		            dp[i][j] = substr;
		        } else {
		            dp[i][j] = substr;
		            for(int k = i; k<j;k++) {
		                if((dp[i][k] + dp[k+1][j]).length() < dp[i][j].length()){
		                    dp[i][j] = dp[i][k] + dp[k+1][j];
		                }
		            }
		            for(int k=0;k<substr.length();k++) {
		                String repeatStr = substr.substring(0, k+1);
		                if(repeatStr != null 
		                   && substr.length()%repeatStr.length() == 0 
		                   && substr.replaceAll(repeatStr, "").length() == 0) {
		                      String ss = substr.length()/repeatStr.length() + "[" + dp[i][i+k] + "]";
		                      if(ss.length() < dp[i][j].length()) {
		                        dp[i][j] = ss;
		                      }
		                 }
		            }
		        }
		    }
		}
	    return dp[0][s.length()-1];
	}
	public static void main(String[] args) {
		num471 sol=new num471();
		System.out.print(sol.encode1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

}


//for(int l=0;l<s.length();l++) {
//    for(int i=0;i<s.length()-l;i++) {
//        int j = i+l;
//        String substr = s.substring(i, j+1);
//        // Checking if string length < 5. In that case, we know that encoding will not help.
//        if(j - i < 4) {
//            dp[i][j] = substr;
//        } else {
//            dp[i][j] = substr;
//            // Loop for trying all results that we get after dividing the strings into 2 and combine the   results of 2 substrings
//            for(int k = i; k<j;k++) {
//                if((dp[i][k] + dp[k+1][j]).length() < dp[i][j].length()){
//                    dp[i][j] = dp[i][k] + dp[k+1][j];
//                }
//            }
//            
//            // Loop for checking if string can itself found some pattern in it which could be repeated.
//            for(int k=0;k<substr.length();k++) {
//                String repeatStr = substr.substring(0, k+1);
//                if(repeatStr != null 
//                   && substr.length()%repeatStr.length() == 0 
//                   && substr.replaceAll(repeatStr, "").length() == 0) {
//                      String ss = substr.length()/repeatStr.length() + "[" + dp[i][i+k] + "]";
//                      if(ss.length() < dp[i][j].length()) {
//                        dp[i][j] = ss;
//                      }
//                 }
//            }
//        }
//    }
//}






//public String encode(String s) {
//	String str=s;
//	char[] arr=str.toCharArray();
//	int k=0;
//	int next[]=new int[arr.length];
//	int rep=1;
//	StringBuilder repp=new StringBuilder();
//	
//	for(int i=1;i<arr.length;i++){
//		if(arr[i]==arr[k]){
//			if(arr[k]==1){
//				k=0;
//				rep++;
//			}
//			else
//				repp.append(arr[i]);
//			k++;
//		}
//		else{
//			if(repp.length()*rep<Integer.toString(rep).length()+repp.length()+2){
//				
//			}
//			k=0;
//		}
//		next[i]=k;
//	}
//	return null;
//}
