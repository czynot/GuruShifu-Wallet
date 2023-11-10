package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;


public class WalletTest {


    @Test
    public void shouldReturnBalanceWhenEmpty() throws Exception{
        Wallet wallet = new Wallet(0);
        Money check = new Money(0, Money.Currency.INR);

        Money balance = wallet.balance();

        assertEquals(balance, check);
    }

    @Test
    public void shouldAddAmountToEmptyWallet() throws Exception{
        Wallet wallet = new Wallet(0);
        Money amount = new Money(20, Money.Currency.INR);
        Money check = new Money(20, Money.Currency.INR);
        wallet.put(amount);

        Money balance = wallet.balance();

        assertEquals(balance, check);
    }

    @Test
    public void shouldThrowExceptionWhenNegativeBalanceIsAdded() throws Exception {
        assertThrows(Exception.class, () -> new Money(-10, Money.Currency.INR));
    }

    @Test
    public void shouldAddAmountToWalletAgain() throws Exception{
        Wallet wallet = new Wallet(0);
        Money amount = new Money(20, Money.Currency.INR);
        Money check = new Money(40, Money.Currency.INR);
        wallet.put(amount);

        wallet.put(amount);

        Money balance = wallet.balance();
        assertEquals(balance, check);
    }

    @Test
    public void shouldAddDollarToWallet() throws Exception{
        Wallet wallet = new Wallet(0);
        Money amount = new Money(10, Money.Currency.USD);
        Money check = new Money(800, Money.Currency.INR);

        wallet.put(amount);

        Money balance = wallet.balance();
        assertEquals(balance,check);
    }

    @Test
    public void shouldAddDollarToWalletWhenRupeeIsAlreadyThere() throws Exception{
        Wallet wallet = new Wallet(0);
        Money rupeeAmount = new Money(20, Money.Currency.INR);
        wallet.put(rupeeAmount);
        Money dollarAmount = new Money(10, Money.Currency.USD);
        Money check = new Money(820, Money.Currency.INR);

        wallet.put(dollarAmount);

        Money balance = wallet.balance();
        assertEquals(balance, check);
    }

    @Test
    public void shouldWithdrawINRFromWallet() throws Exception{
        Wallet wallet = new Wallet(0);
        Money rupeeAmount = new Money(100, Money.Currency.INR);
        wallet.put(rupeeAmount);
        Money withdrawalAmount = new Money(10, Money.Currency.INR);
        Money check = new Money(10, Money.Currency.INR);

        Money withdrawn = wallet.withdraw(withdrawalAmount);

        assertEquals(withdrawn, check);
    }

    @Test
    public void shouldWithdrawUSDFromWallet() throws Exception{
        Wallet wallet = new Wallet(0);
        Money rupeeAmount = new Money(160, Money.Currency.INR);
        wallet.put(rupeeAmount);
        Money withdrawalAmount = new Money(1, Money.Currency.USD);
        Money check = new Money(1, Money.Currency.USD);

        Money withdrawn = wallet.withdraw(withdrawalAmount);

        assertEquals(withdrawn, check);
    }

    @Test
    public void shouldWithdrawINRFromWalletAndCheckBalance() throws Exception{
        Wallet wallet = new Wallet(0);
        Money rupeeAmount = new Money(100, Money.Currency.INR);
        wallet.put(rupeeAmount);
        Money withdrawalAmount = new Money(10, Money.Currency.INR);
        Money check = new Money(90, Money.Currency.INR);

        wallet.withdraw(withdrawalAmount);
        Money balance = wallet.balance();

        assertEquals(balance, check);
    }

    @Test
    public void shouldWithdrawMultipleTimesFromWalletAndCheckBalance() throws Exception{
        Wallet wallet = new Wallet(0);
        Money rupeeAmount = new Money(200, Money.Currency.INR);
        wallet.put(rupeeAmount);
        Money withdrawalAmount1 = new Money(20, Money.Currency.INR);
        wallet.withdraw(withdrawalAmount1);
        Money withdrawalAmount2 = new Money(1, Money.Currency.USD);
        wallet.withdraw(withdrawalAmount2);
        Money check = new Money(100, Money.Currency.INR);

        Money balance = wallet.balance();

        assertEquals(balance, check);
    }

    @Test
    public void shouldThrowExceptionWhenWithdrawlAmountIsGreaterThanBalance() throws Exception {
        Wallet wallet = new Wallet(0);
        Money withdrawalAmount = new Money(10, Money.Currency.INR);

        assertThrows(Exception.class, () -> wallet.withdraw(withdrawalAmount));
    }

}