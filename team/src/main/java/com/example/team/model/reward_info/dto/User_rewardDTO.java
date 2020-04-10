package com.example.team.model.reward_info.dto;

import java.util.Date;

public class User_rewardDTO {
  
	private int rno;//1.리워드 프로젝트 일련번호
	private int uno;
	private String userid;//2.사용자 아이디 -->희망사항:가능하면 u***id 이런식으로 익명성을 보장했으면 좋겠음
	private String name;//3.사용자 성명 -->희망사항:가능하면 김*깡 이런식으로 익명성을 보장했으면 좋겠음
	private String company_name;//4.회사명
	private String r_id;//--단계별 번호 -->구분
	private int price_unit;//단계별 리워드 펀딩금액
	private int total_reward;//7.나의 리워드총액
	private int delivery_fee;//배송비
	private int total_money;//나의 리워드 펀딩금액+배송비 -->로직에서 계산
	private int item_amount;//구매자가 선택한 아이템 수량
	private String item_option;//상품 옵션
	private Date delivery_date;//배송예정일
	private String delivery_postcode;//배송지 우편번호
	private String delivery_road;//배송지 도로명 주소
	private String delivery_detail;//배송지 세부주소
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public int getPrice_unit() {
		return price_unit;
	}
	public void setPrice_unit(int price_unit) {
		this.price_unit = price_unit;
	}
	public int getTotal_reward() {
		return total_reward;
	}
	public void setTotal_reward(int total_reward) {
		this.total_reward = total_reward;
	}
	public int getDelivery_fee() {
		return delivery_fee;
	}
	public void setDelivery_fee(int delivery_fee) {
		this.delivery_fee = delivery_fee;
	}
	public int getTotal_money() {
		return total_money;
	}
	public void setTotal_money(int total_money) {
		this.total_money = total_money;
	}
	public int getItem_amount() {
		return item_amount;
	}
	public void setItem_amount(int item_amount) {
		this.item_amount = item_amount;
	}
	public String getItem_option() {
		return item_option;
	}
	public void setItem_option(String item_option) {
		this.item_option = item_option;
	}
	
	
	public String getDelivery_postcode() {
		return delivery_postcode;
	}
	public void setDelivery_postcode(String delivery_postcode) {
		this.delivery_postcode = delivery_postcode;
	}
	public String getDelivery_road() {
		return delivery_road;
	}
	public void setDelivery_road(String delivery_road) {
		this.delivery_road = delivery_road;
	}
	public String getDelivery_detail() {
		return delivery_detail;
	}
	public void setDelivery_detail(String delivery_detail) {
		this.delivery_detail = delivery_detail;
	}
		
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	@Override
	public String toString() {
		return "User_rewardDTO [rno=" + rno + ", uno=" + uno + ", userid=" + userid + ", name=" + name
				+ ", company_name=" + company_name + ", r_id=" + r_id + ", price_unit=" + price_unit + ", total_reward="
				+ total_reward + ", delivery_fee=" + delivery_fee + ", total_money=" + total_money + ", item_amount="
				+ item_amount + ", item_option=" + item_option + ", delivery_date=" + delivery_date
				+ ", delivery_postcode=" + delivery_postcode + ", delivery_road=" + delivery_road + ", delivery_detail="
				+ delivery_detail + "]";
	}
	
	 

	
}
