package app.action;

import java.io.IOException;

public interface InformationAction {
  void findAllInformation() throws IOException;
  
  void findInformationById() throws IOException;
  
  void showInformationByIdFromWebPortol() throws IOException;
  
  void showInformationByIdFromAppPortol() throws IOException;
}

