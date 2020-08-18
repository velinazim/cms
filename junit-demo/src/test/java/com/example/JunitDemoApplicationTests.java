package com.example;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitDemoApplicationTests {

	@Before
	public void before(){
		System.out.println("Before");
	}

	@Test
	public void testcase1(){
		System.out.println("testcase 1");
	}

}
