package kourpa;
public class User {
	String username;
	String password;
	String firstName;
	String lastName;
	String sex;
	String email;
	String phoneNumber;
	String birthDate;
	String interest1;
	String interest2;
	String interest3;
	public User() {}
	public User(String u, String p, String f, String l, String s, String e, String ph, String b, String i1, String i2, String i3) {
		this.username = u;
		this.password = p;
		this.firstName = f;
		this.lastName = l;
		this.sex = s;
		this.email = e;
		this.phoneNumber = ph;
		this.birthDate = b;
		this.interest1 = i1;
		this.interest2 = i2;
		this.interest3 = i3;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getInterest1() {
		return interest1;
	}
	public void setInterest1(String interest1) {
		this.interest1 = interest1;
	}
	public String getInterest2() {
		return interest2;
	}
	public void setInterest2(String interest2) {
		this.interest2 = interest2;
	}
	public String getInterest3() {
		return interest3;
	}
	public void setInterest3(String interest3) {
		this.interest3 = interest3;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
}
