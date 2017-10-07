package com.xiang.registration.action;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		UserAction ua = new UserAction();
		ua.setUsername("f");
		ua.setPassword("f");
		String ret = ua.execute();
		assertEquals("success", ret);
	}

}
