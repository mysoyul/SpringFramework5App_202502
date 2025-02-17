package myspring.di.xml.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

//XML을 대신해서 설정 역할을 하는 클래스입니다.(전략1 어노테이션을 선언하지 않은 클래스에 대한 설정)
@Configuration
@PropertySource(value = "classpath:values.properties")
public class HelloConfig {
	@Autowired
	Environment env;
	
	@Bean
	public Printer stringPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	public Printer consolePrinter() {
		return new ConsolePrinter();
	}
	
	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		//myName1=스프링
		hello.setName(env.getProperty("myName1"));
		hello.setPrinter(stringPrinter());
		return hello;
	}
	
}
