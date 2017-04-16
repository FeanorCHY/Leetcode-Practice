import java.util.HashMap;

public class LFUCache {
    class LFUNode{
        int fre=0;
        int val;
        int key;
        LFUNode next;
        LFUNode pre;
        public LFUNode(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    HashMap<Integer,LFUNode> map=new HashMap<Integer,LFUNode>();
    HashMap<Integer,LFUNode> Fmap=new HashMap<Integer,LFUNode>();
    int capacity;
    LFUNode head,tail;
    public LFUCache(int capacity) {
        head=new LFUNode(0,0);
        tail=new LFUNode(0,0);
        head.fre=-1;
        tail.fre=1;
        head.next=tail;//do not forget to initiate the two pointers
        tail.pre=head;
        Fmap.put(1,tail);
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        LFUNode node=map.get(key);
        moveHead(node);
        print();
        return node.val;
    }
    private void print(){
        LFUNode node=head.next;
        while(node!=null){
            System.out.print(node.key+"-->");
            node=node.next;
        }
        System.out.println();
    }
    
    public void put(int key, int value) {
        if(capacity<=0)//take care of zero capacity
            return;
        if(!map.containsKey(key)){
            LFUNode node=new LFUNode(key,value);
            map.put(node.key,node);
            if(map.size()>capacity){
                LFUNode last=tail.pre;
                Remove(last);
                map.remove(last.key);
            }
        }
        LFUNode node=map.get(key);
        node.val=value;
        moveHead(node);
        print();
        
    }
    private void moveHead(LFUNode node){
        node.fre++;
        if(Fmap.containsKey(node.fre)){
            if(node.fre>1){
            	node.fre--;
                Remove(node);
                node.fre++;
            }
            insertBefore(node,Fmap.get(node.fre));
        }
        else if(Fmap.get(node.fre-1)!=node){
            if(node.fre>1){
            	node.fre--;
                Remove(node);
                node.fre++;
            }
            insertBefore(node,Fmap.get(node.fre-1));
        }
        else{//if node is head of its frequency, do not move but transfer the head
            if(node.next.fre==node.fre-1){
                Fmap.put(node.fre-1,node.next);
            }
            else
                Fmap.remove(node.fre);
        }
        Fmap.put(node.fre,node);
    }
    private void insertBefore(LFUNode node,LFUNode next){
        node.next=next;
        node.pre=next.pre;
        next.pre.next=node;
        next.pre=node;
    }
    private void Remove(LFUNode node){
        if(Fmap.get(node.fre)==node&&node.next.fre==node.fre){
            Fmap.put(node.fre,node.next);
        }
        if(Fmap.get(node.fre)==node)
            Fmap.remove(node.fre);
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */