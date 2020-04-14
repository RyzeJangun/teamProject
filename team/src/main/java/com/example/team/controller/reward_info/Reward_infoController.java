package com.example.team.controller.reward_info;


import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.team.model.member.dto.MemberDTO;
import com.example.team.model.reward_info.dto.Item_stepDTO;
import com.example.team.model.reward_info.dto.Reward_infoDTO;
import com.example.team.model.reward_info.dto.User_rewardDTO;
import com.example.team.model.reward_info.dto.User_rewardListDTO;
import com.example.team.service.member.MemberService;
import com.example.team.service.reward.Item_stepService;
import com.example.team.service.reward.Reward_infoService;

@Controller
@RequestMapping("reward_info/*")
public class Reward_infoController {

	//로깅처리
	private static final Logger logger=
			LoggerFactory.getLogger(Reward_infoController.class);

	@Inject
	Reward_infoService reward_infoService;
	@Inject
	Item_stepService item_stepService;
	@Inject
	MemberService memberService;

	//모든 리워드 프로젝트 리스트
	@RequestMapping("reward_infoList.do")
	public String list(Model model) {
		List<Reward_infoDTO> list= reward_infoService.list();
		model.addAttribute("list", list);
		//model.addAttribute(attributeName 변수명, attributeValue 정의된 변수의값or변수값)
		return "reward_info/reward_infoList";//reward_infoList로 포워딩
	}

	//리스트중 선택한 리워드 프로젝트 세부정보
	@RequestMapping("reward_infoDetail/{rno}")
	public ModelAndView reward_infoDetail(@PathVariable("rno") int rno,HttpSession session) throws Exception{	
		reward_infoService.viewUp(rno, session);//조회수 증가
		ModelAndView mav=new ModelAndView();
		mav.setViewName("reward_info/reward_infoDetail");	
		mav.addObject("list", reward_infoService.detailReward(rno));//프로젝트 정보
		mav.addObject("step", item_stepService.listStep(rno));//아이템 정보
		return mav;
	}

	//좋아요 증가
	@RequestMapping("pro_like.do")
	public String pro_like(int rno,HttpSession session) {
		reward_infoService.pro_like(rno,session);
		return "redirect:/reward_info/reward_infoDetail"+rno;
	}

	//리워드 아이템 세부정보 창
	@RequestMapping("item_infoDetail/{r_id}")
	public ModelAndView item_infoDetail(@PathVariable("r_id") String r_id) {		
		Item_stepDTO dto2=reward_infoService.item_infoDetail(r_id);
		ModelAndView mav =new ModelAndView();		
		mav.setViewName("reward_info/item_infoDetail");		
		mav.addObject("dto2", dto2);	
		return mav;
	}

	//프로젝트 썸네일 이미지 삽입
	@RequestMapping("images.do")
	public String insert(@ModelAttribute Reward_infoDTO dto) {
		String filename="-";//초기값으로 "-"
		//첨부 파일이 있으면
		if(!dto.getFile1().isEmpty()) {
			//첨부 파일의 이름
			filename=dto.getFile1().getOriginalFilename();
			try {
				//배포 디렉토리 사용
				//단점 : 서버 clean을 하면 이미지가 지워짐
				//장점 : images폴더를 새로고침 안해도 이미지가 잘 나옴
				String path="D:\\work\\.metadata\\.plugins"
						+ "\\org.eclipse.wst.server.core\\tmp0"
						+ "\\wtpwebapps\\team\\"
						+ "WEB-INF\\views\\images\\";
				//디렉토리가 존재하지 않으면 생성
				new File(path).mkdir();
				//임시 디렉토리에 저장됨 첨부파일을 이동
				dto.getFile1().transferTo(new File(path+filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//if
		dto.setPro_thumbnail(filename);
		reward_infoService.images(dto);
		return "redirect:/reward_info/reward_infoList";
	}//insert()

	//결제창
	@RequestMapping("pay_view/{rno}")
	public ModelAndView pay_view(@PathVariable("rno") int rno,HttpSession session){	
		List<Item_stepDTO> pay_view= item_stepService.pay_view(rno);
		String userid=(String)session.getAttribute("userid");
		MemberDTO dto=memberService.userInfoMember(userid);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("reward_info/reward_payment");	
		mav.addObject("user_info", dto);
		mav.addObject("pay_view", pay_view);
		System.out.println(dto);
		System.out.println(pay_view);
		return mav;
	}

	//리워드 투자하기
	@RequestMapping("reward_payment.do")
	public String pay(@ModelAttribute User_rewardListDTO test,HttpSession session){	
		System.out.println(test);		
		MemberDTO dto1=new MemberDTO();
		String userid=(String)session.getAttribute("userid"); 	  
		dto1.setUserid(userid);
		reward_infoService.pay(test);	
		return "redirect:/reward_info/reward_infoList.do";
	 
	}

	//본인이 한 리워드 투자 목록
	@RequestMapping("user_reward.do")
	public ModelAndView user_reward(HttpSession session) {
		String userid=(String)session.getAttribute("userid");
		User_rewardDTO dto=reward_infoService.user_rewardList(userid);
		ModelAndView mav =new ModelAndView();		
		mav.setViewName("pay_info/user_reward");
		mav.addObject("pay_reward",dto);
		return mav;
	}

}







