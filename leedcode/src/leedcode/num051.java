package leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num051 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new LinkedList<List<String>>();
        if(n<=0)
            return res;
        List<String> list=new ArrayList<String>(n);
        char[] arr=new char[n];
        Arrays.fill(arr,'.');
        for(int i=0;i<n;i++){
            list.add(new String(arr));//remember to initiate the list
        }
        traverse(res,list,n,0,new boolean[n],new boolean[n+n],new boolean[n+n]);
        return res;
    }
    private void traverse(List<List<String>> res,List<String> list,int n,int cur,boolean visit[],boolean dia1[],boolean dia2[]){
        if(cur==n){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]&&!dia1[i+cur]&&!dia2[cur+n-1-i]){
                visit[i]=true;
                dia1[i+cur]=true;
                dia2[cur+n-1-i]=true;
                String tem=list.get(cur);
                String str=list.get(cur).substring(0,i)+"Q"+list.get(cur).substring(i+1,n);
                list.set(cur,str);
                traverse(res,list,n,cur+1,visit,dia1,dia2);
                visit[i]=false;
                dia1[i+cur]=false;
                dia2[cur+n-1-i]=false;
                list.set(cur,tem);//make it back
            }
        }
    }
}
