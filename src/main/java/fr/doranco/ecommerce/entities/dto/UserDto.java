package fr.doranco.ecommerce.entities.dto;

public class UserDto {
	private String gender;
	private String firstName;
	private String lastName;
	private String dateNaissance;	
	private String email;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDto [gender=" + gender + ", firstName=" + firstName + ", lastName=" + lastName + ", dateNaissance="
				+ dateNaissance + ", email=" + email + "]";
	}
}
