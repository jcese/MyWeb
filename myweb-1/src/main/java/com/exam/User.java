package com.exam;



public class User {
	private String name,sex;
	private int arg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getArg() {
		return arg;
	}
	public void setArg(int arg) {
		this.arg = arg;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", sex=" + sex + ", arg=" + arg + "]";
	}
}
