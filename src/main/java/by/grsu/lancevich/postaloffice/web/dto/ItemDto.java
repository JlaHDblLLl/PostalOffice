package by.grsu.lancevich.postaloffice.web.dto;

import java.sql.Timestamp;

public class ItemDto {
	private Integer id;
	private Integer parcel_id;
	private String parcel_name;
	private Double weight;
	private Double length;
	private Double width;
	private Double height;
	private Boolean fragile;
	private Timestamp expiration_date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParcel_id() {
		return parcel_id;
	}
	public void setParcel_id(Integer parcel_id) {
		this.parcel_id = parcel_id;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Boolean getFragile() {
		return fragile;
	}
	public void setFragile(Boolean fragile) {
		this.fragile = fragile;
	}
	public Timestamp getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(Timestamp expiration_date) {
		this.expiration_date = expiration_date;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", parcel_name=" + parcel_name + ", weight=" + weight + ", length=" + length + ", width="
				+ width + ", height=" + height + ", fragile=" + fragile + ", expiration_date=" + expiration_date + "]";
	}
	public String getParcel_name() {
		return parcel_name;
	}
	public void setParcel_name(String parcel_name) {
		this.parcel_name = parcel_name;
	}
}
