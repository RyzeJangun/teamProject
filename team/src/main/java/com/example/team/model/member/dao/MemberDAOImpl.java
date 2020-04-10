package com.example.team.model.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.team.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public void join(MemberDTO dto) {
		sqlSession.insert("member.join", dto);
	}
	
	@Override
	public int userid_check(String userid) {
		return sqlSession.selectOne("member.userid_check", userid);
	}
	
	@Override
	public boolean login(MemberDTO dto) {
		String name=sqlSession.selectOne("member.login", dto);
		//조건식 ? true일 때의 값 : false일 때의 값
		return (name==null) ? false : true;
	}
		
	@Override
	public MemberDTO userInfoMember(String userid) {
		return sqlSession.selectOne("member.userInfoMember", userid);
	}
	
	@Override
	public MemberDTO ac_sign_route(int uno) {
		return sqlSession.selectOne("member.userInfoMember", uno);
	}
	
	@Override
	public void ac_sign(MemberDTO dto)  throws Exception{
		sqlSession.update("member.ac_sign",dto);
	}
	
}
