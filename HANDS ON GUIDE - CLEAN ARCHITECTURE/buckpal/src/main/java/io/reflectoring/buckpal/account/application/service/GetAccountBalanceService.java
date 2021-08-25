package io.reflectoring.buckpal.account.application.service;

import java.time.LocalDateTime;

import io.reflectoring.buckpal.account.application.port.in.GetAccountBalanceQuery;
import io.reflectoring.buckpal.account.application.port.out.LoadAccountPort;
import io.reflectoring.buckpal.account.domain.Account.AccountId;
import io.reflectoring.buckpal.account.domain.Money;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

/* 
	--from the viewpoint of the application core is it only a query, it just as our use case service 

*/ 
class GetAccountBalanceService implements GetAccountBalanceQuery {

	private final LoadAccountPort loadAccountPort;

	@Override
	public Money getAccountBalance(AccountId accountId) {
		return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
				.calculateBalance();
	}
}
