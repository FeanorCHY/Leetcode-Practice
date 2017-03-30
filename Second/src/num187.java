import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new ArrayList<String>();
        if(s==null||s.length()<11)
            return res;
        char[] arr=s.toCharArray();
        HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
        char[] nuc = new char['T' - 'A'+1];
        nuc['C' - 'A'] = 1;
        nuc['G' - 'A'] = 2;
        nuc['T' - 'A'] = 3;
        int val=0;
        int mask=0;
        for(int i=0;i<10;i++){
            val=val<<2;
            mask=mask<<2;
            mask=mask|3;
            val+=nuc[arr[i]-'A'];
        }
        map.put(val,false);
        // System.out.println(arr.length);
        for(int i=10;i<arr.length;i++){
            // System.out.println(arr.length);
            val=val<<2;
            val+=nuc[arr[i]-'A'];
            val=val&mask;
            if(map.containsKey(val)&&!map.get(val)){
                res.add(s.substring(i-9,i+1));
                map.put(val,true);
            }
            else if(!map.containsKey(val)){
                map.put(val,false);
            }
        }
        return res;
    }
    
    
    
    
    //can the duplicate sequence be overlapped? what if not ACGT
    // public List<String> findRepeatedDnaSequences(String s) {
    //     List<String> res=new ArrayList<String>();
    //     if(s==null||s.length()<11)
    //         return res;
    //     char[] arr=s.toCharArray();
    //     HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
    //     HashMap<Character,Integer> nuc=new HashMap<Character,Integer>();
    //     nuc.put('A',0);
    //     nuc.put('G',1);
    //     nuc.put('C',2);
    //     nuc.put('T',3);
    //     int val=0;
    //     int mask=0;
    //     for(int i=0;i<10;i++){
    //         val=val<<2;
    //         mask=mask<<2;
    //         mask=mask|3;
    //         val+=nuc.get(arr[i]);
    //     }
    //     map.put(val,false);
    //     // System.out.println(arr.length);
    //     for(int i=10;i<arr.length;i++){
    //         // System.out.println(arr.length);
    //         val=val<<2;
    //         val+=nuc.get(arr[i]);
    //         val=val&mask;
    //         if(map.containsKey(val)&&!map.get(val)){
    //             res.add(s.substring(i-9,i+1));
    //             map.put(val,true);
    //         }
    //         else if(!map.containsKey(val)){
    //             map.put(val,false);
    //         }
    //     }
    //     return res;
    // }
    //"AAAAAAAAAAA"
    //"AAAAAAAAAA"
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
