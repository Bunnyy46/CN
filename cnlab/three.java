package cnlab;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter total number of frames:");
        int total=sc.nextInt();
        System.out.println("Enter Window size");
        int N=sc.nextInt();
       
        int sent=0;
        while(sent<total){
            System.out.println("\nThe frames sent "+sent+" to "+Math.min(sent+N-1,total-1));
            System.out.println("Entre the lost frame if not -1:");
            int lost=sc.nextInt();

            if(lost>=sent && lost<sent+N){
                System.out.println("frame "+lost+" is lost resend....");
                sent=lost;
            }else{
                System.out.println("frame is succefully acknowldged");
                sent+=N;
            }
        }
        System.out.println("\nAll frames are sucesfully acknoeldged");
    }
}



