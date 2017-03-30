import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//public class Twitter {
//
//    public Twitter() {
//    	LinkedList<Integer> list=new LinkedList<Integer>();
//    	Iterator it=list.descendingIterator();
//    	Map<Integer, LinkedList<Integer>> t = new HashMap<>();
//    	t.get(1).stream().forEach(f -> tweets.get(f).forEach(feed::add));
//    	
//    }
//}

//public class Twitter {
//    Map<Integer, Set<Integer>> fans = new HashMap<>();
//    Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();
//    int cnt = 0;
//
//    public void postTweet(int userId, int tweetId) {
//        if (!fans.containsKey(userId)) fans.put(userId, new HashSet<>());
//        fans.get(userId).add(userId);
//        if (!tweets.containsKey(userId)) tweets.put(userId, new LinkedList<>());
//        tweets.get(userId).addFirst(new Tweet(cnt++, tweetId));
//    }
//
//    public List<Integer> getNewsFeed(int userId) {
//        if (!fans.containsKey(userId)) return new LinkedList<>();
//        PriorityQueue<Tweet> feed = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
//        fans.get(userId).stream()
//            .filter(f -> tweets.containsKey(f))
//            .forEach(f -> tweets.get(f).forEach(feed::add));
//        List<Integer> res = new LinkedList<>();
//        while (feed.size() > 0 && res.size() < 10) res.add(feed.poll().id);
//        return res;
//    }
//
//    public void follow(int followerId, int followeeId) {
//        if (!fans.containsKey(followerId)) fans.put(followerId, new HashSet<>());
//        fans.get(followerId).add(followeeId);
//    }
//
//    public void unfollow(int followerId, int followeeId) {
//        if (fans.containsKey(followerId) && followeeId != followerId) fans.get(followerId).remove(followeeId);
//    }
//
//    class Tweet {
//        int time;
//        int id;
//
//        Tweet(int time, int id) {
//            this.time = time;
//            this.id = id;
//        }
//    }
//}


//does the twitter id follows the chrononical order? does twitter id have duplicates? i.e. 1 post 2, 2 post 2?
public class Twitter {
  
  class Feed{
      News news;
      Iterator<News> it;
      public Feed(Iterator<News> it){
          this.it=it;
          this.news=it.next();
      }
  }
  class News{
      int tid;
      int time;
      public News(int tid){
          this.tid=tid;
          this.time=len++;//We should calculate time order by ourselves
      }
  }
  int len=0;
  HashMap<Integer,LinkedList<News>> post;
  HashMap<Integer,HashSet<Integer>> follow;
  //O(1)
  /** Initialize your data structure here. */
  public Twitter() {
      post=new HashMap<Integer,LinkedList<News>>();
      follow=new HashMap<Integer,HashSet<Integer>>();
  }
  
  //O(1)
  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
      if(!post.containsKey(userId))
          post.put(userId,new LinkedList<News>());
      post.get(userId).add(new News(tweetId));
  }
  
  ////O(K+KlogK) K: number of people he follows
  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
      PriorityQueue<Feed> pq=new PriorityQueue<Feed>(new Comparator<Feed>(){
          @Override
          public int compare(Feed f1,Feed f2){
              return f2.news.time-f1.news.time;
          }
      });
      if(!follow.containsKey(userId)){
          follow.put(userId,new HashSet<Integer>());
          follow.get(userId).add(userId);
      }
       for(int followee:follow.get(userId)){
           if(!post.containsKey(followee))
               continue;
           Iterator<News> it=post.get(followee).descendingIterator();
           if(it.hasNext())
               pq.add(new Feed(it));
       }
      List<Integer> res=new ArrayList<Integer>(10);
      for(int i=0;i<10&&!pq.isEmpty();i++){
          Feed fd=pq.poll();
          res.add(fd.news.tid);
          if(fd.it.hasNext()){
              fd.news=fd.it.next();
              pq.add(fd);
          }
      }
      return res;
  }
  //O(1)
  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
      if(!follow.containsKey(followerId)){
          follow.put(followerId,new HashSet<Integer>());
          follow.get(followerId).add(followerId);
      }
      follow.get(followerId).add(followeeId);
  }
  //O(1)
  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
      if(followerId==followeeId)
          return;
      if(follow.containsKey(followerId)){
          follow.get(followerId).remove(followeeId);
      }
  }
}