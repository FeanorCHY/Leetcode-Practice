import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;

public class num282 {

    //stupid way but works O(?)
    // class AONode{
    //     String str;
    //     long last;
    //     long val;
    //     public AONode(char c){
    //         this.str=c+"";
    //         last=c-'0';
    //         val=c-'0';
    //     }
    //     public AONode(String str,long last,long val){
    //         this.str=str;
    //         this.last=last;
    //         this.val=val;
    //     }
    //     public String toString(){
    //     	return str;
    //     }
    // }
    // // HashMap<Integer,List<String>> map[][];
    // boolean start=false;
    // public List<String> addOperators(String num, int target) {
    //     return addOperators2(num,target);
    // }
    // public List<String> addOperators2(String num, long target) {
    //     List<String> res=new LinkedList<String>();
    //     if(num==null||num.length()==0){
    //         return res;
    //     }
    //     boolean tem=start;
    //     start=true;
    //     char[] arr=num.toCharArray();
    //     List<AONode> list=new LinkedList<AONode>();
    //     for(int i=0;i<arr.length;i++){
    //         list=search(i,list,arr);
    //         for(AONode node:list){
    //         	if(node.str.equals("1*2*34"))
    //         		System.out.println();
    //         	if(i==arr.length-1&&node.val==target){
    //         		res.add(node.str);
    //         	}
    //         	if(i==arr.length-1&&node.val==-target&&tem){
    //         		res.add("-"+node.str);
    //         	}
    //             List<String> next=addOperators2(num.substring(i+1),target-node.val);
    //             if(next.size()>0){
    //                 for(String s:next){
    //                     if(s.charAt(0)=='-')
    //                         res.add(node.str+s);
    //                     else
    //                         res.add(node.str+"+"+s);
    //                 }
    //             }
    //             if(tem){
    //                 next=addOperators2(num.substring(i+1),target+node.val);
    //                 if(next.size()>0){
    //                     for(String s:next){
    //                         if(s.charAt(0)=='-')
    //                             res.add("-"+node.str+s);
    //                         else
    //                             res.add("-"+node.str+"+"+s);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }
    // private List<AONode> search(int idx,List<AONode> list,char[] arr){
    //     if(list.size()==0){
    //         list.add(new AONode(arr[0]));
    //         return list;
    //     }
    //     else{
    //         List<AONode> ret=new LinkedList<AONode>();
    //         long num=arr[idx]-'0';
    //         for(AONode node:list){
    //             ret.add(new AONode(node.str+"*"+num,num,node.val*num));
    //         }
    //         for(AONode node:list){
    //             if(node.last==0)
    //                 continue;
    //             ret.add(new AONode(node.str+num,node.last*10+num,(node.val/node.last)*(node.last*10+num)));
    //         }
    //         return ret;
    //     }
    // }
    
    
    
    //more beautiful code
    public List<String> addOperators(String num, int target) {
        List<String> res=new LinkedList<String>();
        if(num==null||num.length()==0){
            return res;
        }
        search(0,res,num.toCharArray(),0,0,target,new char[num.length()*2+1],0);
        return res;
    }
    private void search(int idx,List<String> res,char[] arr,long last,long pre,long target,char[] cur,int len){
        if(idx==arr.length){
            if(pre==target){
                res.add(new String(cur,0,len));
            }
        }
        else{
            long num=0;
            int j=len;
            if(idx>0)
                j++;
            for(int i=idx;i<arr.length;i++){
                num=num*10+arr[i]-'0';
                cur[j++]=arr[i];
                if(idx==0){
                    search(i+1,res,arr,num,pre+num,target,cur,j);
                }
                else{
                    cur[len]='+';
                    search(i+1,res,arr,num,pre+num,target,cur,j);
                    cur[len]='-';
                    search(i+1,res,arr,-num,pre-num,target,cur,j);
                    cur[len]='*';
                    search(i+1,res,arr,num*last,pre-last+last*num,target,cur,j);
                }
                if(arr[idx]=='0')
                    break;
            }
        }
    }
	public static void main(String[] args) {
		num282 sol=new num282();
		List<String> str1=sol.addOperators("2147483648", -2147483648);
		System.out.println(str1);
//		HashSet<String> h1=new HashSet<String>(str1);
//		HashSet<String> h2=new HashSet<String>();
////		String str1[]={"1+2+3+4+5+6+7+8+9","1+2+3+4+5-6*7+8*9","1+2+3+4-5*6-7+8*9","1+2+3+4-5*6+7*8+9","1+2+3-4*5-6-7+8*9","1+2+3-4*5-6+7*8+9","1+2+3-4*5+6*7+8+9","1+2+3-45+67+8+9","1+2-3-4-5*6+7+8*9","1+2-3+4*5+6*7-8-9","1+2-3+45+6-7-8+9","1+2-3+45-6+7+8-9","1+2-3-45-6+7+89","1+2+3*4+5+6*7-8-9","1+2-3*4-5-6-7+8*9","1+2-3*4-5-6+7*8+9","1+2-3*4-5+6*7+8+9","1+2-3*4+5*6+7+8+9","1+2-34+5+6-7+8*9","1+2-34+5+6+7*8+9","1+2-34-5-6+78+9","1+2+3*4*5+6-7-8-9","1+2-3*4*5+6+7+89","1+2+3*4*56-78+9","1-2+3+4-5*6+78-9","1-2+3-4*5-6+78-9","1-2+3+45+6-7+8-9","1-2+3-45+6-7+89","1-2-3+4-5+67-8-9","1-2-3+45-6-7+8+9","1-2-3*4+5+6+7*8-9","1-2-3*4-5-6+78-9","1-2-34+5+6+78-9","1-2-34-5+6+7+8*9","1-2-34+56+7+8+9","1-2+3*4*5-6-7+8-9","1-2+3*4*56+7-8*9","1-2+3*4*56-7*8-9","1+2*3-4-5-6*7+89","1+2*3+4*5-6+7+8+9","1+2*3+4*5*6+7-89","1-2*3+4+5-6+7*8-9","1-2*3+4+5+6*7+8-9","1-2*3+4+56+7-8-9","1-2*3-4-5-6-7+8*9","1-2*3-4-5-6+7*8+9","1-2*3-4-5+6*7+8+9","1-2*3-4+5*6+7+8+9","1-2*3+4*5+6+7+8+9","1-2*3+4*5-6*7+8*9","1-2*3+45-67+8*9","1+23+4+5+6+7+8-9","1+23+4-5-67+89","1+23+4-5*6+7*8-9","1+23-4-5+6+7+8+9","1+23-4-5-6*7+8*9","1+23-4*5-6+7*8-9","1+23-4*5+6*7+8-9","1+23-45+67+8-9","1-23+4-5+67-8+9","1-23-4+5+67+8-9","1-23-4-5-6-7+89","1-23+4*5-6*7+89","1-23+45-67+89","1+2*3*4-5+6*7-8-9","1+2*3*4+5*6+7-8-9","1-2*3*4+5-6+78-9","1-2*3*4-5-6+7+8*9","1+23*4+5-6-7*8+9","1+23*4-5-6*7+8-9","1+23*4-56+7-8+9","1-23*4+5-6+7*89","1-23*4+5+6*7+89","1+2*34+5-6+7-8+9","1+2*34-5+6+7+8-9","1-2*34+5-6-7+89","1-2*34-56+7*89","1+2*3*4*5+6+7-89","1*2+3+4-5-6+7*8-9","1*2+3+4-5+6*7+8-9","1*2+3+4+5*6+7+8-9","1*2+3+45+67-8*9","1*2+3-45+6+7+8*9","1*2-3+4-5-6*7+89","1*2-3-4+56-7-8+9","1*2-3-4*5+67+8-9","1*2+3*4-56+78+9","1*2-3*4+5+67-8-9","1*2+34+5-6-7+8+9","1*2+34-5+6+7-8+9","1*2+34+56-7*8+9","1*2+34-56-7+8*9","1*2+34-56+7*8+9","1*2-34+5*6+7*8-9","12+3+4-56-7+89","12+3-4*5+67-8-9","12+3-45+6+78-9","12-3+4+56-7-8-9","12-3-4+5*6-7+8+9","12-3-4-56+7+89","12-3+4*5+6-7+8+9","12-3-45-6+78+9","12+3*4+5+6-7+8+9","12-3*4-5+67-8-9","12+34-5-6-7+8+9","12-3*4*5+6+78+9","1*2*3+4+5+6+7+8+9","1*2*3+4+5-6*7+8*9","1*2*3+4-5*6-7+8*9","1*2*3+4-5*6+7*8+9","1*2*3-4*5-6-7+8*9","1*2*3-4*5-6+7*8+9","1*2*3-4*5+6*7+8+9","1*2*3-45+67+8+9","12*3+4+5+6-7-8+9","12*3+4+5-6+7+8-9","12*3-4-5-6+7+8+9","12*3-4-56+78-9","1*23-4-56-7+89","1*23+4*5-6+7-8+9","123-4-5*67+8+9","1*2*3*4+5+6-7+8+9","12*3*4+5-6*78+9","12*3*4-5*6-78+9","12*34-5*6+7-8+9","1*2*3*4*5-6-78+9","1*23*45-6+7-89"};
//		String str2[]={"1*2*3*4*5-6-78+9","1*2*3*4+5+6-7+8+9","1*2*3+4+5+6+7+8+9","1*2*3+4+5-6*7+8*9","1*2*3+4-5*6+7*8+9","1*2*3+4-5*6-7+8*9","1*2*3-4*5+6*7+8+9","1*2*3-4*5-6+7*8+9","1*2*3-4*5-6-7+8*9","1*2*3-45+67+8+9","1*2*34+56-7-8*9","1*2*34-5+6-7-8-9","1*2+3*4-56+78+9","1*2+3+4+5*6+7+8-9","1*2+3+4-5+6*7+8-9","1*2+3+4-5-6+7*8-9","1*2+3+45+67-8*9","1*2+3-45+6+7+8*9","1*2+34+5-6-7+8+9","1*2+34+56-7*8+9","1*2+34-5+6+7-8+9","1*2+34-56+7*8+9","1*2+34-56-7+8*9","1*2-3*4+5+67-8-9","1*2-3+4-5-6*7+89","1*2-3-4*5+67+8-9","1*2-3-4+56-7-8+9","1*2-34+5*6+7*8-9","1*23+4*5-6+7-8+9","1*23-4-56-7+89","1+2*3*4*5+6+7-89","1+2*3*4+5*6+7-8-9","1+2*3*4-5+6*7-8-9","1+2*3+4*5*6+7-89","1+2*3+4*5-6+7+8+9","1+2*3-4-5-6*7+89","1+2*34-5*6+7+8-9","1+2+3*4*5+6-7-8-9","1+2+3*4+5+6*7-8-9","1+2+3*45-6-78-9","1+2+3+4+5+6+7+8+9","1+2+3+4+5-6*7+8*9","1+2+3+4-5*6+7*8+9","1+2+3+4-5*6-7+8*9","1+2+3-4*5+6*7+8+9","1+2+3-4*5-6+7*8+9","1+2+3-4*5-6-7+8*9","1+2+3-45+67+8+9","1+2-3*4*5+6+7+89","1+2-3*4+5*6+7+8+9","1+2-3*4-5+6*7+8+9","1+2-3*4-5-6+7*8+9","1+2-3*4-5-6-7+8*9","1+2-3+4*5+6*7-8-9","1+2-3+45+6-7-8+9","1+2-3+45-6+7+8-9","1+2-3-4-5*6+7+8*9","1+2-3-45-6+7+89","1+2-34+5+6+7*8+9","1+2-34+5+6-7+8*9","1+2-34-5-6+78+9","1+23*4+5-6-7*8+9","1+23*4-5-6*7+8-9","1+23*4-56+7-8+9","1+23+4+5+6+7+8-9","1+23+4-5*6+7*8-9","1+23+4-5-67+89","1+23-4*5+6*7+8-9","1+23-4*5-6+7*8-9","1+23-4-5+6+7+8+9","1+23-4-5-6*7+8*9","1+23-45+67+8-9","1-2*3*4+5-6+78-9","1-2*3*4-5-6+7+8*9","1-2*3+4*5+6+7+8+9","1-2*3+4*5-6*7+8*9","1-2*3+4+5+6*7+8-9","1-2*3+4+5-6+7*8-9","1-2*3+4+56+7-8-9","1-2*3+45-67+8*9","1-2*3-4+5*6+7+8+9","1-2*3-4-5+6*7+8+9","1-2*3-4-5-6+7*8+9","1-2*3-4-5-6-7+8*9","1-2*34+5*6-7+89","1-2+3*4*5-6-7+8-9","1-2+3+4-5*6+78-9","1-2+3+45+6-7+8-9","1-2+3-4*5-6+78-9","1-2+3-45+6-7+89","1-2-3*4+5+6+7*8-9","1-2-3*4-5-6+78-9","1-2-3+4-5+67-8-9","1-2-3+45-6-7+8+9","1-2-34+5+6+78-9","1-2-34+56+7+8+9","1-2-34-5+6+7+8*9","1-23*4+5+6*7+89","1-23+4*5-6*7+89","1-23+4-5+67-8+9","1-23+45-67+89","1-23-4+5+67+8-9","1-23-4-5-6-7+89","12*3*4-5*6-78+9","12*3+4+5+6-7-8+9","12*3+4+5-6+7+8-9","12*3-4-5-6+7+8+9","12*3-4-56+78-9","12+3*4+5+6-7+8+9","12+3*45-6-7-89","12+3+4-56-7+89","12+3-4*5+67-8-9","12+3-45+6+78-9","12+34-5-6-7+8+9","12-3*4*5+6+78+9","12-3*4-5+67-8-9","12-3+4*5+6-7+8+9","12-3+4+56-7-8-9","12-3-4+5*6-7+8+9","12-3-4-56+7+89","12-3-45-6+78+9"};
//		for(String str:str1)
//			h1.add(str);
//		for(String str:str2)
//			h2.add(str);
//		for(String str:str2){
//			if(!h1.contains(str)){
//				System.out.println(str);
//			}
//		}
//		h1.removeAll(h2);
	}

}