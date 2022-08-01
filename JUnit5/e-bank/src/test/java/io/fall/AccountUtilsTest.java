package io.fall;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.fall.exceptions.InvalidAccountException;
import io.fall.models.Account;
import io.fall.services.AccountUtils;

/**
 * Unit test for simple App.
 */
public class AccountUtilsTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void newAccountValidation() {

        AccountUtils accountUtils = AccountUtils.getInstance();
        
        assertThrows(InvalidAccountException.class, () -> {
            Account account = new Account("shh", "shiru@a", "1234567890");
            account.validateAccount();
        });

        assertThrows(InvalidAccountException.class, () -> {
            Account account = new Account("shiru", "shiru", "1234567890");
            account.validateAccount();
        });

        assertThrows(InvalidAccountException.class, () -> {
            Account account = new Account("shiru", "shiru@a", "123456789");
            account.validateAccount();
        });

    }
}
