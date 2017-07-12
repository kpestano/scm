package com.sofgen.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tpenarubia
 *
 */
@Controller
@RequestMapping(value= "/")
public class IndexController {

	private static final String VIEW_PAGE = "index";
	
	@RequestMapping(method = RequestMethod.GET)
	String index(){
		return VIEW_PAGE;
	}
}
