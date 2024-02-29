package lab02_20240227.prog1;

public class Customer {


	private String firstName; 
	private String lastName; 
	private String socialSecurityNum;
	private Address billingAddress;
	private Address shippingAddress;
	
	public Customer(
			String firstName, 
			String lastName, 
			String socialSecurityNum
			) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNum = socialSecurityNum;
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

	public String getSocialSecurityNum() {
		return socialSecurityNum;
	}

	public void setSocialSecurityNum(String socialSecurityNum) {
		this.socialSecurityNum = socialSecurityNum;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	@Override
	public String toString() {
		return "["+firstName+", "+lastName+", ssn: "+socialSecurityNum+"]";
	}
	

}
