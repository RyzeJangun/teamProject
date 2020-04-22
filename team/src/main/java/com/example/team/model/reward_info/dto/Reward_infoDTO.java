package com.example.team.model.reward_info.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Reward_infoDTO {
	private int rno; //1.리워드 프로젝트 번호 -->고유번호-->시퀀스로 번호 바로 부여
	private String company_name;//2.회사명 -->회사 정보 보기를 클릭하면 정보 볼 수 있게 함 -->company 테이블 정보 사용 
	private String reward_name;//3.리워드 프로젝트명
	private String reward_category;//4.카테고리 명 예)IT 패션 생필등
	private Date start_date;//5.게시일자
	private Date end_date;//6.마감일자
	private Date d_day;
	private int reward_max;//9.목표치
	private int reward_now;//10.현재투자액
	private int reward_ratio;//리워드 현재 투자 비율
	private int reward_investor;//리워드 투자자수
	private String r_id;//단계별 번호 -->ex) 1단계 2단계 3단계
	private String step_investor;//단계별 리워드 투자자수
	private String item_name;//상품명
	private int price_unit;//단계별 리워드 펀딩금액 --ex)1단계:10,000원 2단계:25,000원 3단계:50,000원
	private int dc_ratio;//리워드 단계별 할인률/혜택률 --ex)1단계:10% 2단계:15%원 3단계:20%
	private int total_amount;//전체 남은 수량,제한수량 -->남은 수량 0 되면 그 단계만 마감 처리
	private String item_option;//상품 옵션 
	private int delivery_fee;//배송비
	private Date delivery_date;//리워드 발송 시작일
	private String pro_type;//19.프로젝트 타입 구분
	private int pro_sign;//20.관리자 승인 여부-->0 1
	private int pro_like;//21.좋아요수
	private String pro_title;//22.프로젝트 본문 제목
	private String pro_content;//23.프로젝트 본문 내용
	private String pro_file;//24.프로젝트 첨부파일
	private String pro_thumbnail;//프로젝트 썸네일
	private String pro_writer;//25.작성자
	private int pro_view;//26.조회수 -->가변
	private int pro_progress;//27.프로젝트 진행 여부 (1=진행중,0=종료) -->목표액 달성-->종료 -->투자 거부 --end_date-start_date
	private Date pro_open;//28.오픈예정일
	private int pro_limit;//29.기간제한 (0=종료 1=제한 x)
	private MultipartFile file1;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getReward_name() {
		return reward_name;
	}
	public void setReward_name(String reward_name) {
		this.reward_name = reward_name;
	}
	public String getReward_category() {
		return reward_category;
	}
	public void setReward_category(String reward_category) {
		this.reward_category = reward_category;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getReward_max() {
		return reward_max;
	}
	public void setReward_max(int reward_max) {
		this.reward_max = reward_max;
	}
	public int getReward_now() {
		return reward_now;
	}
	public void setReward_now(int reward_now) {
		this.reward_now = reward_now;
	}
	public int getReward_ratio() {
		return reward_ratio;
	}
	public void setReward_ratio(int reward_ratio) {
		this.reward_ratio = reward_ratio;
	}
	public int getReward_investor() {
		return reward_investor;
	}
	public void setReward_investor(int reward_investor) {
		this.reward_investor = reward_investor;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public String getStep_investor() {
		return step_investor;
	}
	public void setStep_investor(String step_investor) {
		this.step_investor = step_investor;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getPrice_unit() {
		return price_unit;
	}
	public void setPrice_unit(int price_unit) {
		this.price_unit = price_unit;
	}
	public int getDc_ratio() {
		return dc_ratio;
	}
	public void setDc_ratio(int dc_ratio) {
		this.dc_ratio = dc_ratio;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public String getItem_option() {
		return item_option;
	}
	public void setItem_option(String item_option) {
		this.item_option = item_option;
	}
	public int getDelivery_fee() {
		return delivery_fee;
	}
	public void setDelivery_fee(int delivery_fee) {
		this.delivery_fee = delivery_fee;
	}
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getPro_type() {
		return pro_type;
	}
	public void setPro_type(String pro_type) {
		this.pro_type = pro_type;
	}
	public int getPro_sign() {
		return pro_sign;
	}
	public void setPro_sign(int pro_sign) {
		this.pro_sign = pro_sign;
	}
	public int getPro_like() {
		return pro_like;
	}
	public void setPro_like(int pro_like) {
		this.pro_like = pro_like;
	}
	public String getPro_title() {
		return pro_title;
	}
	public void setPro_title(String pro_title) {
		this.pro_title = pro_title;
	}
	public String getPro_content() {
		return pro_content;
	}
	public void setPro_content(String pro_content) {
		this.pro_content = pro_content;
	}
	public String getPro_file() {
		return pro_file;
	}
	public void setPro_file(String pro_file) {
		this.pro_file = pro_file;
	}
	public String getPro_writer() {
		return pro_writer;
	}
	public void setPro_writer(String pro_writer) {
		this.pro_writer = pro_writer;
	}
	public int getPro_view() {
		return pro_view;
	}
	public void setPro_view(int pro_view) {
		this.pro_view = pro_view;
	}
	public int getPro_progress() {
		return pro_progress;
	}
	public void setPro_progress(int pro_progress) {
		this.pro_progress = pro_progress;
	}
	public Date getPro_open() {
		return pro_open;
	}
	public void setPro_open(Date pro_open) {
		this.pro_open = pro_open;
	}
	public int getPro_limit() {
		return pro_limit;
	}
	public void setPro_limit(int pro_limit) {
		this.pro_limit = pro_limit;
	}
	
	public String getPro_thumbnail() {
		return pro_thumbnail;
	}
	public void setPro_thumbnail(String pro_thumbnail) {
		this.pro_thumbnail = pro_thumbnail;
	}
	
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	
	
	public Date getD_day() {
		return d_day;
	}
	public void setD_day(Date d_day) {
		this.d_day = d_day;
	}
	
	@Override
	public String toString() {
		return "Reward_infoDTO [rno=" + rno + ", company_name=" + company_name + ", reward_name=" + reward_name
				+ ", reward_category=" + reward_category + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", d_day=" + d_day + ", reward_max=" + reward_max + ", reward_now=" + reward_now + ", reward_ratio="
				+ reward_ratio + ", reward_investor=" + reward_investor + ", r_id=" + r_id + ", step_investor="
				+ step_investor + ", item_name=" + item_name + ", price_unit=" + price_unit + ", dc_ratio=" + dc_ratio
				+ ", total_amount=" + total_amount + ", item_option=" + item_option + ", delivery_fee=" + delivery_fee
				+ ", delivery_date=" + delivery_date + ", pro_type=" + pro_type + ", pro_sign=" + pro_sign
				+ ", pro_like=" + pro_like + ", pro_title=" + pro_title + ", pro_content=" + pro_content + ", pro_file="
				+ pro_file + ", pro_thumbnail=" + pro_thumbnail + ", pro_writer=" + pro_writer + ", pro_view="
				+ pro_view + ", pro_progress=" + pro_progress + ", pro_open=" + pro_open + ", pro_limit=" + pro_limit
				+ ", file1=" + file1 + "]";
	}
	
	
	
	

}
