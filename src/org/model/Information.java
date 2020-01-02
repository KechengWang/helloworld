package org.model;

import java.io.Serializable;

public class Information implements Serializable {

	private Integer informationId;
	private String informationContent;
	  
	  public Information(String informationContent, String informationImage, String informationCreateTime) {
	    this.informationContent = informationContent;
	    this.informationImage = informationImage;
	    this.informationCreateTime = informationCreateTime;
	  } private String informationImage; private String informationCreateTime;
	  public Information() {}
	  public Integer getInformationId() { return this.informationId; }

	  
	  public void setInformationId(Integer informationId) { this.informationId = informationId; }

	  
	  public String getInformationContent() { return this.informationContent; }

	  
	  public void setInformationContent(String informationContent) { this.informationContent = informationContent; }

	  
	  public String getInformationImage() { return this.informationImage; }

	  
	  public void setInformationImage(String informationImage) { this.informationImage = informationImage; }

	  
	  public String getInformationCreateTime() { return this.informationCreateTime; }

	  
	  public void setInformationCreateTime(String informationCreateTime) { this.informationCreateTime = informationCreateTime; }
}
