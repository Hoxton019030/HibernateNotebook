package tw.hibernatedemo.model;

public class CompanyBean {

  	private int companyId;
	private String companyName;

	public CompanyBean() {
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	

}

/*
 * SQL語法 CREATE DATABASE hibernateDB USE hbiernateDB CREATE TABLE company(
 * companyId INT PRIMARY KEY NOT NULL, compantName NVARCHAR(50) NOT NULL,)
 */