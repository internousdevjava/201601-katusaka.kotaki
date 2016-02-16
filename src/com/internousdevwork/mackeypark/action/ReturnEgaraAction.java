package com.internousdevwork.mackeypark.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ReturnEgaraAction extends ActionSupport{

	private String character;

	List<String> list = new ArrayList<>();

	public String execute() {

		System.out.println(character);

		list.add(character);

		return SUCCESS;
	}

	public String getCharacter() {
		return character;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
}