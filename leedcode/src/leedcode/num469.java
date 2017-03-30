package leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class num469 {
	public boolean isConvex(List<List<Integer>> points) {
		if(points.size()<=3)
			return true;
		boolean neg=false;
		boolean pos=false;
		for(int A=0;A<points.size();A++){
			int B=(A+1)%points.size();
			int C=(A+1)%points.size();
			int pro=outPro(points.get(A).get(0),points.get(A).get(1),points.get(B).get(0),points.get(B).get(1),points.get(C).get(0),points.get(C).get(1));
			if(pro>0)
				pos=true;
			else if(pro<0)
				neg=true;
			if(neg&&pos)
				return false;
		}
		return true;
	}
	private int outPro(int Ax,int Ay,int Bx,int By,int Cx,int Cy){
		int x1=Ax-Bx;
		int y1=Ay-By;
		int x2=Bx-Cx;
		int y2=By-Cy;
		return x1*y2-x2*y1;
	}
	public static void main(String[] args) {
		int test[][]=
				{{1,1},{2,1},{5,0},{0,0}};
//				{{0,0},{1,1},{0,2},{-1,2},{-1,1}};
//				{{0,0},{1,0},{1,1},{-1,1},{-1,0}};
//				{{0,0},{0,1},{1,1},{1,0}};
				//{{0,0},{0,10},{10,10},{10,0},{5,5}};
		List<List<Integer>> points=new ArrayList<List<Integer>>();
		for(int i=0;i<test.length;i++){
			List<Integer> tem=new ArrayList<Integer>();
			for(int j=0;j<2;j++){
				tem.add(test[i][j]);
			}
			points.add(tem);
		}
		num469 sol=new num469();
		System.out.println(sol.isConvex(points));
	}

}




//public boolean isConvex(List<List<Integer>> points) {
//    // For each set of three adjacent points A, B, C, find the cross product AB · BC. If the sign of
//    // all the cross products is the same, the angles are all positive or negative (depending on the
//    // order in which we visit them) so the polygon is convex.
//    boolean gotNegative = false;
//    boolean gotPositive = false;
//    int numPoints = points.size();
//    int B, C;
//    for (int A = 0; A < numPoints; A++) {
//        // Trick to calc the last 3 points: n - 1, 0 and 1.
//        B = (A + 1) % numPoints;
//        C = (B + 1) % numPoints;
//
//        int crossProduct =
//            crossProductLength(
//                points.get(A).get(0), points.get(A).get(1),
//                points.get(B).get(0), points.get(B).get(1),
//                points.get(C).get(0), points.get(C).get(1));
//        if (crossProduct < 0) {
//            gotNegative = true;
//        }
//        else if (crossProduct > 0) {
//            gotPositive = true;
//        }
//        if (gotNegative && gotPositive) return false;
//    }
//
//    // If we got this far, the polygon is convex.
//    return true;
//}
//
//// Return the cross product AB x BC.
//// The cross product is a vector perpendicular to AB and BC having length |AB| * |BC| * Sin(theta) and
//// with direction given by the right-hand rule. For two vectors in the X-Y plane, the result is a
//// vector with X and Y components 0 so the Z component gives the vector's length and direction.
//private int crossProductLength(int Ax, int Ay, int Bx, int By, int Cx, int Cy)
//{
//    // Get the vectors' coordinates.
//    int BAx = Ax - Bx;
//    int BAy = Ay - By;
//    int BCx = Cx - Bx;
//    int BCy = Cy - By;
//
//    // Calculate the Z coordinate of the cross product.
//    return (BAx * BCy - BAy * BCx);
//}









//public boolean isConvex(List<List<Integer>> points) {
//	if(points.size()<=3)
//		return true;
//	Collections.sort(points,new Comparator<List<Integer>>(){
//
//		@Override
//		public int compare(List<Integer> o1, List<Integer> o2) {
//			// TODO Auto-generated method stub
//			return o1.get(0)==o2.get(0)?o1.get(1)-o2.get(1):o1.get(0)-o2.get(0);
//		}
//		
//	});
//	int low=0;
//	int up=0;
//	int count=0;
//	for(int i=0;i<points.size();i++){
//		if(i+2<points.size()&&points.get(i+2).get(0)==points.get(i).get(0))
//			return false;
//		else if(i==points.size()-1&&count>=2){
//			if(points.get(i).get(1)<low||points.get(i).get(1)>up){
//				return false;
//			}
//		}
//		else if(i+1==points.size()-1&&points.get(i+1).get(0)==points.get(i).get(0)&&count>=2){
//			if(points.get(i).get(1)<low||(up!=low&&points.get(i+1).get(1)>up)){
//				return false;
//			}
//		}
//		else if(i!=0){
//			if(points.get(i).get(1)>low){
//				return false;
//			}
//			if(i+1<points.size()&&points.get(i+1).get(0)==points.get(i).get(0)){
//				if(points.get(i+1).get(1)<up)
//					return false;
//			}
//		}
//		low=points.get(i).get(1);
//		if(i+1<points.size()&&points.get(i+1).get(0)==points.get(i).get(0)){
//			up=points.get(i+1).get(1);
//			i++;
//		}
//		else
//			up=points.get(i).get(1);
//		count++;
//	}
//    return true;
//}