package com.example.team.model.reward_info.dao;

import java.util.List;

import com.example.team.model.reward_info.dto.Item_stepDTO;

public interface Item_stepDAO {

	public List<Item_stepDTO> listStep(int rno);
	public List<Item_stepDTO> pay_view(int rno);
	public void amountUpdate(Item_stepDTO dto2);
	

}
