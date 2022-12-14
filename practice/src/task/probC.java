package task;

import java.util.Scanner;

public class probC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        char separator = str.charAt(2);
        String[] temp = new String[10];
        if(separator == ':'){
            temp = str.split(":");
        }else if(separator == '.'){
            temp = str.split("\\.");
        }
        double hours, minutes;
        hours = Double.parseDouble(temp[0]);
        minutes = Double.parseDouble(temp[1]);
        double degM = minutes / 60 * 360;
        double degH = (hours / 12 * 360) + (minutes / 60 * 360 / 12);
        double a = Math.abs(360-(degH - degM));
        double b = Math.abs(360 - a);
        System.out.println(Math.min(a,b));
    }
}
