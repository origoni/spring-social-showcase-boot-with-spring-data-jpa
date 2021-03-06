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
package org.springframework.social.showcase.signin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.showcase.account.AccountDetail;
import org.springframework.social.showcase.account.AccountRepository;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SignInUtils {

	@Autowired
	private AccountRepository accountRepository;

	public void signin(String userId) {

		log.info("### userId = {}", userId);

		AccountDetail accountDetail = new AccountDetail(accountRepository.findAccountByUserId(userId));
		Authentication authentication = new UsernamePasswordAuthenticationToken(accountDetail, null, accountDetail.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
