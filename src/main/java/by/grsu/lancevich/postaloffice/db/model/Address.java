package by.grsu.lancevich.postaloffice.db.model;

public class Address {
	private Integer id;
	private String country;
	private String town;
	private String street;
	private String house;
	private String flat;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getFlat() {
		return flat;
	}
	public void setFlat(String flat) {
		this.flat = flat;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", town=" + town + ", street=" + street + ", house="
				+ house + ", flat=" + flat + "]";
	}

}
