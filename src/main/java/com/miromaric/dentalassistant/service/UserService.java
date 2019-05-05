package com.miromaric.dentalassistant.service;

import com.miromaric.dentalassistant.model.User;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface UserService {
    
    void save(User user);
    List<User> getAll();
    User getOne(String username);
    User update(User user);
    User remove(String username);
    
}
