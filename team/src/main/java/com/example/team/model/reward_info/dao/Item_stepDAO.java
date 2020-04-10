package com.example.team.model.reward_info.dao;

import java.util.List;

import com.example.team.model.reward_info.dto.Item_stepDTO;

public interface Item_stepDAO {

	List<Item_stepDTO> listStep(int rno);
	List<Item_stepDTO> pay_view(int rno);
	

}
