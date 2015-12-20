package org.springframework.social.showcase.account;

import org.springframework.data.repository.CrudRepository;

public interface AccountDao extends CrudRepository<Account, Integer> {

	Account findByUserId(String userId);

//	Account findByUsername(String username);
}
