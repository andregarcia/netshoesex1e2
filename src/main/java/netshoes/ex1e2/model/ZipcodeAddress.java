package netshoes.ex1e2.model;

public class ZipcodeAddress {

	
	private String zipcode;
	private String street;
	private String district;
	private String city;
	private String state;
	
	
	
	public ZipcodeAddress(String zipcode, String street, String district,
			String city, String state) {
		super();
		this.zipcode = zipcode;
		this.street = street;
		this.district = district;
		this.city = city;
		this.state = state;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
}
