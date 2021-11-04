import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        final double START_AMOUNT = 1000.00, MIN_AMOUNT = 0.0, MIN_WITHDRAW = 10.0, MIN_DEPOSIT = 5.0;

        double balance = START_AMOUNT, inputAmount;
        boolean stopLoop = false, amountIsValid;

        while (!stopLoop) {
            System.out.print(
                    "\nSelect an option\n1. View balance\n2. Withdraw funds\n3. Deposit funds\n4. Exit\nNumber: ");
            int inputNumber = scan.nextInt();

            switch (inputNumber) {
            case 1: {
                System.out.printf("Your balance is %5.2f", balance);
                break;
            }
            case 2: {
                do {
                    System.out.printf("How much funds would you like to withdraw? (cancel = 0)\nAmount: ");
                    inputAmount = scan.nextDouble();
                    if (inputAmount == 0) {
                        break;
                    }

                    amountIsValid = inputAmount > MIN_AMOUNT && inputAmount < balance;
                    if (!amountIsValid) {
                        if (inputAmount < MIN_WITHDRAW)
                            System.out.printf("You must withdraw a minimun of %5.0f funds.\n", MIN_WITHDRAW);
                        else
                            System.out.println("You don't have enough funds.");
                    }
                    balance -= inputAmount;
                    System.out.printf("Withdrawn %5.2f funds.\n", balance);
                } while (!amountIsValid);
                break;
            }
            case 3: {
                do {
                    System.out.printf("How much funds would you like to deposit? (cancel = 0)\nAmount: ");
                    inputAmount = scan.nextDouble();
                    if (inputAmount == 0) {
                        break;
                    }
                    amountIsValid = inputAmount > MIN_DEPOSIT;
                    if (!amountIsValid) {
                        System.out.printf("You must deposit a minimun of %5.0f funds.\n", MIN_DEPOSIT);

                    }
                    balance += inputAmount;
                    System.out.printf("Deposited %5.2f funds.\n", balance);
                } while (!amountIsValid);
                break;
            }
            case 4: {
                System.out.println("Are you sure you want to quit?\n1. Yes\n2. No");
                inputNumber = scan.nextInt();
                switch (inputNumber) {
                case 1: {
                    stopLoop = true;
                    break;
                }
                case 2: {
                    break;
                }
                default: {
                    System.out.println("Invalid option");
                    break;
                }
                }
            }
            default: {
                System.out.println("Invalid option.");
                break;
            }
            }
        }
        scan.close();

    }
}
