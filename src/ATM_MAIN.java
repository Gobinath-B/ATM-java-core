import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ATM_MAIN {

    // Method to hash the PIN using SHA-256
    public static byte[] hashPin(String pin) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(pin.getBytes());
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String pin = "1234"; // This should be hashed and stored securely
        byte[] hashedPin = hashPin(pin);
        int balance = 100000;
        int credit = 0;
        int debit = 0;
        boolean isCredit = false;
        boolean isDebit = false;
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        Scanner scanner = new Scanner(System.in);
        String name;

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Enter your pin number:");
            String temp_pin = scanner.next();
            byte[] hashedTempPin = hashPin(temp_pin);

            if (Arrays.equals(hashedPin, hashedTempPin)) {
                System.out.println("Enter your name:");
                name = scanner.next();
                System.out.println("Welcome " + name);

                while (true) {
                    System.out.println("---------------------------");
                    System.out.println("Press 1 to check balance");
                    System.out.println("Press 2 to credit amount");
                    System.out.println("Press 3 to debit amount");
                    System.out.println("Press 4 to get receipt");
                    System.out.println("Press 5 to exit");
                    System.out.println("---------------------------");
                    System.out.println("Choose an option...");
                    int opt;
                    try {
                        opt = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid input, please enter a number between 1 and 5.");
                        scanner.next(); // Clear the invalid input
                        continue;
                    }

                    switch (opt) {
                        case 1:
                            System.out.println("Account Balance: " + balance);
                            break;

                        case 2:
                            System.out.println("Enter an amount to credit: ");
                            try {
                                credit = scanner.nextInt();
                                if (credit < 0) {
                                    System.out.println("Invalid amount. Please enter a positive value.");
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please enter a valid amount.");
                                scanner.next(); // Clear the invalid input
                                break;
                            }
                            balance += credit;
                            System.out.println("Credited Successfully, Account Balance: " + balance);
                            isCredit = true;
                            isDebit = false;
                            break;

                        case 3:
                            System.out.println("Enter an amount to debit: ");
                            try {
                                debit = scanner.nextInt();
                                if (debit < 0) {
                                    System.out.println("Invalid amount. Please enter a positive value.");
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please enter a valid amount.");
                                scanner.next(); // Clear the invalid input
                                break;
                            }
                            if (debit <= balance) {
                                balance -= debit;
                                System.out.println("Debited Successfully, Account Balance: " + balance);
                                isDebit = true;
                                isCredit = false;
                            } else {
                                System.out.println("Insufficient balance.");
                            }
                            break;

                        case 4:
                            System.out.println("Thanks for reaching us");
                            System.out.println("Your Balance: " + balance);
                            if (isCredit) {
                                System.out.println("Your Last Transaction: " + credit + " was credited to the account");
                            } else if (isDebit) {
                                System.out.println("Your Last Transaction: " + debit + " was debited from the account");
                            } else {
                                System.out.println("No recent transactions.");
                            }
                            break;

                        case 5:
                            System.out.println("Thank you for using our service.");
                            return;

                        default:
                            System.out.println("Invalid option. Please choose a valid option.");
                            break;
                    }
                }
            } else {
                attempts++;
                System.out.println("Wrong pin number, try again.");
                if (attempts >= MAX_ATTEMPTS) {
                    System.out.println("Too many failed attempts. Exiting...");
                    return;
                }
            }
        }
    }
}
