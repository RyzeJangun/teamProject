package com.example.team.service.reward;
import java.util.List;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.team.model.reward_info.dao.Reward_infoDAO;
import com.example.team.model.reward_info.dto.Item_stepDTO;
import com.example.team.model.reward_info.dto.Reward_infoDTO;
import com.example.team.model.reward_info.dto.User_rewardDTO;
import com.example.team.model.reward_info.dto.User_rewardListDTO;

@Service
public class Reward_infoServiceImpl implements Reward_infoService {

	@Inject
	Reward_infoDAO reward_infoDao;

	@Override
	public List<Reward_infoDTO> list() {
		return reward_infoDao.list();
	}

	@Override
	public Reward_infoDTO detailReward(int rno) {
		return reward_infoDao.detailReward(rno);
	}
	
	@Override
	public void viewUp(int rno, HttpSession session) throws Exception{
		long cnt_update_time=0;
		String userid=(String)session.getAttribute("userid");
		if(session.getAttribute("cnt_update_time_"+rno+userid) != null) {
			//최근에 조회수를 올린 시간
			cnt_update_time=(long)session.getAttribute("cnt_update_time_"+rno+userid);
		}
		long current_time=System.currentTimeMillis();
		//일정 시간(10초)이 경과후 조회수 증가 처리
		if(current_time - cnt_update_time > 10*1000) {
			reward_infoDao.viewUp(rno);
			session.setAttribute("cnt_update_time_"+rno+userid, current_time);
		}
	}
	
	@Override
	public void pro_like(int rno,HttpSession session){
		long cnt_update_time=0;
		String userid=(String)session.getAttribute("userid");
		if(session.getAttribute("cnt_update_time_"+rno+userid) != null) {
			//최근에 좋아요 누른 시간
			cnt_update_time=(long)session.getAttribute("cnt_update_time_"+rno+userid);
		}
		long current_time=System.currentTimeMillis();
		//일정 시간(10초)이 경과후 좋아요 증가 처리
		if(current_time - cnt_update_time > 10*1000) {
			reward_infoDao.pro_like(rno);
			session.setAttribute("cnt_update_time_"+rno+userid, current_time);
		}
	}

	@Override
	public void pay(User_rewardListDTO test) {
		reward_infoDao.pay(test);
	}

	@Override
	public Item_stepDTO item_infoDetail(String r_id) {
		return reward_infoDao.item_infoDetail(r_id);
	}

	@Override
	public User_rewardDTO user_rewardList(String userid) {
		return reward_infoDao.user_rewardList(userid);
		}
	
	@Override
	public void images(Reward_infoDTO dto) {
		reward_infoDao.images(dto);
	}

	}
