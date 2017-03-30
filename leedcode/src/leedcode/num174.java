package leedcode;

public class num174 {
    public int calculateMinimumHP(int[][] dungeon) {
    	if(dungeon.length==0){
    		return 0;
    	}
    	int[][] least=new int[dungeon.length][dungeon[0].length];
    	least[dungeon.length-1][dungeon[0].length-1]=(1-dungeon[dungeon.length-1][dungeon[0].length-1])<1?1:1-dungeon[dungeon.length-1][dungeon[0].length-1];
    	
    	for(int i=dungeon.length-1;i>=0;i--){
    		for(int j=dungeon[0].length-1;j>=0;j--){
    			if(!(i==dungeon.length-1&&j==dungeon[0].length-1)){
    				if(i==dungeon.length-1){
    					least[i][j]=least[i][j+1]-dungeon[i][j]<1?1:least[i][j+1]-dungeon[i][j];
    				}
    				else if(j==dungeon[0].length-1){
    					least[i][j]=least[i+1][j]-dungeon[i][j]<1?1:least[i+1][j]-dungeon[i][j];
    				}
    				else{
    					least[i][j]=Math.min(least[i+1][j]-dungeon[i][j]<1?1:least[i+1][j]-dungeon[i][j], least[i][j+1]-dungeon[i][j]<1?1:least[i][j+1]-dungeon[i][j]);
    				}
    			}
    		}
    	}
    	
    	
    	return least[0][0];
    }
	public static void main(String[] args) {
		int test[][]={{0,0,0},{1,1,-1}};//{{-2,-3,3},{-5,-10,1},{10,30,-5}};
		num174 sol=new num174();
		System.out.println(sol.calculateMinimumHP(test));
	}

}
