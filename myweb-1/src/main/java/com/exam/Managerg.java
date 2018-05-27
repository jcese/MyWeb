package com.exam;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Managerg {
	@NotEmpty(message="名字: 不能为空")     
	private String name;
	@NotEmpty(message="密码: 不能为空")  
	private String pass;
    @Size(max = 11, message="备注: 长度不能超过11个字符") 
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Managerg [name=" + name + ", pass=" + pass + ", phone=" + phone + "]";
	}
	
	
}
