package PasswordGenerator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the password length:");

        try (Scanner scanner = new Scanner(System.in)) {
            int len = scanner.nextInt();

            PasswordGenerator generate = new PasswordGenerator(len);
            String password = generate.GeneratePass();
            System.out.println("Your generated password: " + password);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}