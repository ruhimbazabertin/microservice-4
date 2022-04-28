package com.micro.departmentservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class DepartmentServiceApplicationTests {
	Calculator underTest = new Calculator();
	@Test
	void itShouldAddTwoNumbers() {
		//Given
		int numberone=10;
		int numbertwo=20;

		//when
		int result = underTest.add(numberone, numbertwo);

		//then
		int expected = 30;
		assertThat(result).isEqualTo(expected);
	}
	class Calculator{
		int add(int a, int b){
			return a + b;
		}
	}
}
