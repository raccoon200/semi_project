package com.dleague.member.model.vo;

import java.sql.Date;

public class Member {
   String userId;   
   String password; 
   String userName; 
   String regioncode; 
   String phone; 
   String email; 
   String birthday;
   String teamname; 
   String profile; 
   String grade; 
   String photo; 
   Date enrolldate;
   int rnum;
   
   public Member() {
      
   }
//sas
   public Member(String userId, String password, String userName, String regioncode, String phone, String email,
         String birthday, String teamname, String profile, String grade, String photo, Date enrolldate) {
      super();
      this.userId = userId;
      this.password = password;
      this.userName = userName;
      this.regioncode = regioncode;
      this.phone = phone;
      this.email = email;
      this.birthday = birthday;
      this.teamname = teamname;
      this.profile = profile;
      this.grade = grade;
      this.photo = photo;
      this.enrolldate = enrolldate;
   }
   
   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getRegioncode() {
      return regioncode;
   }

   public void setRegioncode(String regioncode) {
      this.regioncode = regioncode;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getBirthday() {
	   return birthday;
   }

   public void setBirthday(String birthday) {
      this.birthday = birthday;
   }

   public String getTeamname() {
      return teamname;
   }

   public void setTeamname(String teamname) {
      this.teamname = teamname;
   }

   public String getProfile() {
      return profile;
   }

   public void setProfile(String profile) {
      this.profile = profile;
   }

   public String getGrade() {
      return grade;
   }

   public void setGrade(String grade) {
      this.grade = grade;
   }

   public String getPhoto() {
      return photo;
   }

   public void setPhoto(String photo) {
      this.photo = photo;
   }

   public Date getEnrolldate() {
      return enrolldate;
   }

   public void setEnrolldate(Date enrolldate) {
      this.enrolldate = enrolldate;
   }

	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
@Override
public String toString() {
	return "[userId=" + userId + ", password=" + password + ", userName=" + userName + ", regioncode="
			+ regioncode + ", phone=" + phone + ", email=" + email + ", birthday=" + birthday + ", teamname=" + teamname
			+ ", profile=" + profile + ", grade=" + grade + ", photo=" + photo + ", enrolldate=" + enrolldate
			+ ", rnum=" + rnum + "]";
}

   
}