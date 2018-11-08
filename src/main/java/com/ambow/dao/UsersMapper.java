package com.ambow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ambow.javabean.Users;

public interface UsersMapper {
	int insertUsers(Users users);
	int updateUsers(Users users);
	int deleteUsers(int users_id);
	Users findUsersById(int users_id);
	Users findUsersByNoPswd(@Param("users")Users users);
	Users findUsersByNo(@Param("users")Users users);
	Users findUsersByPhone(@Param("users")Users users);
	Users findUsersByPhoneOnly(@Param("users")Users users);
	List<Users> findAllUsers();
	List<Users> findAllUsersByPage(@Param("users")Users users);
	int findAllUsersByCnt(@Param("users")Users users);
}
