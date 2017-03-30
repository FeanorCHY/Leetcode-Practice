package leedcode;

import java.util.Stack;

public class num71 {
    public String simplifyPath(String path) {
    	Stack<String> hs=new Stack<String>();
    	boolean slash=true;
    	boolean point=false;
    	String content="";
    	for(int i=0;i<path.length();i++){
    		char thisC=path.charAt(i);
    		if(slash){
    			if(point){
    				if(thisC=='.'){
    					if(i==path.length()-1){
    						if(!hs.isEmpty())
    							hs.pop();
    					}
    					else if(path.charAt(i+1)=='/'){
    						if(!hs.isEmpty())
    							hs.pop();
    					}
    					else{
    						content="."+thisC;
    						slash=false;
    						point=false;
    					}
    				}
    				else if(thisC=='/'){
    					point=false;
    				}
    				else{
    					content="."+thisC;
    					point=false;
    					slash=false;
    				}
    			}
    			else{
    				if(thisC=='.'){
    					point=true;
    				}
    				else if(thisC=='/');
    				else{
    					slash=false;
    					content=thisC+"";
    				}
    			}
    				
    		}
        	else{
        		if(thisC=='/'){
        			slash=true;
        			hs.push(content);
//        			content="";
        		}
        		else{
        			content=content+thisC;
        		}
        	}
    	}
    	if(content!=""){
    		hs.push(content);
    	}
    	if(hs.isEmpty())
    	    return "/";
    	String result="";
    	for(String str:hs){
    		result=result+"/"+str;
    	}
        return result;
    }
	public static void main(String[] args) {
		num71 test=new num71();
		System.out.println(test.simplifyPath("/.../asdas/asdasd"));

	}

}
