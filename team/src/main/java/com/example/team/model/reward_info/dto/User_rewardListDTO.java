package com.example.team.model.reward_info.dto;

import java.util.List;


public class User_rewardListDTO {

	private List<User_rewardDTO> test;


	public List<User_rewardDTO> getTest() {
		return test;
	}

	public void setTest(List<User_rewardDTO> test) {
		this.test = test;
	}
	public User_rewardListDTO() {

	}
	
	@Override
	public String toString() {
		return "User_rewardListDTO [test=" + test + "]";
	}

	public User_rewardListDTO(List<User_rewardDTO> test) {
	
		this.test = test;
	}	
}
