package io.fall.investment;

import io.fall.Account;

import java.util.Currency;

public interface InvestmentManagementService {
    boolean addFunds(Account account, long investmentAmount, Currency investmentCcy);

    boolean buyInvestmentFund(Account account, String fundId, long investmentAmount, Currency investmentCcy);

    boolean sellInvestmentFund(Account account, String fundId, long investmentAmount, Currency investmentCcy);
}
