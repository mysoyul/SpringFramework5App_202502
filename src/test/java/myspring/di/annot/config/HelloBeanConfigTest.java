package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.HelloBean;
import myspring.di.annot.HelloBeanCons;

/*
 * Container 역할을 클래스
 * XML방식 - GenericXmlApplicationContext
 * Configuration방식 - AnnotationConfigApplicationContext
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class,
loader = AnnotationConfigContextLoader.class)
public class HelloBeanConfigTest {
	@Autowired
	HelloBean hello;
	
	@Autowired
	HelloBeanCons helloCons;
	
	@Test
	void helloConfig() {
		System.out.println(hello.sayHello());
		System.out.println(helloCons.sayHello());
	}
}
