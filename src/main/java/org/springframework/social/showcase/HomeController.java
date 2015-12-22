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
package org.springframework.social.showcase;

import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private Provider<ConnectionRepository> connectionRepositoryProvider;

	@RequestMapping("/")
	public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {

		log.info("### userDetails = {}", userDetails);

		model.addAttribute("username", userDetails.getUsername());
		model.addAttribute("connectionsToProviders", getConnectionRepository().findAllConnections());

		return "home";
	}

	private ConnectionRepository getConnectionRepository() {
		return connectionRepositoryProvider.get();
	}
}
