package task;

import java.util.Scanner;

public class Sl2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int r = input.nextInt();
        int mod = r % n;
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        for (int i = 0; i < mod; i++) {
            int temp = arr[arr.length-1];
            for (int j = arr.length-1; j > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[0] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
