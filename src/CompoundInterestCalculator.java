import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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

                // CHANGE: changed it into a for loop to make it possible to see the yearly progress and simpler   -> variable months important

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
            System.out.println("After " + years + " years, your final capital will be " + String.format("%.2f ", finalCapital) + currency + ".");
            System.out.println(" ");
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

        scanner.close();

    }
}


