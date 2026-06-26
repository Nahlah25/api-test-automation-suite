
	package com.domain.erp.qa.pojo.request;

	public class UpdateUserRequest {

	    public UpdateUserRequest(String city, String country, String email, String firstName, String gender,
				String lastName, String password, int phone, String state, String zoneId) {
			super();
			this.city = city;
			this.country = country;
			this.email = email;
			this.firstName = firstName;
			this.gender = gender;
			this.lastName = lastName;
			this.password = password;
			this.phone = phone;
			this.state = state;
			this.zoneId = zoneId;
		}



		private String city;
	    private String country;
	    private String email;
	    private String firstName;
	    private String gender;
	    private String lastName;
	    private String password;
	    private int phone;
	    private String state;
	    private String zoneId;

	    // ---------------- GETTERS & SETTERS ----------------

	    public String getCity() {
	        return city;
	    }

	   

	    public String getCountry() {
	        return country;
	    }

	   

	    public String getEmail() {
	        return email;
	    }

	   

	    public String getFirstName() {
	        return firstName;
	    }


	    public String getGender() {
	        return gender;
	    }

	   

	    public String getLastName() {
	        return lastName;
	    }

	    

	    public String getPassword() {
	        return password;
	    }

	    

	    public int getPhone() {
	        return phone;
	    }

	    

	    public String getState() {
	        return state;
	    }

	    

	    public String getZoneId() {
	        return zoneId;
	    }

	    
	}

