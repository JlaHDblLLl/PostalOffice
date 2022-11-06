package by.grsu.lancevich.postaloffice.db.model;


import java.sql.Timestamp;

public class Parcel {
	private Integer id;
	private Integer receiver_id;
	private Integer sender_id;
	private Timestamp date_send;
	private Timestamp date_accept;
	private Boolean fragile;
	private Double length;
	private Double width;
	private Double height;
	private Double weight;
	private Timestamp expiration_date;
	private Integer address_from_id;
	private Integer address_to_id;
	private Timestamp created;
	private Timestamp updated;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(Integer receiver_id) {
		this.receiver_id = receiver_id;
	}
	public Integer getSender_id() {
		return sender_id;
	}
	public void setSender_id(Integer sender_id) {
		this.sender_id = sender_id;
	}
	public Timestamp getDate_send() {
		return date_send;
	}
	public void setDate_send(Timestamp date_send) {
		this.date_send = date_send;
	}
	public Timestamp getDate_accept() {
		return date_accept;
	}
	public void setDate_accept(Timestamp date_accept) {
		this.date_accept = date_accept;
	}
	public Boolean getFragile() {
		return fragile;
	}
	public void setFragile(Boolean fragile) {
		this.fragile = fragile;
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
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Timestamp getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(Timestamp expiration_date) {
		this.expiration_date = expiration_date;
	}
	public Integer getAddress_from_id() {
		return address_from_id;
	}
	public void setAddress_from_id(Integer address_from_id) {
		this.address_from_id = address_from_id;
	}
	public Integer getAddress_to_id() {
		return address_to_id;
	}
	public void setAddress_to_id(Integer address_to_id) {
		this.address_to_id = address_to_id;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "Parcel [id=" + id + ", receiver_id=" + receiver_id + ", sender_id=" + sender_id + ", date_send="
				+ date_send + ", date_accept=" + date_accept + ", fragile=" + fragile + ", length=" + length
				+ ", width=" + width + ", height=" + height + ", weight=" + weight + ", expiration_date="
				+ expiration_date + ", address_from_id=" + address_from_id + ", address_to_id=" + address_to_id
				+ ", created=" + created + ", updated=" + updated + "]";
	}
}
