package org.springframework.social.showcase.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository repository;

	@Override
	public final AccountDetail loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = repository.findAccountByUserId(username);

		if (account == null) {
			throw new UsernameNotFoundException("Not Exist User");
		}

		AccountDetail accountDetail = new AccountDetail(account);
		return accountDetail;
	}
}
