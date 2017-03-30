package leedcode;

public class num418 {
	int[] lensb;
	int[] lensf;
    public int wordsTyping(String[] sentence, int rows, int cols) {
    	int x=0;
    	int count=0;
    	int y=0;
    	int index=0;
    	cols=cols+1;
    	lensb=new int[sentence.length];
    	lensf=new int[sentence.length];
    	if(lensb.length==0){
    		return rows*cols;
    	}
    	for(int i=lensb.length-1;i>=0;i--){
    		if(i==lensb.length-1){
    			lensb[i]=sentence[i].length()+1;
    		}
    		else
    			lensb[i]=sentence[i].length()+1+lensb[i+1];
    	}
    	int less=-1;
    	for(int i=0;i<lensf.length;i++){
    		if(i==0){
    			lensf[i]=sentence[i].length()+1;
    		}
    		else
    			lensf[i]=sentence[i].length()+1+lensf[i-1];
    		if(less==-1&&lensf[i]>cols)
    			less=i-1;
    	}
    	if(lensb[0]==cols){
    		return rows;
    	}
    	else if(lensb[0]>cols){
    		while(x<rows){
    			int tem=Bsearch(index,cols-y);
    			if(tem==lensf.length-1)
    				count++;
    			if(tem<index){
    				y=0;
    				x++;
    			}
    			else{
        			y+=lensf[tem]-(index==0?0:lensf[index-1]);
        			index=(tem+1)%sentence.length;
    			}
    		}
    	}
    	else{
    		while(x<rows){
    			int left=cols-y;
    			count+=left/lensb[0];
    			left=left%lensb[0];
    			y=cols-left;
    			int tem=Bsearch(0,left);
    			if(tem<index){
    				y=0;
    				x++;
    			}
    			else{
    				x++;
    				y=(tem==lensb.length-1?0:lensb[tem+1]);
    				if(tem!=lensb.length-1&&x<rows)
    					count++;
    				index=0;
    			}
    		}
    		
    	}
    	return count;
    }
    private int Bsearch(int start,int target){
    	int diff=start==0?0:lensf[start-1];
    	int end=lensf.length-1;
    	while(start<=end){
    		int mid=(start+end)/2;
    		if(lensf[mid]-diff==target)
    			return mid;
    		else if(lensf[mid]-diff>target)
    			end=mid-1;
    		else
    			start=mid+1;
    	}
    	return end;
    }
	public static void main(String[] args) {
		String[] test={"a", "b"};
		num418 sol=new num418();
		System.out.println(sol.wordsTyping(test, 3, 6));
	}

}
