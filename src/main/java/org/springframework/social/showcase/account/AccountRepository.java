/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.showcase.account;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

	@Autowired
	private AccountDao accountDao;

	public void createAccount(Account account) throws UsernameAlreadyInUseException {
		try {
			accountDao.save(account);
		} catch (ConstraintViolationException | DataIntegrityViolationException e) {
			throw new UsernameAlreadyInUseException(account.getUserId());
		}
	}

	public Account findAccountByUserId(String userId) {
		return accountDao.findByUserId(userId);
	}
}
