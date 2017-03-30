package leedcode;

public class num352 {

	public static void main(String[] args) {
		int[] test={6,0,4,8,7};
		SummaryRanges sr=new SummaryRanges();
		for(int i=0;i<test.length;i++){
			sr.addNum(test[i]);
		}
		for(Interval each:sr.getIntervals()){
			System.out.println(each.toString());
		}
	}

}
