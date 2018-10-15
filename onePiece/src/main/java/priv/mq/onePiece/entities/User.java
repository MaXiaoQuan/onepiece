package priv.mq.onePiece.entities;

import java.util.Date;

public class User {

	private Integer userId;
	private String userName;
	private String realName;
	private String password;
	private boolean gender;
	private Integer age;
	private String phone;
	private Date birthday;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public User() {
	}
	public User(String userName, String realName, String password, boolean gender, Integer age, String phone,
			Date birthday) {
		super();
		this.userName = userName;
		this.realName = realName;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", realName=" + realName + ", password=" + password
				+ ", gender=" + gender + ", age=" + age + ", phone=" + phone + ", birthday=" + birthday + "]";
	}
	
}
