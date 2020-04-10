package com.example.team.model.reward_info.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.team.model.reward_info.dto.Item_stepDTO;

@Repository
public class Item_stepDAOImpl implements Item_stepDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<Item_stepDTO> listStep(int rno) {
		return sqlSession.selectList("item_step.price_unit", rno);
	}
	
	@Override
	public List<Item_stepDTO> pay_view(int rno) {
		return sqlSession.selectList("reward_info.paymentInfo",rno);
	}

}
