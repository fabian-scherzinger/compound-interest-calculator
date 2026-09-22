import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

                // CHANGE: Decided to make it more useful in general. 2 questions should be answered. Financial goal && how much Im gonna have in 10y?

        System.out.println("Choose a calculator mode:");
        System.out.println("1 - Calculate final capital for an amount of time.");
        System.out.println("2 - Calculate time to reach a savings goal.");
        int mode = scanner.nextInt();
        scanner.nextLine();

        if (mode == 1) {

            System.out.print("Which currency do you want to use? ");
            String currency = scanner.nextLine();

            System.out.print("What is the annual interest rate (in %)? ");
            double interestRate = scanner.nextDouble();

            System.out.print("How much is your starting capital? ");
            double initialCapital = scanner.nextDouble();

            System.out.print("How much do you want to invest every month? ");
            double monthlyDeposit = scanner.nextDouble();

            System.out.print("For how many years should your capital be invested? ");
            int years = scanner.nextInt();

            System.out.println(" ");

            // Converting annual interest rate into a monthly interest rate

            double monthlyInterestRate = interestRate / 100 / 12;

            // Converting years into months

            int months = years * 12;

            // Calculation of the total amount of deposits and the total amount invested

            double totalDeposits = monthlyDeposit * months;
            double totalInvested = initialCapital + totalDeposits;

            // CHANGE: changed it into a for loop to make it possible to see the yearly progress and simpler  -> variable months important

            double finalCapital = initialCapital;

            for (int month = 1; month <= months; month++) {
                finalCapital = finalCapital * (1 + monthlyInterestRate);
                finalCapital = finalCapital + monthlyDeposit;

                if (month % 12 == 0) {
                    int currentYear = month / 12;
                    System.out.println("Capital after year " + currentYear + ": "
                            + String.format("%.2f ", finalCapital) + currency);
                }

            }

            System.out.println(" ");

            // interest earned and profit

            double interestEarned = finalCapital - totalInvested;

            if (years > 1) {
                // deleted following because its not relevant after all the data we are giving out
                // System.out.println("After " + years + " years, your final capital will be " + String.format("%.2f ", finalCapital) + currency + ".");
                // System.out.println(" ");
                System.out.println("Total invested: "
                        + String.format("%.2f ", totalInvested) + currency);
                System.out.println("Interest earned: "
                        + String.format("%.2f ", interestEarned) + currency);
                System.out.println("Final Capital: "
                        + String.format("%.2f ", finalCapital) + currency);
            } else if (years == 1) {
                System.out.println("After one year, your final capital will be " + String.format("%.2f ", finalCapital) + currency + ".");
                System.out.println(" ");
                System.out.println("Total invested: "
                        + String.format("%.2f ", totalInvested) + currency);
                System.out.println("Interest earned: "
                        + String.format("%.2f ", interestEarned) + currency);
                System.out.println("Final Capital: "
                        + String.format("%.2f ", finalCapital) + currency);
            } else {
                System.out.println("Please enter a valid amount of years!");
            }

        } else if (mode == 2) {

            System.out.print("Which currency do you want to use? ");
            String currency = scanner.nextLine();

            System.out.print("What is your financial goal to reach? ");
            double financialGoal = scanner.nextDouble();

            System.out.print("How much is your starting capital? ");
            double initialCapital = scanner.nextDouble();

            System.out.print("How much do you want to invest every month? ");
            double monthlyDeposit = scanner.nextDouble();

            System.out.print("What is the annual interest rate (in %)? ");
            double interestRate = scanner.nextDouble();

            double monthlyInterestRate = interestRate / 100 / 12;
            double finalCapital = initialCapital;
            int month = 0;



            // what if no monthly deposits and no interestRate??


            if (monthlyDeposit == 0 && interestRate == 0
                    && initialCapital < financialGoal) {

                System.out.println("Your financial goal cannot be reached with these values.");

            } else {
                while (finalCapital < financialGoal) {
                    finalCapital = finalCapital * (1 + monthlyInterestRate);
                    finalCapital = finalCapital + monthlyDeposit;
                    month++;
                }


                int yearsNeeded = month / 12;
                int remainingMonths = month % 12;

                // ADD: 1. 1year or 1.3years        2. exactly 1 year       3. less than a year but remaining months        4. neither

                if (yearsNeeded > 1 || (yearsNeeded == 1 && remainingMonths > 0)) {
                    System.out.println(" ");
                    System.out.println("To reach your financial goal of " + String.format("%.2f", financialGoal) + " " + currency + " with a monthly deposit of " + String.format("%.2f", monthlyDeposit)
                            + " " + currency);
                    System.out.println("and an interest rate of " + String.format("%.2f", interestRate) + "%, " + yearsNeeded + " years and " + remainingMonths + " months are needed.");
                } else if (yearsNeeded == 1 && remainingMonths == 0) {
                    System.out.println(" ");
                    System.out.println("Just one year is needed to reach your financial goal! Wow, congratulations!");
                } else if (yearsNeeded < 1 && remainingMonths > 0) {
                    System.out.println("To reach your financial goal of " + String.format("%.2f", financialGoal) + " " + currency + " just " + remainingMonths + " months are needed. Be ready to set your next goal! Congratulations!");
                } else if (yearsNeeded == 0 && remainingMonths == 0) {
                    System.out.println(" ");
                    System.out.println("You have already reached your financial goal.");
                }
            }

        } else {
            System.out.println("Please choose your wished mode!");
        }

        scanner.close();

    }
}


