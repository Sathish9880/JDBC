package com.xwork.model;

public class Employee {
	    private String name;
	    private String email;
	    private String address;
	    private String telephone;
	    private String skill;
	    
	    public Employee() {}
	    
		public Employee(String name, String email, String address, String telephone, String skill) {
			this.name = name;
			this.email = email;
			this.address = address;
			this.telephone = telephone;
			this.skill = skill;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getSkill() {
			return skill;
		}
		public void setSkill(String skill) {
			this.skill = skill;
		}
		@Override
		public String toString() {
			return "Employee [name=" + name + ", email=" + email + ", address=" + address + ", telephone=" + telephone
					+ ", skill=" + skill + "]";
		}
	    
	    
}
