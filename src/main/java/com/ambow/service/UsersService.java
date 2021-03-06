package com.ambow.service;

import java.util.List;

import com.ambow.javabean.Users;

public interface UsersService {
	public int insertUsers(Users users);
	public int updateUsers(Users users);
	public int deleteUsers(int users_id);
	public Users findUsersById(int users_id);
	public Users findUsersByNoPswd(Users users);
	public Users findUsersByNo(Users users);
	public Users findUsersByPhone(Users users);
	public Users findUsersByPhoneOnly(Users users);
	public List<Users> findAllUsers();
	public List<Users> findAllUsersByPage(Users users);
	public int findAllUsersByCnt(Users users);
}
