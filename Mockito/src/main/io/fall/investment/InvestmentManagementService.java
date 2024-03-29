package io.fall.investment;

import io.fall.Account;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;

public interface InvestmentManagementService {
    void addFunds(Account account, BigDecimal investmentAmount, Currency investmentCcy);

    boolean buyInvestmentFund(Account account, String fundId, BigDecimal investmentAmount) throws IOException;

    boolean sellInvestmentFund(Account account, String fundId, BigDecimal investmentAmount) throws IOException;
}
