package com.ambow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambow.dao.UsersMapper;
import com.ambow.javabean.Users;
@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;
	@Override
	public int insertUsers(Users users) {
		return usersMapper.insertUsers(users);
	}

	@Override
	public int updateUsers(Users users) {
		return usersMapper.updateUsers(users);
	}

	@Override
	public int deleteUsers(int users_id) {
		return usersMapper.deleteUsers(users_id);
	}

	@Override
	public Users findUsersById(int users_id) {
		return usersMapper.findUsersById(users_id);
	}

	@Override
	public List<Users> findAllUsers() {
		return usersMapper.findAllUsers();
	}

	@Override
	public Users findUsersByNoPswd(Users users) {
		return usersMapper.findUsersByNoPswd(users);
	}
	
	@Override
	public Users findUsersByNo(Users users) {
		return usersMapper.findUsersByNo(users);
	}

	@Override
	public Users findUsersByPhone(Users users) {
		return usersMapper.findUsersByPhone(users);
	}
	@Override
	public Users findUsersByPhoneOnly(Users users) {
		return usersMapper.findUsersByPhoneOnly(users);
	}

	@Override
	public List<Users> findAllUsersByPage(Users users) {
		users.setPageNow((users.getPageNow()-1)*users.getPageSize());
		return usersMapper.findAllUsersByPage(users);
	}

	@Override
	public int findAllUsersByCnt(Users users) {
		users.setPageNow((users.getPageNow()-1)*users.getPageSize());
		int cnt=usersMapper.findAllUsersByCnt(users);
		if(cnt%users.pageSize==0){
			return cnt / users.pageSize;
		}else{
			return cnt / users.pageSize+1;
		}
	}

}
