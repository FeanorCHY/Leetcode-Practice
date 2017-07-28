import java.util.HashMap;

public class num391 {

    //tricky concat and area
//     public boolean isRectangleCover(int[][] rects) {
//         if(rects==null||rects.length==0||rects[0].length==0)
//             return false;
//         long area=0;
//         HashSet<String> hs=new HashSet<String>();
//         int x1=Integer.MAX_VALUE,y1=Integer.MAX_VALUE,x2=Integer.MIN_VALUE,y2=Integer.MIN_VALUE;
//         for(int[] rect:rects){
//             area+=(long)((rect[2]-rect[0])*(rect[3]-rect[1]));
//             x1=Math.min(x1,rect[0]);
//             y1=Math.min(y1,rect[1]);
//             x2=Math.max(x2,rect[2]);
//             y2=Math.max(y2,rect[3]);
//             String p1=rect[0]+"_"+rect[1];
//             String p2=rect[0]+"_"+rect[3];
//             String p3=rect[2]+"_"+rect[1];
//             String p4=rect[2]+"_"+rect[3];
//             if(hs.contains(p1))
//                 hs.remove(p1);
//             else
//                 hs.add(p1);
//             if(hs.contains(p2))
//                 hs.remove(p2);
//             else
//                 hs.add(p2);
//             if(hs.contains(p3))
//                 hs.remove(p3);
//             else
//                 hs.add(p3);
//             if(hs.contains(p4))
//                 hs.remove(p4);
//             else
//                 hs.add(p4);
//         }
//         String p1=x1+"_"+y1;
//         String p2=x1+"_"+y2;
//         String p3=x2+"_"+y1;
//         String p4=x2+"_"+y2;
//         if(hs.size()!=4||!hs.contains(p1)||!hs.contains(p2)||!hs.contains(p3)||!hs.contains(p4)||(long)((x2-x1)*(y2-y1))!=area)
//             return false;
//         return true;
        
//     }
        
        
    //check overlap
    public boolean isRectangleCover(int[][] rects) {
        if(rects==null||rects.length==0||rects[0].length==0)
            return false;
        long area=0;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        int x1=Integer.MAX_VALUE,y1=Integer.MAX_VALUE,x2=Integer.MIN_VALUE,y2=Integer.MIN_VALUE;
        for(int[] rect:rects){
            area+=(long)((rect[2]-rect[0])*(rect[3]-rect[1]));
            x1=Math.min(x1,rect[0]);
            y1=Math.min(y1,rect[1]);
            x2=Math.max(x2,rect[2]);
            y2=Math.max(y2,rect[3]);
            String p1=rect[0]+"_"+rect[1];
            String p2=rect[0]+"_"+rect[3];
            String p3=rect[2]+"_"+rect[1];
            String p4=rect[2]+"_"+rect[3];
            if(check(p1,map,1))
                return false;
            if(check(p2,map,2))
                return false;
            if(check(p3,map,4))
                return false;
            if(check(p4,map,8))
                return false;
        }
        int count=0;
        for(int type:map.values()){ 
            if(type==1||type==2||type==4||type==8)
                count++;
        }
        return count==4&&(long)((x2-x1)*(y2-y1))==area;
        
    }
    private boolean check(String p,HashMap<String,Integer> map,int type){
        Integer tem=map.get(p);
        if(tem==null)
            tem=type;
        else if((tem&type)==1)
            return true;
        else
            tem|=type;
        map.put(p,tem);
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
