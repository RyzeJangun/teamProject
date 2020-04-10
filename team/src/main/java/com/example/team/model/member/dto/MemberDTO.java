package com.example.team.model.member.dto;

import java.util.Date;

public class MemberDTO {
	
	private int uno;//0.회원 번호 (그 사람의 학번이라고 생각 해도 무방) -->시퀀스처리
	private String userid; //1.유저아이디                
	private String passwd;//2.비밀번호
	private String name;//3.성명
	private Date birth;//4.생년월일
	private String gender;//5.성별
	private String email1;//6-1.이메일 앞
	private String email2;//6-2.이메일 뒤
	private int email_confirm;//7.이메일인증여부 -->(0=인증 실패 1=인증성공)
	private String hp;//8.전화번호
	private String postcode;//9-1.우편번호
	private String road_addr;//9-2.도로명 주소
	private String detail_addr;//9-3.세부주소	
	private String ac_number;//10.계좌번호
	private int ac_money;//11.본인통장 계좌 금액
	private String user_type;//12.투자자 타입/투자자 등급 
	private int grade_sign;//13.투자자 심사여부(0=불 or 미심사 1=통과)
	private int concern_job;//14.관심직종 및 관심 분야	
	//total_funding number, --15.총투자액-->보류//total_reward number, --16.총 리워드 펀딩 액수-->보류
	private String thumbnail;//17.프로필사진
	private int company_sign;//18.기업등록여부/심사통과여부/판매자(0=미등록 1=심사중 2=합격 3=불합격)
	private String company_name;//19.회사명-->기업이 아닌 회원은 null값으로 처리
	private Date join_date;//20.가입일자
	private int cno;//21.등록 회사 번호 연결 table :company
	private int reserve_money;//22.적립금
	private int reward_amount;//리워드 수량
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public int getEmail_confirm() {
		return email_confirm;
	}
	public void setEmail_confirm(int email_confirm) {
		this.email_confirm = email_confirm;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getRoad_addr() {
		return road_addr;
	}
	public void setRoad_addr(String road_addr) {
		this.road_addr = road_addr;
	}
	public String getDetail_addr() {
		return detail_addr;
	}
	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}
	public String getAc_number() {
		return ac_number;
	}
	public void setAc_number(String ac_number) {
		this.ac_number = ac_number;
	}
	public int getAc_money() {
		return ac_money;
	}
	public void setAc_money(int ac_money) {
		this.ac_money = ac_money;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public int getGrade_sign() {
		return grade_sign;
	}
	public void setGrade_sign(int grade_sign) {
		this.grade_sign = grade_sign;
	}
	public int getConcern_job() {
		return concern_job;
	}
	public void setConcern_job(int concern_job) {
		this.concern_job = concern_job;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getCompany_sign() {
		return company_sign;
	}
	public void setCompany_sign(int company_sign) {
		this.company_sign = company_sign;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getReserve_money() {
		return reserve_money;
	}
	public void setReserve_money(int reserve_money) {
		this.reserve_money = reserve_money;
	}
	public int getReward_amount() {
		return reward_amount;
	}
	public void setReward_amount(int reward_amount) {
		this.reward_amount = reward_amount;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [uno=" + uno + ", userid=" + userid + ", passwd=" + passwd + ", name=" + name + ", birth="
				+ birth + ", gender=" + gender + ", email1=" + email1 + ", email2=" + email2 + ", email_confirm="
				+ email_confirm + ", hp=" + hp + ", postcode=" + postcode + ", road_addr=" + road_addr
				+ ", detail_addr=" + detail_addr + ", ac_number=" + ac_number + ", ac_money=" + ac_money
				+ ", user_type=" + user_type + ", grade_sign=" + grade_sign + ", concern_job=" + concern_job
				+ ", thumbnail=" + thumbnail + ", company_sign=" + company_sign + ", company_name=" + company_name
				+ ", join_date=" + join_date + ", cno=" + cno + ", reserve_money=" + reserve_money + ", reward_amount="
				+ reward_amount + "]";
	}

	
}
