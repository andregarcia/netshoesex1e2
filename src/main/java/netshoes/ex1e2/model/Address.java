package netshoes.ex1e2.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9212981895888190034L;
	
	
	private Integer id;
	
	//required fields
	@NotEmpty
	private String street;
	
	@NotEmpty
	private String number;
	
	@NotEmpty
	private String zipcode;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state;
	
	//optional fields
	private String district;
	private String complement;
	
	public Address(){
		
	}
	
	//constructor with required fields
	public Address(Integer id, String street, String number, String zipcode,
			String city, String state) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
	}


	//constructor with all fields
	public Address(Integer id, String street, String number, String zipcode,
			String city, String state, String district, String complement) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.district = district;
		this.complement = complement;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", number="
				+ number + ", zipcode=" + zipcode + ", city=" + city
				+ ", state=" + state + ", district=" + district
				+ ", complement=" + complement + "]";
	}
	
	
	
	
}
