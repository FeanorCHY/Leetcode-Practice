package leedcode;

public class num223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int x1=Math.max(A, E);
    	int y1=Math.max(B, F);
    	int x2=Math.min(C, G);
    	int y2=Math.min(D, H);
    	int duc=0;
    	if(!(x1>=x2||y1>=y2))
    		duc=(x2-x1)*(y2-y1);
        return (C-A)*(D-B)+(G-E)*(H-F)-duc;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
