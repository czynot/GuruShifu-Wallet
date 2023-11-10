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
        Currency check = new Currency(0, Currency.currencyType.INR);

        Currency balance = wallet.balance();

        assertEquals(balance, check);
    }

    @Test
    public void shouldAddAmountToEmptyWallet() throws Exception{
        Wallet wallet = new Wallet(0);
        Currency amount = new Currency(20, Currency.currencyType.INR);
        Currency check = new Currency(20, Currency.currencyType.INR);
        wallet.put(amount);

        Currency balance = wallet.balance();

        assertEquals(balance, check);
    }

    @Test
    public void shouldThrowExceptionWhenNegativeBalanceIsAdded() throws Exception {
        assertThrows(Exception.class, () -> new Currency(-10, Currency.currencyType.INR));
    }

    @Test
    public void shouldAddAmountToWalletAgain() throws Exception{
        Wallet wallet = new Wallet(0);
        Currency amount = new Currency(20, Currency.currencyType.INR);
        Currency check = new Currency(40, Currency.currencyType.INR);
        wallet.put(amount);

        wallet.put(amount);

        Currency balance = wallet.balance();
        assertEquals(balance, check);
    }

    @Test
    public void shouldAddDollarToWallet() throws Exception{
        Wallet wallet = new Wallet(0);
        Currency amount = new Currency(10, Currency.currencyType.USD);
        Currency check = new Currency(800, Currency.currencyType.INR);

        wallet.put(amount);

        Currency balance = wallet.balance();
        assertEquals(balance,check);
    }

    @Test
    public void shouldAddDollarToWalletWhenRupeeIsAlreadyThere() throws Exception{
        Wallet wallet = new Wallet(0);
        Currency rupeeAmount = new Currency(20, Currency.currencyType.INR);
        wallet.put(rupeeAmount);
        Currency dollarAmount = new Currency(10, Currency.currencyType.USD);
        Currency check = new Currency(820, Currency.currencyType.INR);

        wallet.put(dollarAmount);

        Currency balance = wallet.balance();
        assertEquals(balance, check);
    }


}