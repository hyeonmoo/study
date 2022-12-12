package org.greenart.kang;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private String id, pw, name, email;
	@DateTimeFormat(pattern="yyyy-MM-dd") //해당 형식으로 받음, 날짜형식변환(2)
	private LocalDate birth;
	private String[] sns, hobby;
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public LocalDate getBirth() {return birth;}
	public void setBirth(LocalDate birth) {this.birth = birth;}
	public String[] getSns() {return sns;}
	public void setSns(String[] sns) {this.sns = sns;}
	public String[] getHobby() {return hobby;}
	public void setHobby(String[] hobby) {this.hobby = hobby;}
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", birth=" + birth + ", sns="
				+ Arrays.toString(sns) + ", hobby=" + Arrays.toString(hobby) + "]";
	}
	
//	@InitBinder //날짜 형식 변환(3)
//	public void dateBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(LocalDate.class, "birth",new PropertyEditorSupport() {
//			@Override
//			public void setAsText(String text) throws IllegalArgumentException{
//				setValue(LocalDate.parse(text));
//			}
//		});
//	}
}
