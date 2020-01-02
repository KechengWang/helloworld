package org.dao;

import java.util.List;
import org.model.Information;

public interface InformationDao {
  void addInformation(Information paramInformation);
  
  List<Information> findAllInformation();
  
  Information findInformationById(int paramInt);
}


