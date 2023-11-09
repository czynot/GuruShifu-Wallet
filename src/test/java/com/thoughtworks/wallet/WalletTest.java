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
        Rupee check = new Rupee(0);

        Rupee balance = wallet.balance();

        assertEquals(balance, check);
    }

    @Test
    public void shouldAddAmountToEmptyWallet() throws Exception{
        Wallet wallet = new Wallet(0);
        Rupee amount = new Rupee(20);
        Rupee check = new Rupee(20);
        wallet.put(amount);

        Rupee balance = wallet.balance();

        assertEquals(balance, check);
    }

    @Test
    public void shouldThrowExceptionWhenNegativeBalanceIsAdded() throws Exception {
        assertThrows(Exception.class, () -> new Rupee(-10));
    }

    @Test
    public void shouldAddAmountToWalletAgain() throws Exception{
        Wallet wallet = new Wallet(0);
        Rupee amount = new Rupee(20);
        Rupee check = new Rupee(40);
        wallet.put(amount);

        wallet.put(amount);

        Rupee balance = wallet.balance();
        assertEquals(balance, check);
    }

    @Test
    public void shouldAddDollarToWallet() throws Exception{
        Wallet wallet = new Wallet(0);
        Dollar amount = new Dollar(10);
        Rupee check = new Rupee(800);

        wallet.put(amount);

        Rupee balance = wallet.balance();
        assertEquals(balance,check);
    }

    @Test
    public void shouldAddDollarToWalletWhenRupeeIsAlreadyThere() throws Exception{
        Wallet wallet = new Wallet(0);
        Rupee rupeeAmount = new Rupee(20);
        wallet.put(rupeeAmount);
        Dollar dollarAmount = new Dollar(10);
        Rupee check = new Rupee(820);

        wallet.put(dollarAmount);

        Rupee balance = wallet.balance();
        assertEquals(balance, check);
    }


}