package com.example.team.service.reward;

import java.util.List;

import com.example.team.model.reward_info.dto.Item_stepDTO;

public interface Item_stepService {
	public List<Item_stepDTO> listStep(int rno);
	public List<Item_stepDTO> pay_view(int rno);

}
