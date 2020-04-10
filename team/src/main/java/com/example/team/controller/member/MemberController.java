package com.example.team.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.team.model.member.dto.MemberDTO;
import com.example.team.service.member.MemberService;

@Controller
@RequestMapping("member/*")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	//로그인 경로
	@RequestMapping("login_route.do")
	public String login_route(){
		return "member/login";
	}
	
	//로그인
	@RequestMapping("login.do")
	public ModelAndView login(MemberDTO dto, 
			HttpSession session) {
		//로그인 성공 true, 실패 false
		boolean result=memberService.login(dto, session);
		ModelAndView mav=new ModelAndView();
		if(result) {//로그인 성공
			mav.setViewName("home");
		}else {//로그인 실패
			mav.setViewName("member/login");
			//뷰에 전달할 값
			mav.addObject("message", "error");
		}
		return mav;
	}//login_check()
	
	//로그아웃
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session,ModelAndView mav) {
		//세션초기화
		memberService.logout(session);
		//login.jsp로 이동
		mav.setViewName("member/login");
		mav.addObject("message", "logout");
		return mav;
	}
	//회원가입 경로
	@RequestMapping("join_route.do")
	public String join_route() {
		return "member/join";
	}
	
	//회원가입
	@RequestMapping("join.do")
	public String join(@ModelAttribute MemberDTO dto) {
		memberService.join(dto);
		return "redirect:/member/login_route.do";
	}
	
	//아이디 중복체크
		@RequestMapping(value="userid_check.do", method = RequestMethod.GET)
		@ResponseBody
		public int userid_check(String userid) {
			System.out.println(userid);
			return memberService.userid_check(userid);
		}
	
	//내정보
	@RequestMapping("userInfo.do")
	public ModelAndView userInfo(HttpSession session) {
		String userid=(String)session.getAttribute("userid");
		MemberDTO dto=memberService.userInfoMember(userid);
		ModelAndView mav =new ModelAndView();		
		mav.setViewName("member/myPage");
		mav.addObject("user_info", dto);
        return mav;
	}
	//계좌번호 등록 경로
	@RequestMapping("ac_sign_route/{uno}")
	public ModelAndView ac_sign_route(@PathVariable("uno") int uno,HttpSession session) {
		MemberDTO dto=memberService.ac_sign_route(uno);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("member/ac_number_sign");
		mav.addObject("sign", dto);
		return mav;
	}
	//계좌번호 등록
	@RequestMapping("ac_sign.do")
	public String ac_sign(MemberDTO dto,HttpSession session) throws Exception{	
		memberService.ac_sign(dto);//create method 눌러
		return "redirect:/member/userInfo.do";
	}

	
	

}
