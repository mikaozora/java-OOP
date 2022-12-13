package task;

import java.util.Scanner;

public class probA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        char[] kata = a.toCharArray();
        String rev = "";
        for(int i = a.length()-1; i >= 0; i--){
            rev += kata[i];
        }
        if(a.equals(rev)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
