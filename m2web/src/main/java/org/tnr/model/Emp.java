package org.tnr.model;

import java.util.Date;

public class Emp {
	
	private Integer e_id;
	private String e_name;
	private Double e_sal;
	private Date e_birth;
	
	public Integer getE_id() {
		return e_id;
	}
	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public Double getE_sal() {
		return e_sal;
	}
	public void setE_sal(Double e_sal) {
		this.e_sal = e_sal;
	}
	public Date getE_birth() {
		return e_birth;
	}
	public void setE_birth(Date e_birth) {
		this.e_birth = e_birth;
	}

	@Override
	public String toString() {
		return "Emp{" +
				"e_id=" + e_id +
				", e_name='" + e_name + '\'' +
				", e_sal=" + e_sal +
				", e_birth=" + e_birth +
				'}';
	}
}
