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

        // Calculation of the growth of the initial capital and of the monthly deposits

        double finalInitialCapital = initialCapital * Math.pow(1 + monthlyInterestRate, months);

        double finalDeposits = monthlyDeposit * (Math.pow(1 + monthlyInterestRate, months) - 1) / monthlyInterestRate;

        // final capital calculation

        double finalCapital = finalInitialCapital + finalDeposits;

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
    }
}


