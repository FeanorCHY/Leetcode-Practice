import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomizedCollection {

    class Rnode{
        int val;
        HashSet<Integer> pos;
        public Rnode(int val){
            this.val=val;
            this.pos=new HashSet<Integer>();
        }
    }
    HashMap<Integer,Rnode> map;
    List<Integer> list;
    Random ran;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map=new HashMap<Integer,Rnode>();
        list=new ArrayList<Integer>();
        ran=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            Rnode node=map.get(val);
            node.pos.add(list.size());
            list.add(val);
            return false;
        }
        else{
            Rnode node=new Rnode(val);
            node.pos.add(list.size());
            map.put(val,node);
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        else{
            Rnode node=map.get(val);
            Rnode last=map.get(list.remove(list.size()-1));
            last.pos.remove(list.size());
            if(last.val!=val){
                // System.out.println()
                int tem=node.pos.iterator().next();
                node.pos.remove(tem);
                last.pos.add(tem);
                list.set(tem,last.val);
            }
            if(node.pos.size()==0)
                map.remove(val);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(ran.nextInt(list.size()));
    }
}
