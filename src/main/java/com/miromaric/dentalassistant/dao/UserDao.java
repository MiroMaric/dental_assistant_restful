package com.miromaric.dentalassistant.dao;

import com.miromaric.dentalassistant.model.User;
import java.util.List;

/**
 *
 * @author MikoPC
 */
public interface UserDao {
    
    boolean save(User user);
    List<User> getAll();
    User getOne(String username);
    User update(User user);
    User remove(String username);

}
