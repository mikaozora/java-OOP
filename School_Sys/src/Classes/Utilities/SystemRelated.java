package Classes.Utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemRelated {
    public void SystemCls() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public int chooseNumber(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            if (choice < min || choice > max) {
                throw new IllegalArgumentException("No Choice Exists!");
            }

            return choice;
        } catch (InputMismatchException | IllegalArgumentException e) {
            if (e.getMessage() == null) {
                System.out.println(new Template().ANSI_RED + "Invalid Format!" + new Template().ANSI_RESET);
            } else
                System.out.println(new Template().ANSI_RED + e.getMessage() + new Template().ANSI_RESET);

            scanner.nextLine();
            return chooseNumber(min, max);
        }
    }

    public int chooseMenuInput(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.printf("Choose Menu Number? [%d-%d] -> ", min, max);
            int choice = scanner.nextInt();
            if (choice < min || choice > max) {
                throw new IllegalArgumentException("No Choice Exists!");
            }

            return choice;
        } catch (InputMismatchException | IllegalArgumentException e) {
            if (e.getMessage() == null) {
                System.out.println(new Template().ANSI_RED + "Invalid Format!" + new Template().ANSI_RESET);
            } else
                System.out.println(new Template().ANSI_RED + e.getMessage() + new Template().ANSI_RESET);

            scanner.nextLine();
            return chooseMenuInput(min, max);
        }
    }
}
