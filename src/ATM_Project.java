import java.util.Scanner;
class ATMProgram {
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            if (initialBalance >= 0) {
                this.balance = initialBalance;
            } else {
                System.out.println("Initial balance cannot be negative. Setting balance to $0.");
                this.balance = 0;
            }
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        }
    }
    static class ATM {
        private BankAccount account;
        private Scanner scanner;

        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        public void displayMenu() {
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private void checkBalance() {
            System.out.println("Your current balance is: $" + account.getBalance());
        }

        private void deposit() {
            System.out.print("Enter the amount to deposit: $");
            double amount = scanner.nextDouble();
            if (amount > 0) {
                account.deposit(amount);
                System.out.println("Successfully deposited $" + amount);
            } else {
                System.out.println("Invalid deposit amount. Please try again.");
            }
        }

        private void withdraw() {
            System.out.print("Enter the amount to withdraw: $");
            double amount = scanner.nextDouble();
            if (amount > 0) {
                if (account.withdraw(amount)) {
                    System.out.println("Successfully withdrew $" + amount);
                } else {
                    System.out.println("Insufficient funds. Please try a different amount.");
                }
            } else {
                System.out.println("Invalid withdrawal amount. Please try again.");
            }
        }
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}