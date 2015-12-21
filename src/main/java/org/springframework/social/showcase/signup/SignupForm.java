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
package org.springframework.social.showcase.signup;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.social.connect.UserProfile;
import org.springframework.util.StringUtils;

import lombok.Data;

@Data
public class SignupForm {

	@NotEmpty
	private String userId;

	@Size(min = 6, message = "must be at least 6 characters")
	private String password;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	public static SignupForm fromProviderUser(UserProfile providerUser) {

		SignupForm form = new SignupForm();
		form.setFirstName(providerUser.getFirstName());
		form.setLastName(providerUser.getLastName());
		form.setUserId(providerUser.getUsername());

		if (StringUtils.isEmpty(form.getUserId())) {
			if (StringUtils.isEmpty(providerUser.getEmail())) {
				form.setUserId(StringUtils.isEmpty(providerUser.getName()) ? "" : providerUser.getName().replaceAll("[ ]+", "").toLowerCase());
			} else {
				form.setUserId(providerUser.getEmail().split("[@._]")[0]);
			}
		}

		return form;
	}
}
