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
package org.springframework.social.showcase.xing;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.xing.api.Xing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.security.Principal;

@Controller
public class XingProfileController {

	@Inject
	private ConnectionRepository connectionRepository;
	
	@RequestMapping(value="/xing", method=RequestMethod.GET)
	public String home(Principal currentUser, Model model) {
		Connection<Xing> connection = connectionRepository.findPrimaryConnection(Xing.class);
		if (connection == null) {
			return "redirect:/connect/xing";
		}
		model.addAttribute("profile", connection.getApi().profileOperations().getUserProfile());
		return "xing/profile";
	}
	
}
