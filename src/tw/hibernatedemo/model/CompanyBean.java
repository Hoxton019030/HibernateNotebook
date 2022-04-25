package tw.hibernatedemo.model;

public class CompanyBean {
	
	/*SQL語法
	 * CREATE DATABASE hibernateDB
	 * USE hibernateDB
	 * 
	 * CREATE TABLE company(
	 * companyId INT PRIMARY KEY NOT NULL,
	 * companyName nvarchar(50) NOT NULL,
	 * )
	 * 
	 */
	private int companyId;
	private String companyName;

	public CompanyBean() {
	}

	public CompanyBean(int companyId, String companyName) {
		this.companyId = companyId;
		this.companyName = companyName;
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
