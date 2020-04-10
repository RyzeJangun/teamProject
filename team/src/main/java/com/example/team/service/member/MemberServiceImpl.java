package com.example.team.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.team.model.member.dao.MemberDAO;
import com.example.team.model.member.dto.MemberDTO;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDao;
	

	@Override
	public boolean login(MemberDTO dto, HttpSession session) {
		boolean result=memberDao.login(dto);
		if(result) {//로그인 성공
			//세션변수에 값 저장
		
			//setAttribute(변수명,값)
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", dto.getName());
			System.out.println(session.getAttribute("userid"));
			System.out.println(session.getAttribute("name"));
		}

		return result;
	}

	@Override
	public void logout(HttpSession session) {
		//세션 초기화
		session.invalidate();
	}
	
	@Override
	public void join(MemberDTO dto) {
		memberDao.join(dto);
	}
	
	@Override
	public int userid_check(String userid) {
		return memberDao.userid_check(userid);
	}
	
	@Override
	public MemberDTO userInfoMember(String userid) {
		return memberDao.userInfoMember(userid);
	}
	
	@Override
	public void ac_sign(MemberDTO dto)  throws Exception{
		memberDao.ac_sign(dto);
	}
	
	@Override
	public MemberDTO ac_sign_route(int uno) {
		return memberDao.ac_sign_route(uno);
	}

}
