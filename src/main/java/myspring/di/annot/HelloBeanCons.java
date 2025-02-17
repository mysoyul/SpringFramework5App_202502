package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * 전략2 어노테이션 + XML설정 혼용
 * Constructor Injection
 */

@Component //helloBean
public class HelloBeanCons {
	String name;
	
	PrinterBean printer;
	
	List<String> names;
 
	@Autowired
	public HelloBeanCons(@Value("${myNameCons}") String name, 
			             @Qualifier("stringPrinter") PrinterBean printer) {
		System.out.println(this.getClass().getName() + " 오버로딩 생성자 호출됨!");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
