package com.example.team.model.member.dao;

import com.example.team.model.member.dto.MemberDTO;

public interface MemberDAO {
	public boolean login(MemberDTO dto);
	public MemberDTO userInfoMember(String userid);
	public void join(MemberDTO dto);
	public int userid_check(String userid);
	public void ac_sign(MemberDTO dto)  throws Exception;
	public MemberDTO ac_sign_route(int uno);
	

}
