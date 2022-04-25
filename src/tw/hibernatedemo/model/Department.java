package tw.hibernatedemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //宣告在JavaClass上方，註明此類別是PersistentClass，且有對應Table
@Table(name="department") // 宣告在JavaClass上方，註明此PersitsteantClass對應資料庫內的Table名稱(資料表名稱建議全小寫)
public class Department {
	/*
	 * 
	 * CREATE TABLE department(
depid INT PRIMARY KEY IDENTITY(1,1),
deptname NVARCHAR(50) NOT NULL,
)
	 * 
	 * 
	 * 
	 */
	//必須要有空的建構子
	public Department() {
	}
	
	@Id //註明此屬性對應的PRIMARY KEY欄位
	@GeneratedValue(strategy = GenerationType.IDENTITY) //設定對應PRIMARY KEY欄位屬性的資料產生方式
	@Column(name="depid") //宣告在屬性或getter方法，註明此對應的欄位名稱
	private int depid;
	
	@Column(name="deptname")
	private String deptname;

	public Department(String deptname) {
		this.deptname = deptname;
	}

	public int getDepid() {
		return depid;
	}

	public void setDepid(int depid) {
		this.depid = depid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	
	
	
	

}
