# Compound Interest Calculator

A simple Java console program that calculates how your money grows with compound interest, including monthly deposits.

## Features

- Choose any currency (e.g. EUR, USD, CHF)
- Enter an annual interest rate, a starting capital and a monthly deposit
- Interest is compounded monthly
- Shows your total invested amount, the interest earned and your final capital

## How to run

You need Java (JDK) installed.

1. Download the project: **Code → Download ZIP** (or use `git clone`)
2. Open a terminal in the `src` folder
3. Compile and run:

```bash
javac CompoundInterestCalculator.java
java CompoundInterestCalculator
```

Alternatively, open the project in IntelliJ IDEA and run `CompoundInterestCalculator`.

## Example

```
Which currency do you want to use? CHF
What is the annual interest rate (in %)? 7
How much is your starting capital? 1000
How much do you want to invest every month? 200
For how many years should your capital be invested? 10

After 10 years, your final capital will be 36626.62 CHF.

Total invested: 25000.00 CHF
Interest earned: 11626.62 CHF
Final Capital: 36626.62 CHF
```

## How it works

The annual interest rate is converted into a monthly rate. The starting capital and the monthly deposits then grow with compound interest over all months:

- Starting capital: `capital * (1 + r)^n`
- Monthly deposits: `deposit * ((1 + r)^n - 1) / r`

where `r` is the monthly interest rate and `n` is the number of months.

## Note

This is a simplified calculation. It does not include taxes, fees or inflation, and real returns are not guaranteed.
