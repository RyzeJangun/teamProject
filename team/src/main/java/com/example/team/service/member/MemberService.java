package com.example.team.service.member;

import javax.servlet.http.HttpSession;

import com.example.team.model.member.dto.MemberDTO;

public interface MemberService {
	public boolean login(MemberDTO dto, HttpSession session);
	public void logout(HttpSession session);
	public MemberDTO userInfoMember(String userid);
	public void ac_sign(MemberDTO dto) throws Exception;
	public void join(MemberDTO dto);
	public int userid_check(String userid);
	public MemberDTO ac_sign_route(int uno);
	
	
	
}
