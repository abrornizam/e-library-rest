package com.library.rest.service;

/**
 * @author ANIZAM
 *
 */

import java.util.List;

import com.library.rest.model.Member;

public interface MemberService {

	List<Member> findAll();
	
	Member saveMember(Member member);
	
	void editMember(Member member);
	
	void deleteMember(String idmember);
	
	Member findByIdmember(String idmember);
	
}
