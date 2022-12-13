package Week1;

import java.util.Scanner;

public class Main {

    public static void test(int a, double b) {
        System.out.println("helloo everybody " + (a / b));
    }

    static double luas(int r, double phi) {
        return phi * Math.pow(r, 2);
    }

    public static void main(String[] args) {
        final double phi = 3.14;
        System.out.println("Hello world");
        test(5, 10);
        Scanner input = new Scanner(System.in);

        // luas lingkaran
        int c;
        System.out.print("Input jari jari: ");
        c = input.nextInt();
        double luasLingkaran = luas(c, phi);

        // nama
        input.nextLine(); // wajib setelah integer jika ingin input String
        String nama = input.nextLine();
        System.out.println("nama " + nama);

        System.out.printf("luas lingkaran (with format): %.3f\n", luasLingkaran);
        System.out.println("luas lingkaran : " + luasLingkaran);
        for (int i = 0; i < c; i++) {
            if (luasLingkaran < 100) {
                System.out.println("Lingkarannya kecil");
            } else {
                System.out.println("Lingkarannya besar");
            }
        }

    }
}
