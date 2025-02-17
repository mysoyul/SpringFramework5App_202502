package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 * <context:component-scan base-package="myspring.di.annot" /> 
 *   => @ComponentScan
 * <context:property-placeholder location="classpath:values.properties" />
 *   => @PropertySource
 */
//XML을 대신해서 설정 역할을 하는 클래스입니다.(전략2 어노테이션을 선언한 클래스에 대한 설정)
@Configuration
@ComponentScan(basePackages = {"myspring.di.annot"})
@PropertySource(value = "classpath:values.properties")
public class HelloBeanConfig {
	
}
