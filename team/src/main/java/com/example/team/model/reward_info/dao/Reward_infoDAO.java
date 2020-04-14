package com.example.team.model.reward_info.dao;

import java.util.List;

import com.example.team.model.reward_info.dto.Item_stepDTO;
import com.example.team.model.reward_info.dto.Reward_infoDTO;
import com.example.team.model.reward_info.dto.User_rewardDTO;
import com.example.team.model.reward_info.dto.User_rewardListDTO;

public interface Reward_infoDAO {
	public List<Reward_infoDTO> list();
    public Reward_infoDTO detailReward(int rno);
	public void pay(User_rewardListDTO test);
	public User_rewardDTO user_rewardList(String userid);
	public Item_stepDTO item_infoDetail(String r_id);
	public void images(Reward_infoDTO dto);
	public void viewUp(int rno) throws Exception;
	public void pro_like(int rno);

	
 
}
