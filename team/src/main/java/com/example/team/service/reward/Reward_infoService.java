package com.example.team.service.reward;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.team.model.reward_info.dto.Item_stepDTO;
import com.example.team.model.reward_info.dto.Reward_infoDTO;
import com.example.team.model.reward_info.dto.User_rewardDTO;


public interface Reward_infoService {
	public List<Reward_infoDTO> list();
	public Reward_infoDTO detailReward(int rno);
	public void pay(User_rewardDTO dto);
	public User_rewardDTO user_rewardList(String userid);
	public Item_stepDTO item_infoDetail(String r_id);
	public void images(Reward_infoDTO dto);
	public void viewUp(int rno, HttpSession session) throws Exception;//조회수 증가
	public void pro_like(int rno,HttpSession session);//좋아용
	
			
}
