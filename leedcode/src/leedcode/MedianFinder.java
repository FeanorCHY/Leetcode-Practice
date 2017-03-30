package leedcode;

class MedianNode{
	int val;
	MedianNode left;
	MedianNode right;
	int leftNum;
	int rightNum;
	public MedianNode(int val){
		this.val=val;
		left=null;
		right=null;
		leftNum=0;
		rightNum=0;
	}
}


public class MedianFinder {

	private void addNode(MedianNode root,MedianNode node){
		if(node.val>=root.val){
			root.rightNum=root.rightNum+1;
			if(root.right==null)
				root.right=node;
			else
				addNode(root.right,node);
		}
		else{
			root.leftNum=root.leftNum+1;
			if(root.left==null)
				root.left=node;
			else
				addNode(root.left,node);
		}
	}
	int n=0;
	MedianNode mnroot=null;
    // Adds a number into the data structure.
    public void addNum(int num) {
    	n++;
        if(mnroot==null)
        	mnroot=new MedianNode(num);
        else
        	addNode(mnroot,new MedianNode(num));
    }
    private int find(MedianNode root,int k){
    	if(k==root.leftNum+1)
    		return root.val;
    	else if(k<=root.leftNum)
    		return find(root.left,k);
    	else{
    		return find(root.right,k-root.leftNum-1);
    	}
    }
    // Returns the median of current data stream
    public double findMedian() {
    	if(mnroot==null)
    		return 0;
    	if(n%2==0){
    		return ((double)find(mnroot,n/2)+(double)find(mnroot,n/2+1))/2;
    	}
    	else 
    		return (double)find(mnroot,n/2+1);
    }
}
