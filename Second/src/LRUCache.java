import java.util.HashMap;

//Double linked List + HashMap
public class LRUCache {
    class LRUNode{
        LRUNode pre;
        LRUNode next;
        int val;
        int key;
        public LRUNode(int val,int key){
            this.val=val;
            this.key=key;
        }
    }
    LRUNode head,tail;
    int len;
    HashMap<Integer,LRUNode> map;
    public LRUCache(int capacity) {
        head=new LRUNode(0,0);
        tail=new LRUNode(0,0);
        head.next=tail;
        tail.pre=head;
        len=capacity;
        map=new HashMap<Integer,LRUNode>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        LRUNode node=map.get(key);
        delete(node);
        insertH(node);
        return node.val;
    }
    private void insertH(LRUNode node){
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
        node.pre=head;
    }
    private void delete(LRUNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            LRUNode node=new LRUNode(value,key);
            map.put(key,node);
            if(map.size()>len){
                map.remove(tail.pre.key);//remember to remove in the HashMap
                delete(tail.pre);
            }
            insertH(node);
        }
        else{
            LRUNode node=map.get(key);
            delete(node);
            insertH(node);
            node.val=value;
        } 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */