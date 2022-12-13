package task;

import java.util.Scanner;

public class probE {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int a, b, c;
            a = input.nextInt();
            b = input.nextInt();
            c = input.nextInt();
            if(a == 0){
                for (int j = 0; j < 5; j++) {
                    arr[b][j] += c;
                }
            }else if(a == 1){
                for (int j = 0; j < 5; j++) {
                    arr[j][b] += c;
                }
            }
        }
        int sum = 0;
        int min = arr[0][0];
        int max = arr[0][0];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sum += arr[i][j];
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        System.out.println(sum + " " + min + " "+ max);
    }
}
