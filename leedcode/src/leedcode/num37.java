package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class num37 {
    public void solveSudoku(char[][] board) {
    	solve(board);
    }
	public boolean solve(char[][] board){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]!='.')
					continue;
				for(int k=1;k<=9;k++){
					if(valid(board,i,j,k)){
						board[i][j]=(char)(k+'0');
						if(solve(board))
							return true;
						board[i][j]='.';
					}
				}
				return false;
			}
		}
		return true;
	}
	public boolean valid(char[][] board,int x,int y,int val){
		int cellx=(x/3)*3;
		int celly=(y/3)*3;
		for(int i=0;i<9;i++){
			if(board[x][i]==val+'0'||board[i][y]==val+'0'||board[cellx+i/3][celly+i%3]==val+'0')
				return false;
		}
		return true;
	}
    
	public static void main(String[] args) {
		char test[][]={"..9748...".toCharArray(),"7........".toCharArray(),".2.1.9...".toCharArray(),"..7...24.".toCharArray(),".64.1.59.".toCharArray(),".98...3..".toCharArray(),"...8.3.2.".toCharArray(),"........6".toCharArray(),"...2759..".toCharArray()};
		num37 sol=new num37();
		for(int i=0;i<9;i++){
			System.out.println(Arrays.toString(test[i]));
		}
		sol.solveSudoku(test);
		for(int i=0;i<9;i++){
			System.out.println(Arrays.toString(test[i]));
		}
	}

}

//TreeSet<Integer> glob=new TreeSet<Integer>();
//TreeSet<Integer> hor[]=new TreeSet[9];
//TreeSet<Integer> ver[]=new TreeSet[9];
//TreeSet<Integer> cell[]=new TreeSet[9];
//int[][] count=new int[9][9];
//char[][] board;
//public void solveSudoku(char[][] board) {
//	this.board=board;
//	for(int i=1;i<=9;i++){
//		glob.add(i);
//	}
//	for(int i=0;i<9;i++){
//		hor[i]=new TreeSet<Integer>();
//		ver[i]=new TreeSet<Integer>();
//		cell[i]=new TreeSet<Integer>();
//	}
//	for(int i=0;i<9;i++){
//		for(int j=0;j<9;j++){
//			if(board[i][j]!='.'){
//				count[i][j]=-1;
//				hor[i].add(board[i][j]-'0');
//				ver[j].add(board[i][j]-'0');
//				cell[(i/3)*3+j/3].add(board[i][j]-'0');
//			}
//		}
//	}
//	for(int i=0;i<9;i++){
//		for(int j=0;j<9;j++){
//			if(count[i][j]!=-1){
//				TreeSet<Integer> tem=new TreeSet<Integer>();
//				tem.addAll(hor[i]);
//				tem.addAll(ver[j]);
//				tem.addAll(cell[(i/3)*3+j/3]);
//				count[i][j]=tem.size();
//				if(tem.size()==8){
//					removeAll(i,j,tem);
//				}
//			}
//			
//		}
//	}
//	for(int i=0;i<9;i++){
//		for(int j=0;j<9;j++){
//			if(count[i][j]==7){
//				TreeSet<Integer> tem=new TreeSet<Integer>();
//				tem.addAll(hor[i]);
//				tem.addAll(ver[j]);
//				tem.addAll(cell[(i/3)*3+j/3]);
//		    	int lost=1;
//		    	for(int each:tem){
//		    		if(each!=lost){
//		    			TreeSet<Integer> tem2=new TreeSet<Integer>(tem);
//		    			tem2.add(lost);
//    					removeAll(i,j,tem);
//		    		}
//		    		else{
//		    			lost++;
//		    		}
//		    	}
//			}
//			
//		}
//	}
//	System.out.println();
//	for(int i=0;i<9;i++){
//		System.out.println(Arrays.toString(board[i]));
//	}
//	System.out.println();
//}
//public void removeAll(int x,int y,TreeSet<Integer> tem){
//	int lost=1;
//	for(int each:tem){
//		if(each!=lost){
//			break;
//		}
//		else
//			lost++;
//	}
//	count[x][y]=-1;
//	board[x][y]=(char)('0'+lost);
//	if((char)('0'+lost)==':')
//		System.out.println();
//	System.out.println();
//	for(int i=0;i<9;i++){
//		System.out.println(Arrays.toString(board[i]));
//	}
//	hor[x].add(lost);
//	ver[y].add(lost);
//	cell[(x/3)*3+y/3].add(lost);
//	int cellx=(x/3)*3;
//	int celly=(y/3)*3;
//	for(int i=0;i<9;i++){
//		TreeSet<Integer> tem2=new TreeSet<Integer>();
//		if(count[i][y]!=-1){
//			tem2.addAll(hor[i]);
//			tem2.addAll(ver[y]);
//			tem2.addAll(cell[(i/3)*3+y/3]);
//			count[i][y]=tem2.size();
//    		if(count[i][y]==8){
//				removeAll(i,y,tem2);
//    		}
//		}
//
//		if(count[x][i]!=-1){
//			tem2=new TreeSet<Integer>();
//			tem2.addAll(hor[x]);
//			tem2.addAll(ver[i]);
//			tem2.addAll(cell[(x/3)*3+i/3]);
//    		count[x][i]=tem2.size();
//    		if(count[x][i]==8){
//				removeAll(x,i,tem2);
//    		}
//		}
//
//		if(count[cellx+i/3][celly+y%3]!=-1){
//    		if(cellx+i/3==x&&celly+y%3==y)
//    			continue;
//			tem2=new TreeSet<Integer>();
//			tem2.addAll(hor[cellx+i/3]);
//			tem2.addAll(ver[celly+y%3]);
//			tem2.addAll(cell[(cellx/3)*3+celly/3]);
//    		count[cellx+i/3][celly+y%3]=tem2.size();
//    		if(count[cellx+i/3][celly+y%3]==8){
//				removeAll(cellx+i/3,celly+y%3,tem2);
//    		}
//		}
//	}