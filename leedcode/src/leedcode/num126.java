package leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//class Node {
//    String word;
//    int level;
//
//    public Node(String word, int level) {
//        this.word = word;
//        this.level = level;
//    }
//}
public class num126 {

    private String end;
    private List<List<String>> res;
    private Map<String, List<String>> maps;
    String beginWord;
    public List<List<String>> findLadders(String beginWord, String endWord,Set<String> wordList) {
    	this.end=endWord;
    	this.beginWord=beginWord;
    	this.res=new ArrayList<List<String>>();
    	this.maps=new HashMap<String, List<String>>();
    	wordList.remove(beginWord);
    	ArrayList<String> linked=new ArrayList<String>();
    	Set<String> searched=new HashSet<String>();
		wordList.remove(beginWord);
    	linked.add(beginWord);
		boolean Found=false;
    	while(!linked.isEmpty()){
	    	for(String each:linked){
	    		char[] arr=each.toCharArray();
	    		for(int i=0;i<each.length();i++){
		    		boolean find=false;
	    			char tem=arr[i];
		    		for(int j='a';j<'z';j++){
		    			if(j==tem)
		    				continue;
		    			arr[i]=(char)j;
		    			String arrStr=new String(arr);
		    			if(arrStr.equals(endWord)){
		    				find=true;
		    				Found=true;
		    				if(maps.containsKey(arrStr)){
		    					maps.get(arrStr).add(each);
		    				}
		    				else{
		    					List<String> tem2=new ArrayList<String>();
		    					tem2.add(each);
		    					maps.put(arrStr, tem2);
		    				}
	    					break;
		    			}
		    			else if(wordList.contains(arrStr)){
		    				searched.add(arrStr);
		    				if(maps.containsKey(arrStr)){
		    					maps.get(arrStr).add(each);
		    				}
		    				else{
		    					List<String> tem2=new ArrayList<String>();
		    					tem2.add(each);
		    					maps.put(arrStr, tem2);
		    				}
		    			}
		    		}
		    		if(find)
		    			break;
		    		arr[i]=tem;
	    		}
	    	}
	    	if(Found)
	    		break;
			linked.clear();
			linked.addAll(searched);
			wordList.removeAll(searched);
			searched.clear();
    	}
    	if(Found){
    		build(end,new ArrayList<String>());
    	}
    		return res;
    }
public void build(String start,List<String> got){
	if(start.equals(beginWord)){
		List<String> tem=new ArrayList<String>(got);
		Collections.reverse(tem);
		tem.add(end);
		res.add(tem);
	}
	else{
		List<String> tem=maps.get(start);
		for(String str:tem){
			got.add(str);
			build(str,got);
			got.remove(got.size()-1);
		}
	}
}
	public static void main(String[] args) {
		String[] test={"a","b","c"};//={"hot","dot","dog","lot","log"};
		Set<String> set=new HashSet<String>();
		for(int i=0;i<test.length;i++){
			set.add(test[i]);
		}
		num126 sol=new num126();
		System.out.println(sol.findLadders("a", "c", set));
	}

	
}



//res = new ArrayList<>();
//// unvisited words set
//dict.add(end);
//dict.remove(start);
//// used to record the map info of <word : the words of next level>
//maps = new HashMap<>();
//for (String e : dict) {
//    maps.put(e, new ArrayList<>());
//}
//
//// BFS to search from the end to start
//Queue<Node> queue = new LinkedList<Node>();
//queue.add(new Node(start, 0));
//boolean found = false;
//int finalLevel = Integer.MAX_VALUE;
//int currentLevel = 0;
//Set<String> visitedWordsInThisLevel = new HashSet<>();
//
//while (!queue.isEmpty()) {
//    Node node = queue.poll();
//    String word = node.word;
//    int level  = node.level;
//    if (level > finalLevel) {
//        break;
//    }
//    if (level > currentLevel) {
//        dict.removeAll(visitedWordsInThisLevel);
//        visitedWordsInThisLevel.clear();
//    }
//    currentLevel = level;
//    char[] wordCharArray = word.toCharArray();
//    for (int i = 0; i < word.length(); ++i) {
//        char originalChar = wordCharArray[i];
//        boolean foundInThisCycle = false;
//        for (char c = 'a'; c <= 'z'; ++c) {
//            wordCharArray[i] = c;
//            String newWord = new String(wordCharArray);
//            if (c != originalChar && dict.contains(newWord)) {
//                maps.get(newWord).add(word);
//                if (newWord.equals(end)) {
//                    found = true;
//                    finalLevel = currentLevel;
//                    foundInThisCycle = true;
//                    break;
//                }
//                if (visitedWordsInThisLevel.add(newWord)) {
//                    queue.add(new Node(newWord, currentLevel + 1));
//                }
//            }
//        }
//        if (foundInThisCycle) {
//            break;
//        }
//        wordCharArray[i] = originalChar;
//    }
//}
//if(found){
//    List<String> tmplist = new LinkedList<>();
//    generatePath(end,start,tmplist);
//}
//return res;
//}
//private void generatePath(String start,String end,List<String> list){
//if(start.equals(end)){
//    List<String> tmplist = new LinkedList<>(list);
//    tmplist.add(end);
//    Collections.reverse(tmplist);
//    res.add(tmplist);
//    return;
//}
//list.add(start);
//List<String> tmplist = maps.get(start);
//for(String e:tmplist)
//    generatePath(e,end,list);
//list.remove(list.size()-1);
//}





//List<List<String>> result=new ArrayList<List<String>>(); 
//String endWord;
//public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
//	this.endWord=endWord;
//	List<List<String>> listlist=new ArrayList<List<String>>(); 
//	LinkedList<String> next=new LinkedList<String>();
//	List<String> list=new ArrayList<String>();
//	list.add(beginWord);
//	listlist.add(list);
//	next.add(beginWord);
//	while(!listlist.isEmpty()){
////		LinkedList<String> tem=new LinkedList<String>();
//		List<List<String>> tem=new ArrayList<List<String>>();
//		for(List<String> each: listlist){
//			char[] arr=each.get(each.size()-1).toCharArray();
//    		boolean find=false;
//			for(int i=0;i<arr.length;i++){
//				char origin=arr[i];
//				for(char c='a';c<='z';c++){
//					if(origin==c)
//						continue;
//					arr[i]=c;
//					String str=new String(arr);
//					if(endWord.equals(str)){
//						find=true;
//						List<String> newone=new ArrayList<String>(each);
//						newone.add(str);
//						result.add(newone);
//						break;
//					}
//					else if(wordList.contains(str)){
//						List<String> newone=new ArrayList<String>(each);
//						newone.add(str);
//						tem.add(newone);
//					}
//					
//				}
//				arr[i]=origin;
//				if(find)
//					break;
//			}
//			
//		}
//		if(!result.isEmpty())
//			return result;
//		listlist=tem;
//	}
//	
//    return result;
//}