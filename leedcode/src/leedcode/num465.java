package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class loan{
	int lender;
	int amount;
	public loan(int lender,int amount){
		this.lender=lender;
		this.amount=amount;
	}
}
public class num465 {
	public int minTransfers(int[][] trans) {
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int[] tran:trans){
			int from=tran[0];
			int to=tran[1];
			int val=tran[2];
			map.put(from, map.getOrDefault(from, 0)-val);
			map.put(to, map.getOrDefault(to, 0)+val);
		}
		List<Integer> list=new ArrayList<Integer>();
		for(int each:map.keySet()){
			if(map.get(each)!=0)
				list.add(map.get(each));
		}
		Collections.sort(list);
		return removeMatch(list)+unMatch(list,0);
	}
	private int removeMatch(List<Integer> list){
		int l=0;
		int r=list.size()-1;
		int match=0;
		while(l<r){
			if(list.get(l)>0)
				break;
			if(list.get(l)==(-1)*list.get(r)){
				list.remove(l);
				list.remove(r-1);
				r=r-2;
				match++;
			}
			else if((-1)*list.get(l)>list.get(r)){
				l++;
			}
			else
				r--;
		}
		return match;
	}
	private int unMatch(List<Integer> list,int start){
		int step=Integer.MAX_VALUE;
		while(start<list.size()&&list.get(start)==0)
			start++;
		if(start==list.size())
			return 0;
		for(int i=start+1;i<list.size();i++){
			if(list.get(start)*list.get(i)>0)
				continue;
			list.set(i, list.get(i)+list.get(start));
			step=Math.min(step, unMatch(list,start+1)+1);
			list.set(i, list.get(i)-list.get(start));
		}
		return step;
	}

	public static void main(String[] args) {
		int[][] test={{0,1,10}, {1,0,1}, {1,2,5}, {2,0,6}};
		num465 sol=new num465();
		System.out.println(sol.minTransfers(test));
	}

}


//public int minTransfers(int[][] transactions) {
//    if (transactions == null || transactions.length == 0 || transactions[0].length == 0)
//        return 0;
//    //calculate delta for each account
//    Map<Integer, Integer> accountToDelta = new HashMap<Integer, Integer>();
//    for (int[] transaction : transactions) {
//        int from = transaction[0];
//        int to = transaction[1];
//        int val = transaction[2];
//        if (!accountToDelta.containsKey(from)) {
//            accountToDelta.put(from, 0);
//        }
//        if (!accountToDelta.containsKey(to)) {
//            accountToDelta.put(to, 0);
//        }
//        accountToDelta.put(from, accountToDelta.get(from) - val);
//        accountToDelta.put(to, accountToDelta.get(to) + val);
//    }
//    List<Integer> deltas = new ArrayList<Integer>();
//    for (int delta : accountToDelta.values()) {
//        if (delta != 0)
//            deltas.add(delta);
//    }
//    //since minTransStartsFrom is slow, we can remove matched deltas to optimize it
//    //for example, if account A has balance 5 and account B has balance -5, we know
//    //that one transaction from B to A is optimal.
//    int matchCount = removeMatchDeltas(deltas);
//    //try out all possibilities to get minimum number of transactions
//    return matchCount + minTransStartsFrom(deltas, 0);
//}
//
//private int removeMatchDeltas(List<Integer> deltas) {
//    Collections.sort(deltas);
//    int left = 0;
//    int right = deltas.size() - 1;
//    int matchCount = 0;
//    while (left < right) {
//        if (-1 * deltas.get(left) == deltas.get(right)) {
//            deltas.remove(left);
//            deltas.remove(right - 1);
//            right -= 2;
//            matchCount++;
//        } else if (-1 * deltas.get(left) > deltas.get(right)) {
//            left++;
//        } else {
//            right--;
//        }
//    }
//    return matchCount;
//}
//
//private int minTransStartsFrom(List<Integer> deltas, int start) {
//    int result = Integer.MAX_VALUE;
//    int n = deltas.size();
//    while (start < n && deltas.get(start) == 0)
//        start++;
//    if (start == n)
//        return 0;
//    for (int i = start + 1; i < n; i++) {
//        if ((long) deltas.get(i) * deltas.get(start) < 0) {
//            deltas.set(i, deltas.get(i) + deltas.get(start));
//            result = Math.min(result, 1 + minTransStartsFrom(deltas, start + 1));
//            deltas.set(i, deltas.get(i) - deltas.get(start));
//        }
//    }
//    return result;
//}


//public int minTransfers(int[][] trans) {
//	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
//	int len=0;
//	for(int[] tran:trans){
//		if(tran[0]>tran[1]){
//			int tem=tran[0];
//			tran[0]=tran[1];
//			tran[1]=tem;
//			tran[2]=-tran[2];
//			if(!map.containsKey(tran[0])){
//				tran[0]=len;
//				map.put(tran[0],len++);
//			}
//			else
//				tran[0]=map.get(tran[0]);
//			if(!map.containsKey(tran[1])){
//				tran[1]=len;
//				map.put(tran[1],len++);
//			}
//			else
//				tran[1]=map.get(tran[1]);
//		}
//	}
//	int[] edge=new int[len];
//	Queue<Integer> q=new LinkedList<Integer>();
//	for(int[] tran:trans){
//		edge[tran[1]]++;
//	}
//	for(int i=0;i<edge.length;i++){
//		if(edge[i]==0)
//			q.add(i);
//	}
//	if(q.isEmpty())
//		q.add(0);
//	int index=0;
//	while(!q.isEmpty()){
//		int id=q.poll();
//		for(int[] tran:trans){
//			if(tran[0]==id)
//				edge[tran[1]]--;
//			if(edge[tran[1]]==0]){
//				
//			}
//				
//		}
//	}
//	return 0;
//}




//Arrays.sort(trans,new Comparator<int[]>(){
//	@Override
//	public int compare(int[] o1, int[] o2) {
//		// TODO Auto-generated method stub
//		return o1[2]-o2[2];
//	}
//});
//HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<Integer,HashMap<Integer,Integer>>();
//int count=trans.length;
//for(int i=0;i<trans.length;i++){
//	int[] tran=trans[i];
//	if(!map.containsKey(tran[0])){
//		map.put(tran[0], new HashMap<Integer,Integer>());
//	}
//	int amount=tran[2];
//	HashMap<Integer,Integer> cur=map.get(tran[0]);
//	if(map.containsKey(tran[1])){
//		HashMap<Integer,Integer> pq=map.get(tran[1]);
//		for(int each:pq.keySet()){
//			if(pq.get(each)<amount){
//				amount-=pq.get(each);
//				cur.put(each, pq.get(each));
//				pq.put(each, 0);
//				if()
//			}
//		}
//	}
//	if(amount>0){}
////		map.get(tran[0]).put();
//	else
//		count--;
//}