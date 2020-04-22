package com.example.team.service.reward;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.team.model.reward_info.dao.Item_stepDAO;
import com.example.team.model.reward_info.dto.Item_stepDTO;

@Service
public class Item_stepServiceImpl implements Item_stepService {

	
	@Inject
	Item_stepDAO item_stepDao;
	
	@Override
	public List<Item_stepDTO> listStep(int rno) {
		return item_stepDao.listStep(rno);
	}
	
	@Override
	public List<Item_stepDTO> pay_view(int rno){
		return item_stepDao.pay_view(rno);
	}
	
	@Override
	public void amountUpdate(Item_stepDTO dto2) {
		item_stepDao.amountUpdate(dto2);
	}
	
}
