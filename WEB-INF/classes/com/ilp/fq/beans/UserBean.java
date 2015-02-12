package com.ilp.fq.beans;

//Bean class for user registrations
public class UserBean {
        private String name;
        private String gender;
        private String dob;
        private String mailId;
        private int age;
        private String licencestatus;
       	private String ssn;
        private String occupation;
        private int annualIncome;
        private String education;
        private String uname;
        private String pwd;
        
        public String getSsn() {
			return ssn;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
        public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			dob=dob.substring(0, 10);
			this.dob = dob;
		}
		public String getMailId() {
			return mailId;
		}
		public void setMailId(String mailId) {
			this.mailId = mailId;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getLicenceStatus() {
			return licencestatus;
		}
		public void setLicenceStatus(String licencestatus) {
			this.licencestatus = licencestatus;
		}
		
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public int getAnnualIncome() {
			return annualIncome;
		}
		public void setAnnualIncome(int annualIncome) {
			this.annualIncome = annualIncome;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education = education;
		}
        
}