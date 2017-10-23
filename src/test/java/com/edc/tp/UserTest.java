package com.edc.tp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import com.epsi.edc1.library.impl.User;

public class UserTest {
	
	User benoit = new User("Benoît", "Cavrois", 42, "bCavrois");

	@Test
	public void testUser() {
		assertThat(benoit.getName(), equalTo("Benoît"));
		assertThat(benoit.getSurname(), equalTo("Cavrois"));
		assertThat(benoit.getAge(), equalTo(42));
		assertThat(benoit.getUsername(), equalTo("bCavrois"));
	}

}
