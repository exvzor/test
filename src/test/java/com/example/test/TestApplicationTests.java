package com.example.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {
	@InjectMocks
	TestApplication testApplication;
	@Test
	void contextLoads() {
		testApplication.sum();
		Assertions.assertTrue(true);
	}

}
