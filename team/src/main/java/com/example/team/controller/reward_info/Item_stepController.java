package com.example.team.controller.reward_info;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.team.model.reward_info.dto.Item_stepDTO;

import com.example.team.service.reward.Item_stepService;

@Controller
public class Item_stepController {
	
	@Inject
	Item_stepService item_stepService;
	
	@RequestMapping("item_step/{rno}")
	public ModelAndView reward_infoDetail(@PathVariable("rno") int rno, HttpSession session){	
		List<Item_stepDTO> listStep= item_stepService.listStep(rno);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("reward_info/reward_infoDetail");	
		mav.addObject("step", listStep);
		return mav;
	}
	

}
