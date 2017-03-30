package leedcode;

public class num10 {
    public boolean isMatch(String s, String p) {
    	
    	
    	return tryMatch(s,p);
    }
    public boolean tryMatch(String s1,String s2){
    	char[] arr1=s1.toCharArray();
    	char[] arr2=s2.toCharArray();
    	int low=0;
    	int high1=arr1.length-1;
    	int high2=arr2.length-1;
    	while(low<Math.min(arr1.length, arr2.length)){
    		if(low+1<arr2.length&&arr2[low+1]=='*'){
    			int index=low;
    			if(tryMatch(s1.substring(low),s2.substring(low+2)))
    				return true;
    			while(index<arr1.length&&(arr1[index]==arr2[low]||arr2[low]=='.')){
    				if(tryMatch(s1.substring(++index),s2.substring(low+2))){
    					return true;
    				}
    			}
    			return false;
    		}
    		if(arr1[low]==arr2[low]||arr2[low]=='.')
    			low++;
    		else
    			return false;
    	}
    	if(low==Math.max(arr1.length, arr2.length)){
    		return true;
    	}
    	else if(low==arr2.length){
    		return false;
    	}
    	else if(low<Math.min(arr1.length, arr2.length)){
    		return false;
    	}
    	else{
    		if((arr2.length-low)%2!=0)
    			return false;
    		else{
    			while(low<arr2.length){
    				if(arr2[low+1]!='*')
    					return false;
    				low=low+2;
    			}
    			return true;
    		}
    	}
    }

	public static void main(String[] args) {
		num10 sol=new num10();
		System.out.println(sol.isMatch("a","ab*"));
		
	}

}






//static boolean isMatch(String s, String p) {
//	int c1=0;
//	int c2=0;
//	int next1=0;
//	int next2=0;
////	int last1=0;
////	int last2=0;
////	int lastPast1=0;
////	int lastPast2=0;
//	int pass1=0;
//	int pass2=0;
//	char char1=' ';
//	char char2=' ';
//	char charNext1=' ';
//	char charNext2=' ';
////	char charLast1=' ';
////	char charLast2=' ';
////	char charLastPast1=' ';
////	char charLastPast2=' ';
////	boolean star=false;
//	while(c1<s.length()&&c2<p.length())
//	{
//		pass1=0;
//		pass2=0;
//		next1=c1+1;
//		next2=c2+1;
////		last1=c1-1;
////		last2=c2-1;
////		lastPast1=c1-2;
////		lastPast2=c2-2;
//		char1=s.charAt(c1);
//		char2=p.charAt(c2);
//		if(next1<s.length())
//			charNext1=s.charAt(next1);
//		else
//			charNext1=' ';
//		if(next2<p.length())
//			charNext2=p.charAt(next2);
//		else
//			charNext2=' ';
//		
////		if(last1<s.length())
////			charLast1=s.charAt(last1);
////		else
////			charLast1=' ';
////		if(last2<p.length())
////			charLast2=p.charAt(last2);
////		else
////			charLast2=' ';
////		
////		if(lastPast1<s.length())
////			charLastPast1=s.charAt(lastPast1);
////		else
////			charLastPast1=' ';
////		if(lastPast2<p.length())
////			charLastPast2=p.charAt(lastPast2);
////		else
////			charLastPast2=' ';
//		
//		
//		if(char1==char2||char1=='.'||char2=='.'){
//			pass1=1;
//			pass2=1;
//			if(char1=='.'&&charNext1=='*')
//			{
//				if(c1+2==s.length())
//					return true;
//				else{
//					if(c2+1==p.length())
//						return false;
//    				int start=c2;
//    				boolean match=false;
//    				while(start<p.length()&&match==false)
//    				{
//	    				String subS1=s.substring(c1+2, s.length());
//	    				String subS2=p.substring(start, p.length());
//    					match=isMatch(subS1,subS2);
//    					start++;
//    				}
//    				return match;
//				}
//			}
//			if(char2=='.'&&charNext2=='*')
//			{
//				if(c2+2==p.length())
//					return true;
//				else{
//					if(c1+1==s.length())
//						return false;
//    				int start=c1;
//    				boolean match=false;
//    				while(start<s.length()&&match==false)
//    				{
//	    				String subS1=s.substring(start, s.length());
//	    				String subS2=p.substring(c2+2, p.length());
//    					match=isMatch(subS1,subS2);
//    					start++;
//    				}
//    				return match;
//				}
//			}
//			if(charNext1=='*'||charNext2=='*'){
//				int[] pass=pushStar(s,p,c1,c2);
//				pass1=pass[0];
//				pass2=pass[1];
//				if(pass[0]==-1)
//					return false;
//			}
//		}
//		else if(char1!=char2)
//		{
//			if(charNext1=='*'){
//				pass1=2;
//			}
//			if(charNext2=='*'){
//				pass2=2;
//			}
//		}
//		if(pass1==0&&pass2==0)
//			return false;
//		c1=c1+pass1;
//		c2=c2+pass2;
//	}
//	if(c1<s.length())
//	{
//		while(c1<s.length())
//		{
//			if(c1+1<s.length())
//				if(s.charAt(c1+1)=='*')
//					c1=c1+2;
//				else
//					return false;
//			else
//				return false;
//		}
//	}
//	if(c2<p.length())
//	{
//		while(c2<p.length())
//		{
//			if(c2+1<p.length())
//				if(p.charAt(c2+1)=='*')
//					c2=c2+2;
//				else
//					return false;
//			else
//				return false;
//		}
//	}
//	return true;
//}
//static boolean pointStar(String s, String p,int push1,int push2,int c1,int c2,int who) {
//	int pastc1=c1;
//	int pastc2=c2;
//	c1=c1+push1;
//	c2=c2+push2;
//	if(c1>=s.length())
//		return false;
//	else{
//			if(s.charAt(c1)==s.charAt(pastc1));
//		}
//	if(c2>=p.length())
//		return false;
//	
//	int next1=0;
//	int next2=0;
//	int pass1=0;
//	int pass2=0;
//	char char1=' ';
//	char char2=' ';
//	char charNext1=' ';
//	char charNext2=' ';
//	while(c1<s.length()&&c2<p.length())
//	{
//		pass1=0;
//		pass2=0;
//		next1=c1+1;
//		next2=c2+1;
//		char1=s.charAt(c1);
//		char2=p.charAt(c2);
//		if(next1<s.length())
//			charNext1=s.charAt(next1);
//		else
//			charNext1=' ';
//		if(next2<p.length())
//			charNext2=p.charAt(next2);
//		else
//			charNext2=' ';
//		
//		
//		if(char1==char2||char1=='.'||char2=='.'){
//			pass1=1;
//			pass2=1;
//			if(charNext1=='*')
//				pass1=0;
//			if(charNext2=='*')
//				pass2=0;
//			if(charNext1=='*'&&charNext2=='*'){
//				pass1=2;
//				pass2=2;
//			}
//		}
//		else if(char1!=char2)
//		{
//			if(charNext1=='*')
//				pass1=2;
//			if(charNext2=='*')
//				pass2=2;
//		}
//		if(pass1==0&&pass2==0)
//			return false;
//		c1=c1+pass1;
//		c2=c2+pass2;
//	}
//	if(c1<s.length())
//	{
//		while(c1<s.length())
//		{
//			if(c1+1<s.length())
//				if(s.charAt(c1+1)=='*')
//					c1=c1+2;
//				else
//					return false;
//			else
//				return false;
//		}
//	}
//	if(c2<p.length())
//	{
//		while(c2<p.length())
//		{
//			if(c2+1<p.length())
//				if(p.charAt(c2+1)=='*')
//					c2=c2+2;
//				else
//					return false;
//			else
//				return false;
//		}
//	}
//	return true;
//}
//static int[] pushStar(String s,String p,int c1,int c2)
//{
//	int push[]={0,0};
//	char target1=s.charAt(c1);
//	char target2=p.charAt(c2);
//	if(target1=='.')
//		target1=target2;
//	if(target2=='.')
//		target2=target1;
//	boolean star1=false;
//	boolean star2=false;
//	int sum1=0;
//	int sum2=0;
//	while(c1<s.length()&&(s.charAt(c1)==target1||s.charAt(c1)=='.'||s.charAt(c1)=='*'))
//	{
//		if(s.charAt(c1)=='*'){
//			star1=true;
//			sum1--;
//			sum1--;
//		}
//		c1++;
//		sum1++;
//		push[0]++;
//	}
//	while(c2<p.length()&&(p.charAt(c2)==target2||p.charAt(c2)=='.'||p.charAt(c2)=='*'))
//	{
//		if(p.charAt(c2)=='*'){
//			star2=true;
//			sum2--;
//		}
//		c2++;
//		sum2++;
//		push[1]++;
//	}
//	if(star1&&star2)
//	{
//		return push;
//	}
//	else if(star1)
//	{
//		if(sum1<=sum2)
//			return push;
//		else
//		{
//			push[0]=-1;
//			return push;
//		}
//	}
//	else if(star2)
//	{
//		if(sum2<=sum1)
//			return push;
//		else
//		{
//			push[0]=-1;
//			return push;
//		}
//	}
//	else
//	{
//		if(sum1==sum2)
//			return push;
//		else
//		{
//			push[0]=-1;
//			return push;
//		}
//			
//	}
//}