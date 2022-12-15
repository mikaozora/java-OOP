package task;

import java.util.Scanner;

public class probD {

    static void sort(double[] arr){
        int length = arr.length;
        double temp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length-i; j++) {
                if(arr[j-1] < arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextDouble();
        }
        sort(arr);
        int num = 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(i > 0){
                if(arr[i] == arr[i-1]){
                    count++;
                    System.out.print(num-count + " ");
                }else{
                    System.out.print(num + " ");
                    count = 0;
                }
                System.out.printf("%.2f\n", arr[i]);
            }else{
                System.out.printf("%d %.2f\n", num, arr[i]);
            }
            num++;
        }
    }
}