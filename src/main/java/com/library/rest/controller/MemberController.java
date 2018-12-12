package com.library.rest.controller;

/**
 * @author ANIZAM
 *
 */

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.rest.model.Member;
import com.library.rest.service.MemberService;

@SpringBootApplication
@RestController
@RequestMapping("/rest/library/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
//	@CrossOrigin
	@GetMapping(value = "/listMember")
	public @ResponseBody List<Member> listMember(HttpServletResponse response)  {
    	response.setHeader("Access-Control-Allow-Origin", "*");
//    	response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		response.setContentType("application/json");
    	response.setStatus(200);
    	return memberService.findAll();
    }
	
	@PostMapping(value = "/save")
	public @ResponseBody void saveMember(@RequestBody Member member, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		memberService.saveMember(member);
	}
	
	@GetMapping(value = "/detail/{idmember}")
	public @ResponseBody Member detailMember(@PathVariable String idmember, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		return memberService.findByIdmember(idmember);
	}
	
	@PutMapping(value = "/edit/{idmember}")
	public @ResponseBody void editMember(@RequestBody Member member, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		memberService.editMember(member);
	}
	
	@DeleteMapping(value = "/delete/{idmember}")
	public @ResponseBody void deleteMember(@PathVariable String idmember, HttpServletResponse response) {
		response.setContentType("application/json");
		response.setStatus(200);
		memberService.deleteMember(idmember);
	}
	
}
