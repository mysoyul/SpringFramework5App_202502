package myspring.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import myspring.user.dao.UserDao;
import myspring.user.vo.UserVO;

@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {
//	@Autowired
	UserDao userdao;

	//Constructor Injection
	public UserServiceImpl(UserDao userdao) {
		System.out.println("////Service 레이어 = " + this.getClass().getName() + " 생성자 호출됨!!");
		this.userdao = userdao;
	}

	@Override
	public void insertUser(UserVO user) {
		userdao.insert(user);
	}

	public List<UserVO> getUserList() {
		return userdao.readAll();
	}

	@Override
	public void deleteUser(String id) {
		userdao.delete(id);
		
	}

	@Override
	public UserVO getUser(String id) {
		return userdao.read(id);
	}

	@Override
	public void updateUser(UserVO user) {
		userdao.update(user);
	}
}
