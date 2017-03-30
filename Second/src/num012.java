
public class num012 {

    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        String one[]={"M","C","X","I"};
        String five[]={"","D","L","V"};
        int mask=1000;
        int index=0;
        while(num!=0){
            int cur=num/mask;
            num=num%mask;
            mask=mask/10;
            if(cur==0){
                index++;
                continue;
            }
            if(cur==9){
                sb.append(one[index]);
                sb.append(one[index-1]);
            }
            else if(cur>=5){
                sb.append(five[index]);
                for(int i=5;i<cur;i++)
                    sb.append(one[index]);
            }
            else if(cur==4)
                sb.append(one[index]+five[index]);
            else if(cur>0){
                for(int i=0;i<cur;i++)
                    sb.append(one[index]);
            }
            index++;
        }
        
        return sb.toString();
    }
}
