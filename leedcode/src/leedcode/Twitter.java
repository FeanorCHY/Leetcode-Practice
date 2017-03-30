package leedcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Twitter {

	HashMap<Integer,Set<Integer>> follow=new HashMap<Integer,Set<Integer>>();
	HashMap<Integer,List<Integer>> post=new HashMap<Integer,List<Integer>>();
	List<Integer> tweetTime=new ArrayList<Integer>();
//	List<Integer> tidArr=new ArrayList<Integer>();
	int tid=0;
    /** Initialize your data structure here. */
    public Twitter() {
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	tweetTime.add(tweetId);
    	if(post.containsKey(userId)){
    		post.get(userId).add(tid++);
    	}
    	else{
    		List<Integer> tem=new ArrayList<Integer>();
    		tem.add(tid++);
    		post.put(userId, tem);
    	}
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	Set<Integer> follower=new HashSet<Integer>();//avoid follow it self which cause duplicate itsef
    	if(follow.containsKey(userId))
    		follower.addAll(follow.get(userId));
    	follower.add(userId);//avoid not follow before
    	List<Integer> feed=new ArrayList<Integer>();
    	for(int each:follower){
    		if(post.containsKey(each))
    			feed.addAll(post.get(each));
    	}
    	Collections.sort(feed);
    	List<Integer> result=new ArrayList<Integer>();
    	for(int i=0;i<Math.min(10, feed.size());i++){
    		result.add(tweetTime.get(feed.get(feed.size()-1-i)));
    	}
    	
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

    	if(follow.containsKey(followerId)){
    		follow.get(followerId).add(followeeId);
    	}
    	else{
    		Set<Integer> tem=new HashSet<Integer>();
    		tem.add(followerId);
    		tem.add(followeeId);
    		follow.put(followerId, tem);
    	}
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

    	if(follow.containsKey(followerId)){
    		follow.get(followerId).remove(new Integer(followeeId));
    	}
    }
}
