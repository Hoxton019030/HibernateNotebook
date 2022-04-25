
STEP1 在SQL Server裡建立SQL表格

STEP2 在Eclipse裡建立相關的Bean物件

STEP3 到hibernate.cfg.xml註冊對應關係，例如<mapping resource="tw/jerry/hibernate/model/CompanyBean.hbm.xml"/>，然後再編寫相對應的xxx.hbm.xml
	(1)編寫相對應的xxx.hbm.xml (與Persistent Class放置在相同目錄)(較老專案)
//*****************************************************************************
	<?xml version="1.0" encoding="UTF-8"?>
	

	<hibernate-mapping>
    	<class name="tw.hibernatedemo.model.CompanyBean(對應之Java物件)" table="company(對應之表格)">
	<!-- 	ID的設定方式 -->
	        <id name="companyId(對應之欄位)" type="java.lang.Integer(Hibernate對應之型別)">
        	    <column name="companyID(表格內欄位名稱)" />
            	<generator class="assigned(給予ID的方式)" />
	        </id>
	<!-- 		其他屬性的設定方式 -->
        	<property name="companyName(Java物件內一般屬性名稱)" type="java.lang.String(Hibernate對應型別)">
           	 <column name="companyNAME(表格內欄位名稱)" sql-type="nvarchar(50)" />
        	</property>
	    </class>
	</hibernate-mapping>
//*****************************************************************************

這樣hibernate啟動時，會先去讀取hibernate.cfg.xml，並通過<mapping>去檢查JAVA物件之間的對應關係


	(2)利用Annotaion，直接定義在JAVA裡
 		寫在JavaBean裡面
		必須要有無參建構子
		
	(3)利用JPA，直接定義在JAVA裡(推薦使用) 可以參考 tw.hibernatedemo.model.department
		@Entity:宣告在JavaClass上方，註明此類別是PersistentClass，且有對應Table
		@Table(name="資料表名稱"):宣告在JavaClass上方，註明此PersitsteantClass對應資料庫內的Table名稱(資料表名稱建議全小寫)
		@Id:宣告在屬性(FieldAccess)，註明此屬性對應的PRIMARY KEY欄位
			@GeneratedValue(stragegy=GenerationType.IDENTIY):設定對應PRIMARY KEY欄位屬性的資料產生方式
		@Column(name="欄位名稱"):宣告在屬性或getter方法，註明此對應的欄位名稱
		@Transient:要求hibernate不對應Table欄位，因為hibernate本身會自動將屬性對應到Table欄位

 
	EX:
	@Entity
	@Table(name="the_table")
	public class SomeTabel{
		@Id
		@Column(namae="table_id")
		@GeneratedValue(stragegy=GenerationType.IDENTIY)
		private Integer sometalbeid;
	.
	.
	.}

	設定完後別忘了到hibernate.cfg.xml內設定
	<hibernate-configuration>
	<session_factory>
	.
	.
	.
	<mapping class ="...model.yourClassName"/>
	.
	.
	.
	<session-factory>
	<hibernate-configuration/>


Step4 程式裡這樣撰寫
	StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	SesssionFactory factory =new MetadataSource(serviceRegistry).buildMetadata().buildSessionFactory();



