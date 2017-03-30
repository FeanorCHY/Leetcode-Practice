package leedcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num22 {
	static int maxPar;
	static ArrayList<String> strArr;
//    public static List<String> generateParenthesis(int n) {
//        maxPar=n;
//		  strArr=new ArrayList<String>();
//    }
    public static void pushPar(Stack<Integer> sta,String parStr,int push,int donePush)
    {
    	Stack<Integer> nSta=(Stack<Integer>)sta.clone();
    	if(push==1)
    	{
    		if(donePush==maxPar)
    			return;
    		else{
    			nSta.push(1);
    			System.out.println(parStr+"("+"   is push? "+push);
    		}
    		if(donePush==maxPar-1){
    			pushPar(nSta,parStr+"(",0,donePush+1);
    		}
			else{
    			pushPar(nSta,parStr+"(",1,donePush+1);
    			pushPar(nSta,parStr+"(",0,donePush+1);
			}
    	}
    	else{
    		System.out.println(parStr+")"+"   is push? "+push);
    		if(nSta.empty())
    			return;
    		else{
    			nSta.pop();
    			if(nSta.empty()&&donePush==maxPar){
    				strArr.add(parStr+")");
    				return;
    			}
    			else{
        			pushPar(nSta,parStr+")",1,donePush);
        			pushPar(nSta,parStr+")",0,donePush);
    			}
    		}
    		
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxPar=3;
		strArr=new ArrayList<String>();
		pushPar(new Stack<Integer>(),"",1,0);
		System.out.println(strArr);
		
	}

}
