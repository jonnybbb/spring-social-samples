package org.springframework.social.showcase.xing;

import org.springframework.social.xing.api.Xing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class XingConnectionsController {

	private Xing xing;

	@Inject
	public XingConnectionsController(Xing xing) {
		this.xing = xing;
	}
		
	@RequestMapping(value="/xing/connections", method=RequestMethod.GET)
	public String connections(Model model) {
		model.addAttribute("connections", xing.connectionOperations().getConnectionWithProfil());
		return "xing/connections";
	}
}
