package com.miromaric.dentalassistant.service.impl;

import com.miromaric.dentalassistant.dao.UserDao;
import com.miromaric.dentalassistant.dao.impl.UserDaoImpl;
import com.miromaric.dentalassistant.exception.ResourceAlreadyExistsException;
import com.miromaric.dentalassistant.exception.ResourceNotFoundException;
import com.miromaric.dentalassistant.model.User;
import com.miromaric.dentalassistant.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();

    @Override
    public void save(User user) {
        if(!dao.save(user)){
            throw new ResourceAlreadyExistsException("User with this username already exists");
        }
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public User getOne(String username) {
        User user = dao.getOne(username);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User update(String username,User user) {
        User uUser = dao.update(username,user);
        if(uUser==null)
            throw new ResourceNotFoundException("User not found");
        return uUser;
    }

    @Override
    public User remove(String username) {
        User user = dao.remove(username);
        if(user==null)
            throw new ResourceNotFoundException("User not found");
        return user;
    }

}
