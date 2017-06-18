
public class num065 {

    //leading zero?
    public boolean isNumber(String s) {
        if(s==null||s.length()==0)
            return false;
        char[] arr=s.toCharArray();
        boolean point=false,e=false,sign=false,start=false,space=false;//,zero=false
        for(char c:arr){
            if(c==' '){
                if(start||point||sign||e)
                    space=true;
                continue;
            }
            if(space)
                return false;
            if(c=='+'||c=='-'){
                if(sign||point||start)
                    return false;
                sign=true;
            }
            else if(c>='0'&&c<='9'){
                // if(c=='0'&&!start){
                //     if(e)
                //         return false;
                //     zero=true;
                // }
                start=true;
            }
            else if(c=='.'){
                // zero=false;
                if(point||e)
                    return false;
                point=true;
                // start=true;
            }
            else if(c=='e'){
                if(e||!start)
                    return false;
                e=true;
                point=false;
                sign=false;
                start=false;
            }
            else
                return false;
        }
        if(!start)//(point&&!start)||
            return false;
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
