package com.edc.tp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import com.edc.tp.book.User;

import org.junit.Test;

public class UserTest {
	
	User benoit = new User("Benoît", "Cavrois", 42, "42", "bCavrois");

	@Test
	public void testUser() {
		assertThat(benoit.getName(), equalTo("Benoît"));
		assertThat(benoit.getSurname(), equalTo("Cavrois"));
		assertThat(benoit.getAge(), equalTo(42));
		assertThat(benoit.getID(), equalTo("42"));
		assertThat(benoit.getUsername(), equalTo("bCavrois"));
	}

}
