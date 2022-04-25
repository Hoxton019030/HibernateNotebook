
STEP1 在SQL Server裡建立SQL表格

STEP2 在Eclipse裡建立相關的Bean物件

STEP3 到hibernate.cfg.xml註冊對應關係，例如<mapping resource="tw/jerry/hibernate/model/CompanyBean.hbm.xml"/>，然後再編寫相對應的xxx.hbm.xml
	(1)編寫相對應的xxx.hbm.xml (與Persistent Class放置在相同目錄)(較老專案)

*****************************************************************************
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
*****************************************************************************

這樣hibernate啟動時，會先去讀取hibernate.cfg.xml，並通過<mapping>去檢查JAVA物件之間的對應關係


	(2)利用Annotaion，直接定義在JAVA裡
 		寫在JavaBean裡面
		必須要有無參建構子
		
	(3)利用JPA，直接定義在JAVA裡(推薦使用) ※可以參考 tw.hibernatedemo.model.department
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
	EX:<mapping class="tw.hibernatedemo.model.Department" />
	.
	.
	.
	<session-factory>
	<hibernate-configuration/>


Step4 程式裡這樣撰寫
	StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	SesssionFactory factory =new MetadataSource(serviceRegistry).buildMetadata().buildSessionFactory();




*****************************************************************************

SesssionFactory功能　 ※參考tw.hibernatedemo.util.HibernateUtil

	-封裝了Hibernate的執行環境
	-【1】個資料庫對應【1】個hibernate.cfg.xml設定檔
		【1】個hibernate.cfg.xml設定檔對應【1】個SesssionFactory物件
	-重量級物件，非常耗資源
	-通常會建一個Factory來控管它
【openSession()】
	-openSession()方法每次執行時都會得到一個全新的Session物件
		-不需要任何組態檔就可以使用openSession()方法 
		-會有兩次截然不同的連線，有可能會出錯，所以應該要用session.getCurrentSession()
【session.getCurrentSession()】
	-session.getCurrentSession()方法會開啟一個全新的session物件，然後此session物件會綁定在hibernate控管的環境中
		接下來每次執行getCurrentSession()會得到同一個session物件，由於交易都需要在同一個Session，因此當程式的交易橫跨多個DAO時，一定要用這個方法來取得session物件
	-當程式執行commit()或rollback()方法讓交易結束後，會自動關閉session物件
	-hibernate.cfg.xml內必須設置
		<property name="current_session_context_class">thread</property>
		否則程式會丟出 No CurrentSessionContext configured的錯誤訊息



*****************************************************************************
Transcation物件
	-是Hibernate提供的資料庫交易介面，裡面覆蓋了不同廠商資料庫間的交易機制(Dialact)
	-對多個表格的CRUD都一定要在同一個session
	-Transcation交易的建立方式 ※參考 tw.hibernatedemo.action.DemoDepartmentActionEx5 
		透過session啟用transcation
		(1).Transcation tx = session.beginTranscation();
		透過session物件取得現存的Transctaion物件
		(2).Transcation tx = session.getTransaction();
		透過Transcation物件結束transcation
		(3).tx.commit();
		    tx.rollback();
	
<h1>永續類別之物件的生命週期</h1>
<button>123</button>
	 
![image](https://user-images.githubusercontent.com/98711945/165159111-b73023a7-0fa5-45a3-9006-bd4246eea661.png)

	


