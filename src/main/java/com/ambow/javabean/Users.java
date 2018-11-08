package com.ambow.javabean;

public class Users extends Page{
	private int users_id;
	private String users_no;
	private String users_name;
	private String users_pswd;
	private Integer users_age;
	private String users_phone;
	private String users_cardid;
	private Integer users_state;
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getUsers_no() {
		return users_no;
	}
	public void setUsers_no(String users_no) {
		this.users_no = users_no;
	}
	public String getUsers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}
	public String getUsers_pswd() {
		return users_pswd;
	}
	public void setUsers_pswd(String users_pswd) {
		this.users_pswd = users_pswd;
	}
	public Integer getUsers_age() {
		return users_age;
	}
	public void setUsers_age(Integer users_age) {
		this.users_age = users_age;
	}
	public String getUsers_phone() {
		return users_phone;
	}
	public void setUsers_phone(String users_phone) {
		this.users_phone = users_phone;
	}
	public String getUsers_cardid() {
		return users_cardid;
	}
	public void setUsers_cardid(String users_cardid) {
		this.users_cardid = users_cardid;
	}
	@Override
	public String toString() {
		return "Users [users_id=" + users_id + ", users_no=" + users_no
				+ ", users_name=" + users_name + ", users_pswd=" + users_pswd
				+ ", users_age=" + users_age + ", users_phone=" + users_phone
				+ ", users_cardid=" + users_cardid+ ", users_state=" + users_state + "]";
	}
	public Users(String users_no, String users_name, String users_pswd,
			Integer users_age, String users_phone, String users_cardid,Integer users_state) {
		super();
		this.users_no = users_no;
		this.users_name = users_name;
		this.users_pswd = users_pswd;
		this.users_age = users_age;
		this.users_phone = users_phone;
		this.users_cardid = users_cardid;
		this.users_state = users_state;
	}
	public Users() {
		super();
	}
	public Integer getUsers_state() {
		return users_state;
	}
	public void setUsers_state(Integer users_state) {
		this.users_state = users_state;
	}
	
}
