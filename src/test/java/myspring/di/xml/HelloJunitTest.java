package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloJunitTest {
	ApplicationContext context;
	
	@BeforeEach
	void init() {
		//1. Container 객체생성
		context = new GenericXmlApplicationContext("classpath:spring_hello.xml");		
	}
	
	@Test
	void hello() {
		//2. Hello 스프링Bean을 요청하기
		Hello hello = (Hello)context.getBean("hello");
		Hello hello2 = context.getBean("hello", Hello.class);
		
		System.out.println(hello == hello2);
		//Reference 비교
		assertSame(hello, hello2);
		//assertNotSame(hello, hello2);
		
		//3. setName() Injection 확인하기
		//값 비교
		assertEquals("Hello 스프링", hello.sayHello());
		//4. setPrinter() Injection 확인하기
		hello.print();
		
		//5. StringPrinter 스프링Bean을 호출하기
		Printer printer = context.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
	}
}
