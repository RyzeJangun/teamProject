package com.example.team.model.reward_info.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.team.model.reward_info.dto.Item_stepDTO;
import com.example.team.model.reward_info.dto.Reward_infoDTO;
import com.example.team.model.reward_info.dto.User_rewardDTO;
import com.example.team.model.reward_info.dto.User_rewardListDTO;

@Repository
public class Reward_infoDAOImpl implements Reward_infoDAO {

	
	@Inject
	SqlSession sqlSession;

	@Override
	public List<Reward_infoDTO> list() {
		return sqlSession.selectList("reward_info.reward_infoList");
	}
	
	@Override
	public Reward_infoDTO detailReward(int rno) {
		return sqlSession.selectOne("reward_info.reward_infoDetail", rno);
	}
	
	@Override
	public void viewUp(int rno) throws Exception {
		sqlSession.update("reward_info.viewUp", rno);
	}
	
	@Override
	public void pro_like(int rno) {
		sqlSession.update("reward_info.pro_likeUp", rno);
	}
	
	@Override
	public Item_stepDTO item_infoDetail(String r_id) {
		return sqlSession.selectOne("item_step.item_infoDetail",r_id);
	}
	
	@Override
	public void pay(User_rewardDTO dto) {
		sqlSession.insert("reward_info.pay", dto);
	}
	
	@Override
	public User_rewardDTO user_rewardList(String userid) {
		return sqlSession.selectOne("user_reward.user_rewardList", userid);
	}
	
	@Override
	public void images(Reward_infoDTO dto) {
		sqlSession.insert("images.imagesInsert",dto);
	}
	
	

}
