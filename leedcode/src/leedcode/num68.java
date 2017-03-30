package leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> list=new ArrayList<String>();
    	int count=0;
    	Queue<String> q=new LinkedList<String>();
    	for(int i=0;i<words.length;i++){
    		if(count+words[i].length()>maxWidth){
    			StringBuilder str=new StringBuilder();
    			if(q.size()==1){
    				str.append(q.poll());
	    			int space=maxWidth-count+1;
    				for(int j=0;j<space;j++){
    					str.append(" ");
    				}
    				
    			}
    			else{
	    			int space=maxWidth-count+1;
	    			int extra=space%(q.size()-1);
	    			int every=space/(q.size()-1);
	    			while(!q.isEmpty()){
	    				String each=q.poll();
	    				str.append(each);
	    				if(!q.isEmpty()){
		    				str.append(" ");
		    				for(int j=0;j<every;j++){
		    					str.append(" ");
		    				}
		    				if(extra-->0){
		    					str.append(" ");
		    				}
	    				}
	    			}
    			}
    			list.add(str.toString());
    			count=words[i].length()+1;
    			q.clear();
    			q.add(words[i]);
    		}
    		else{
    			q.add(words[i]);
    			count+=words[i].length()+1;
    		}
    	}

		StringBuilder str=new StringBuilder();
		int space=maxWidth-count+1;
		while(!q.isEmpty()){
			String each=q.poll();
			str.append(each);
			if(!q.isEmpty()){
				str.append(" ");
			}
		}
		for(int i=0;i<space;i++){
			str.append(" ");
		}
    	list.add(str.toString());
    	
        return list;
    }

	public static void main(String[] args) {
		num68 sol=new num68();
//		String[] words={"This", "is", "an","12345678910", "example", "of", "text", "justification."};
		String[] words={""};
		System.out.println(sol.fullJustify(words, 0));
	}

}
