package com.thoughtworks.wallet;

import com.thoughtworks.wallet.Wallet;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

import java.beans.Transient;

public class WalletTest {


    @Test
    public void shouldReturnBalanceWhenEmpty() {
        Wallet wallet = new Wallet(0);

        double balance = wallet.balance();

        assertThat(balance, is(closeTo(0.00, 0.01)));
    }

    @Test
    public void shouldAddAmountToEmptyWallet() throws Exception{
        Wallet wallet = new Wallet(0);
        double amount = 20;

        wallet.put(amount);

        double balance = wallet.balance();
        assertThat(balance, is(closeTo(20.00, 0.01)));
    }

    @Test
    public void shouldThrowExceptionWhenNegativeBalanceIsAdded() throws Exception {
        Wallet wallet = new Wallet(0);
        double amount = -10;

        assertThrows(Exception.class, () -> wallet.put(amount));
    }

    @Test
    public void shouldAddAmountToWalletAgain() throws Exception{
        Wallet wallet = new Wallet(0);
        double amount = 20;
        wallet.put(amount);

        wallet.put(amount);

        double balance = wallet.balance();
        assertThat(balance, is(closeTo(40.00, 0.01)));
    }

}
