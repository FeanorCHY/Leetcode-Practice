package leedcode;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class num166 {
    public String fractionToDecimal(int numerator, int denominator) {
    	long n=numerator;
    	long d=denominator;
    	StringBuffer a = new StringBuffer();  
    	if(n==0)
    		return "0";
    	if(d==0)
    		return "";
    	String minus="";
    	if(n<0){
    		n=-n;
    		minus="-";
    	}
    	if(d<0){
    		d=-d;
    		if(minus.equals("-"))
    			minus="";
    		else
    			minus="-";
    	}
    	String result=minus+Long.toString(n/d);
    	numerator=numerator%denominator;
    	if(numerator==0){
    		return result;
    	}
    	else
    		result=result+".";
    	a.append(result);

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();  
        //System.out.println(map.get(0)); //打印可看出 integer位置上未初始化时存的是null
        long i=0;
        for(i=n%d;i>0;i=i%d){
        	if(map.get(i)!=null)break;
        	map.put(i, a.length());
        	i=i*10;
        	a.append(i/d);
        }
        String r="";
        if(i!=0)
        	r=a.substring(0, map.get(i))+"("+a.substring(map.get(i))+")";
        else
        	r=a.toString();
    	return r;
    	
    	
    }
	public static void main(String[] args) {
		num166 sol=new num166();
		System.out.println(sol.fractionToDecimal(1, 8));
	}

}





//int pos=0;
//String finit="";
////HashMap<Integer,int[]> infinit=new HashMap<Integer,int[]>();
//List<Integer> infinit=new ArrayList<Integer>();
//String infi="";
//long div=9;
//infinit.add(numerator);
//while(!clear){
//	long temdiv=div;
//	for(int i=0;i<infinit.size();i++){
//		if((infinit.get(i)*temdiv)%denominator==0){
//			String zero="";
//			String test=Long.toString(((long)infinit.get(i)*temdiv)/(long)denominator);
//			int in=Long.toString(temdiv).length()-Long.toString(((long)infinit.get(i)*temdiv)/(long)denominator).length();
//			while(in!=0){
//				zero=zero+"0";
//				in--;
//			}
//			infi=(infinit.get(i)*temdiv)/denominator+"";
//			result=result+finit.substring(0,i)+"("+zero+infi+")";
//			clear=true;
//			return result;
//		}
//		temdiv=temdiv/10;
//	}
//	
//	
//	pos=numerator*10/denominator;
//	finit=finit+pos;
//	numerator=numerator*10%denominator;
//	if(numerator==0)
//		return result+finit;
//	else
//		infinit.add(numerator);
//	div=div*10+9;
//	
//}
//
//return result;