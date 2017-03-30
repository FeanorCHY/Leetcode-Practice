//LinkedList
// public class HitCounter {
//     class Hit{
//         int tp;
//         int count;
//         public Hit(int tp){
//             this.tp=tp;
//             this.count=1;
//         }
//     }
//     LinkedList<Hit> list;
//     int sum;
//     /** Initialize your data structure here. */
//     public HitCounter() {
//         list=new LinkedList<Hit>();
//         this.sum=0;
//     }
    
//     /** Record a hit.
//         @param timestamp - The current timestamp (in seconds granularity). */
//     //O(N)
//     public void hit(int timestamp) {
//         if(list.size()==0||list.getLast().tp!=timestamp)
//             list.addLast(new Hit(timestamp));
//         else
//             list.getLast().count++;
//         sum++;
//         int old=timestamp-300;
//         while(list.getFirst().tp<=old)
//             sum-=list.removeFirst().count;
//     }
//     //O(N)
//     /** Return the number of hits in the past 5 minutes.
//         @param timestamp - The current timestamp (in seconds granularity). */
//     public int getHits(int timestamp) {
//         int old=timestamp-300;
//         while(list.size()>0&&list.getFirst().tp<=old)
//             sum-=list.removeFirst().count;
//         return sum;
//     }
// }


//implement with Array
public class HitCounter {

    int[] times=new int[300];
    int[] count=new int[300];
    /** Initialize your data structure here. */
    public HitCounter() {
    }
    //O(1)
    public void hit(int timestamp) {
        if(times[timestamp%300]==timestamp){
            count[timestamp%300]++;
        }
        else{
            times[timestamp%300]=timestamp;
            count[timestamp%300]=1;
        }
    }
    //O(300)
    public int getHits(int timestamp) {
        int old=timestamp-300;
        int sum=0;
        for(int i=0;i<300;i++){
            if(times[i]>old)
                sum+=count[i];
        }
        return sum;
    }
}




/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */