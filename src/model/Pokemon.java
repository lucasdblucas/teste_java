package model;

import java.util.ArrayList;

public class Pokemon {
	private int id;
	private String num;
	private String name;
	private ArrayList<String> type;
	private ArrayList<String> pre_evolution;
	private ArrayList<String> next_evolution;
	
	
	public Pokemon () {
		this.type = new ArrayList<String>();
		this.pre_evolution = new ArrayList<String>();
		this.next_evolution = new ArrayList<String>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public String getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList getType() {
		return type;
	}

	public void setType(ArrayList type) {
		this.type = type;
	}

	public ArrayList getPre_evolution() {
		return pre_evolution;
	}

	public void setPre_evolution(ArrayList pre_evolution) {
		this.pre_evolution = pre_evolution;
	}

	public ArrayList getNext_evolution() {
		return next_evolution;
	}

	public void setNext_evolution(ArrayList next_evolution) {
		this.next_evolution = next_evolution;
	}
	
	
}
