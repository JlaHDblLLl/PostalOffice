package by.grsu.lancevich.postaloffice;

import java.sql.Timestamp;

import by.grsu.lancevich.postaloffice.db.model.Address;
import by.grsu.lancevich.postaloffice.db.model.Item;
import by.grsu.lancevich.postaloffice.db.model.Parcel;
import by.grsu.lancevich.postaloffice.db.model.Person;

public class Main {

	public static void main(String[] args) {
		Address address = new Address();
		address.setId(1);
		address.setCountry("Belarus");
		address.setTown("Grodno");
		address.setStreet("Kabyak street");
		address.setHouse("35");
		System.out.println(address.toString());

		Person person = new Person();
		person.setId(1);
		person.setAddress_id(1);
		person.setName("Maxim");
		person.setCreated(new Timestamp(100));
		System.out.println(person.toString());

		Parcel parcel = new Parcel();
		parcel.setId(1);
		parcel.setAddress_from_id(1);
		parcel.setAddress_to_id(1);
		parcel.setSender_id(1);
		parcel.setReceiver_id(1);
		System.out.println(parcel.toString());

		Item item = new Item();
		item.setId(1);
		item.setParcel_id(1);
		item.setFragile(true);

		System.out.println(item.toString());

	}

}
