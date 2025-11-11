package cnlab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter message:");
        String msg=sc.nextLine();
        System.err.println("The charcter count is:"+msg.length()+msg);

        System.out.println("Enter your message:");
        String stuffing=sc.nextLine();
        String flag ="F",esc="E";
        String d="F"+stuffing.replace(esc,esc+esc).replace(flag,esc+flag)+"F";
        System.out.println("The stuffed bit id "+d);

        System.out.println("Enter the bits to stuff");
        String bit=sc.nextLine();
        StringBuilder st=new StringBuilder();
        int count=0;
        for(int i=0;i<bit.length();i++){
            st.append(bit.charAt(i));
            count=(bit.charAt(i)=='1')?count+1:0;
            if(count==5){
                st.append('0');
                count=0;
            }
        }
        System.out.println("The stuffedbit is:"+st);
    }
}



