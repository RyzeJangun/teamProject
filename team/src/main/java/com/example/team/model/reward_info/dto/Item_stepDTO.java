package com.example.team.model.reward_info.dto;

import java.util.Date;

public class Item_stepDTO {
	
	private int rno;//리워드 프로 번호
	private String r_id;//리워드 단계 번호
	private int price_unit;//리워드 하나 가격
	private String item_option;//아이템 옵션
	private int rest_amount;//남은 수량
	private int delivery_fee;//배송비
	private Date delivery_date;//리워드 발송 시작일
	private int dc_ratio;//리워드 단계별 할인률/혜택률 --ex)1단계:10% 2단계:15%원 3단계:20%
    private String item_name;//상품명
    private int step_investor;//단계별 리워드 투자자수
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
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
	public String getItem_option() {
		return item_option;
	}
	public void setItem_option(String item_option) {
		this.item_option = item_option;
	}
	public int getRest_amount() {
		return rest_amount;
	}
	public void setRest_amount(int rest_amount) {
		this.rest_amount = rest_amount;
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
	public int getDc_ratio() {
		return dc_ratio;
	}
	public void setDc_ratio(int dc_ratio) {
		this.dc_ratio = dc_ratio;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getStep_investor() {
		return step_investor;
	}
	public void setStep_investor(int step_investor) {
		this.step_investor = step_investor;
	}
	
	@Override
	public String toString() {
		return "Item_stepDTO [rno=" + rno + ", r_id=" + r_id + ", price_unit=" + price_unit + ", item_option="
				+ item_option + ", rest_amount=" + rest_amount + ", delivery_fee=" + delivery_fee + ", delivery_date="
				+ delivery_date + ", dc_ratio=" + dc_ratio + ", item_name=" + item_name + ", step_investor="
				+ step_investor + "]";
	}
	
	

}
