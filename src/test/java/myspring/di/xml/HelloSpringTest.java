package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_hello.xml")
public class HelloSpringTest {
	@Autowired
	private Hello hello;
	
	@Autowired @Qualifier("hello")
	private Hello hello1;
	
	@Resource(name = "helloC")
	private Hello hello2;
	
	@Test
	void helloBean() {
		System.out.println(hello.sayHello());  //Hello 스프링
		System.out.println(hello1.sayHello()); //Hello 스프링
		System.out.println(hello2.sayHello()); //Hello 생성자
		assertEquals("Hello 생성자", hello2.sayHello());
		
		hello2.print();
		
		//Anonymous Inner Class
		hello2.getNames() //List => Iterable
			.forEach(new Consumer<String>() {
				@Override
				public void accept(String name) {
					System.out.println(name);					
				}
			});
		//Lambda Expression
		hello2.getNames()
			.forEach(name -> System.out.println(name));
		//Method Reference
		hello2.getNames()
			.forEach(System.out::println);
	}
	
}
