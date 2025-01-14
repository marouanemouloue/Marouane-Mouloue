package com.ensa.gi4.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.gi4.datatabase.api.UsersDao;
import com.ensa.gi4.modele.Users;
import com.ensa.gi4.service.api.Encodage;
import com.ensa.gi4.service.api.GestionUsersService;

@Component("usersService")
public class GestionUsersServiceImpl implements GestionUsersService {
    @Autowired
    UsersDao usersDao;
    
    @Autowired
    private Encodage passwordEncoder;

	
	@Override
	public Users verifierUtilsateur(String u, String p) {
		List<Users> listUsers = new ArrayList<Users>();
				listUsers = usersDao.listUsers();
		for (Users user : listUsers) {
			if(user.getUsername().equals(u) && user.getPassword().equals(p)) {
				return user;
			}
		}
		return null;
		// TODO Auto-generated method stub
	}
	@Override
	public List<Users> listUsers() {
		// TODO Auto-generated method stub
		return usersDao.listUsers();
	}
	@Override
	public Users inscrire(String username, String password) {
		// TODO Auto-generated method stub
		Users u = new Users();
		u.setUsername(username);
		u.setPassword(passwordEncoder.encoder().encode(password));
		return u;
	}

}
