package org.dao;

import java.util.List;
import org.model.User;

public interface UserDao {
  List<User> findAllUser();
  
  User findUserById(int paramInt);
  
  User loginValidate(String paramString1, String paramString2);
}


