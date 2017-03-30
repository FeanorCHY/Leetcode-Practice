import java.util.HashMap;
import java.util.Random;

//hashmap + arraylist
// public class RandomizedSet {
//     class Rnode{
//         int val;
//         int pos;
//         public Rnode(int val,int pos){
//             this.val=val;
//             this.pos=pos;
//         }
//     }
//     HashMap<Integer,Rnode> map;
//     List<Rnode> list;
//     Random ran;
//     /** Initialize your data structure here. */
//     public RandomizedSet() {
//         map=new HashMap<Integer,Rnode>();
//         list=new ArrayList<Rnode>();
//         ran=new Random();
//     }
    
//     /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//     public boolean insert(int val) {
//         if(map.containsKey(val))
//             return false;
//         else{
//             Rnode node=new Rnode(val,map.size());
//             map.put(val,node);
//             list.add(node);
//             return true;
//         }
//     }
    
//     /** Removes a value from the set. Returns true if the set contained the specified element. */
//     public boolean remove(int val) {
//         if(!map.containsKey(val))
//             return false;
//         else{
//             Rnode node=map.get(val);
//             Rnode last=list.remove(list.size()-1);
//             if(node.pos!=list.size()){
//                 last.pos=node.pos;
//                 list.set(node.pos,last);
//             }
//             map.remove(val);
//             return true;
//         }
//     }
    
//     /** Get a random element from the set. */
//     public int getRandom() {
//         return list.get(ran.nextInt(list.size())).val;
//     }
// }






public class RandomizedSet {
    class Rnode{
        int val;
        int pos;
        public Rnode(int val,int pos){
            this.val=val;
            this.pos=pos;
        }
    }
    HashMap<Integer,Rnode> kmap;
    HashMap<Integer,Rnode> vmap;
    Random ran;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        kmap=new HashMap<Integer,Rnode>();
        vmap=new HashMap<Integer,Rnode>();
        ran=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(vmap.containsKey(val))
            return false;
        else{
            Rnode node=new Rnode(val,vmap.size());
            vmap.put(val,node);
            kmap.put(kmap.size(),node);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!vmap.containsKey(val))
            return false;
        else{
            Rnode node=vmap.get(val);
            Rnode last=kmap.remove(kmap.size()-1);
            if(node.pos!=kmap.size()){
                last.pos=node.pos;
                kmap.put(node.pos,last);
            }
            vmap.remove(val);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return kmap.get(ran.nextInt(kmap.size())).val;
    }
}