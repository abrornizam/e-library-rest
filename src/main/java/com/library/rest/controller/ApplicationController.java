/**
 * 
 */
package com.library.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ANIZAM
 *
 */

@Controller
@RequestMapping("/library/rest")
public class ApplicationController {

	@GetMapping({"", "/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/listBook")
	public String listBook() {
		return "redirect:/rest/library/book/listBook";
	}
	
	@GetMapping("/listMember")
	public String listMember() {
		return "redirect:/rest/library/member/listMember";
	}
	
	@GetMapping("/listTransaction")
	public String listTransaction() {
		return "redirect:/rest/library/transaction/listTransaction";
	}
}
