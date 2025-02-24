package myspring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.vo.UserVO;

@Repository("userDao")
@Scope("singleton")
public class UserDaoImplMapper implements UserDao {
	//@Autowired
	private UserMapper userMapper;
	
	public UserDaoImplMapper(UserMapper userMapper) {
		System.out.println("////DataAccess 레이어 = " + this.getClass().getName() + " 생성자 호출됨!!");
		this.userMapper = userMapper;
	}

	@Override
	public UserVO read(String id) {
		UserVO user  = userMapper.selectUserById(id);
		return user;
	}
	
	public List<UserVO> readAll() {
		List<UserVO> userList = userMapper.selectUserList();
		return userList;
	}

	public void insert(UserVO user) {
		userMapper.insertUser(user);
		System.out.println("등록된 Record UserId=" + user.getUserId() + 
				" Name=" + user.getName());
	}

	@Override
	public void update(UserVO user) {
		userMapper.updateUser(user);
	}
	
	@Override
	public void delete(String id) {
		userMapper.deleteUser(id);
		System.out.println("삭제된 Record with ID = " + id ); 
	}
}










