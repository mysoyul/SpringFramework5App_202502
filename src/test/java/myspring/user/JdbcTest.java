package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.dao.UserDao;
import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_beans.xml")
public class JdbcTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession session;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	@Test
	void userSvc() {
		UserVO user = userService.getUser("dooly");
		System.out.println(user);
	}
	
	@Test @Disabled
	void userDao() {
		UserVO user = userDao.read("dooly");
		System.out.println(user);				
	}
	
	@Test @Disabled
	void userMapper() {
		UserVO user = userMapper.selectUserById("dooly");
		System.out.println(user);
	}
	
	
	@Test @Disabled
	void mybatis() {
		System.out.println(sessionFactory.getClass().getName());
		UserVO user = session.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);		
	}
	
	@Test @Disabled
	void conn() throws Exception{
		Connection connection = dataSource.getConnection();
		DatabaseMetaData metaData = connection.getMetaData();
		System.out.println(metaData.getURL());
		System.out.println(metaData.getUserName());
		System.out.println(metaData.getDatabaseProductName());
	}
	

}
