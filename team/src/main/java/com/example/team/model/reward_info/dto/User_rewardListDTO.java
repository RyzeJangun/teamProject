package com.example.team.model.reward_info.dto;

import java.util.List;


public class User_rewardListDTO {

	private List<User_rewardListDTO> test;

	@Override
	public String toString() {
		return "User_rewardListDTO [test=" + test + "]";
	}

	public List<User_rewardListDTO> getTest() {
		return test;
	}

	public void setTest(List<User_rewardListDTO> test) {
		this.test = test;
	}
	public User_rewardListDTO() {

	}

	public User_rewardListDTO(List<User_rewardListDTO> test) {
	
		this.test = test;
	}	
}
