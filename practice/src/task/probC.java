package task;

import java.util.Scanner;

public class probC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String[] temp = str.split(":");
        double hours, minutes;
        hours = Double.parseDouble(temp[0]);
        minutes = Double.parseDouble(temp[1]);
        System.out.println("hours: " + hours + ", minutes: " + minutes);
        double degM = minutes / 60 * 360;
        double degH = (hours / 12 * 360) + (minutes / 60 * 360 / 12);
        double a = Math.abs(degH - degM);
        double b = 360 - a;
        System.out.println(Math.min(a,b));
    }
}
