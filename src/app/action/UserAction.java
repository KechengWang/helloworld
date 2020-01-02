package app.action;

import java.io.IOException;

public interface UserAction {
  void findAllUser() throws IOException;
  
  void findUserById() throws IOException;
  
  void loginValidate() throws IOException;
}

