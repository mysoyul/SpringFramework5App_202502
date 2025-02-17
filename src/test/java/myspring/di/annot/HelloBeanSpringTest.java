package myspring.di.annot;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_hello.xml")
public class HelloBeanSpringTest {
	
	@Autowired
	HelloBean hello;
	
	@Autowired
	PrinterBean stringPrinter;
	
	@Autowired
	HelloBeanCons helloCons;
	
	@Test
	void helloCons() {
		//Hello 전략2생성자
		System.out.println(helloCons.sayHello());
	}
	
	
	@Test @Disabled
	void hello() {
		System.out.println(hello.sayHello());
		hello.print();
		System.out.println(stringPrinter.toString());
	}
	

}
