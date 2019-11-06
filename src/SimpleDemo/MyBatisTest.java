package SimpleDemo;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import SimpleDemo.bean.Dept;
import SimpleDemo.bean.Emp;
import SimpleDemo.bean.Emp_Dept;
import SimpleDemo.bean.Student;
import SimpleDemo.dao.DeptMapper;
import SimpleDemo.dao.EmpDynamicMapper;
import SimpleDemo.dao.EmpMapper;

public class MyBatisTest {

	public static void main(String[] args) {
		
		new MyBatisTest().test();
		//new MyBatisTest().test3();
	}
	
	/*
	 * https://www.jianshu.com/p/06b73e8d9f56
	 * 
	 * 1. 导包：
	  		log4j-1.2.17.jar
			mybatis-3.5.2.jar
			ojdbc5.jar ..X(在mybatis-3.5.2.jar 下不能使用)
			
	 * 2. 从 XML 配置文件或一个预先定制的 Configuration 的实例构建出 SqlSessionFactory 的实例:
	 * 		mybatis-config.xml
	 * 
	 * 3. 配置映射文件 配置每一个sql 以及sql封装的规则
	 * 		EmpMapper.xml
	 * 		将映射文件保存到配置文件中
	 * 
	 * 4. 代码实现
	 * 		1). 加载mybatis-config.xml配置文件 获取SqlSessionFactory 对象
	 * 		2). 获取 SqlSession 对象 ，执行已经映射的 sql 语句
	 * 				一个SqlSession就代表和数据库的一次会话，用完关闭
	 * 		3). 使用sql唯一标识来告诉mybstis执行哪个sql，sql都保存在配置文件中
	 * 
	 * 注意：
	 * 		Mybatis 报错 java.io.IOException: Could not find resource mybatis-config.xml
	 * 			配置文件没有加载上，mybatis-config.xml中的配置文件没有加载上，
	 * 			配置文件放在了文件夹中没有被eclipse默认加载，所以报错。
  				如果是这样的原因最简单的解决方案就是将mybatis-config.xml从文件夹中转移到src中，这样eclipse会默认加载。
  				或者将此文件夹bulid path
  				
  			Mybatis 报错 Method oracle/jdbc/driver/OracleResultSetImpl.isClosed()Z is abstract
  				出现上面这个错误是因为使用数据库驱动不正确。
  				选中项目，alt+enter，java build path，更换ojdbc版本。
  				>>ojdbc8.jar


	 *
	 * 1. 加载xml配置文件 获取SqlSessionFactory 对象
	 * 2. 获取 SqlSession 对象 ，执行已经映射的 sql 语句
	 * 3. 获取mapper对象 (代理对象mapperproxy)
	 * 4. 执行增删改查
	 * 
	 * 		四大对象是指：executor,statementHandler,parameterHandler，resultHandler对象。
	 * 
	 * */
	public void test() {
		
		SqlSession openSession =null;
		try {
			//加载xml配置文件 获取SqlSessionFactory 对象
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			//获取 SqlSession 对象 ，执行已经映射的 sql 语句
			openSession = sqlSessionFactory.openSession();//openSession(boolean autoCommit);是否自动提交 默认false
			
			/*
			 * Parameters:
			 *		sql 的唯一标识(statement)
			 * 			statement Unique identifier matching the statement to use.
			 * 		执行sql要用的参数）(Object)
			 * 			parameter A parameter object to pass to the statement.
			 * Returns:
			 * 		Mapped object
			 * 
			 * */
	
			/*
			 *  第一种方法和使用完全限定名调用 Java 对象的方法类似 ，之前版本较少使用
			 * */
//			Emp emp = (Emp)openSession.selectOne("org.mybatis.example.EmpMapper.selectEmp",5);
//			System.out.println(emp);
			
			
			/*
			 * 第二种方法有很多优势，
			 * 			首先它不依赖于字符串字面值，会更安全一点； 
			 * 			其次，如果你的 IDE 有代码补全功能，那么代码补全可以帮你快速选择已映射的 SQL 语句。
			 * 
			 * 			该命名就可以直接映射到在命名空间中同名的 Mapper 类，
			 * 			并将已映射的 select 语句中的名字、参数和返回类型匹配成方法。
			 * 
			 * 会为接口自动创建一个代理对象(mapper)，代理对象执行增删改查,实现dao层的分离
			 *	org.apache.ibatis.binding.MapperProxy@71423665
			 * 
			 */
			EmpMapper mapper = openSession.getMapper(EmpMapper.class);
			System.out.println(mapper);
			Emp emp = mapper.getEmpById(5);
			System.out.println(emp);
			
			System.out.println("-----");
			
			Emp empByIdAndlastName = mapper.getEmpByIdAndlastName(2 , "Ngao");
			System.out.println(empByIdAndlastName);
			
			System.out.println("getEmpByIdAndlastName...");
			
			
			
			/*
			 * MyBatis 允许增删改 定义以下返回值
			 * 
			 * 		boolean Long Integer

			 			public void/ boolean/ Long /Integer addEmp(Emp emp);
						public void updateEmp(Emp emp);
						public void deleteEmpById(Integer id);
			 * 
			 * */
			
			//添加一条数据 ，默认需要提交事务
//			Emp empAdd = new Emp(new BigDecimal(52),"addEmpLast",null,new BigDecimal(3000),new Date(2142141243L));
//			mapper.addEmp(empAdd);
//			openSession.commit();
//			System.out.println("insert...");
			
			//修改一条数据
			Emp empUp = new Emp(new BigDecimal(30),"addEmpLast_Up","addEmpFirst",new BigDecimal(3000),new Date(2142141243L));
			mapper.updateEmp(empUp);
			openSession.commit();
			System.out.println("update...");
			
			//删除一条数据
			mapper.deleteEmpById(32);
			openSession.commit();
			System.out.println("delete...");
			
			//使用自增主键插入一条数据
			Student stu = new Student(0,"mb_seqAd","12345",10,"f");
			mapper.addStu(stu);
			openSession.commit();
			System.out.println("insertSeq...");
			
			//返回集合list
			List<Emp> list = mapper.getEmpBytitle("Stock Clerk");
			list.forEach(System.out::println);
			openSession.commit();
			System.out.println("select by List...");
			
			//
			Map<String,Object> map = mapper.getEmpByMap(12);
			Set<Entry<String, Object>> set = map.entrySet();
			for (Entry<String, Object> entry : set) {
				System.out.println(entry.getKey()+" : "+ entry.getValue());
			}
			openSession.commit();
			System.out.println("select by Map...");
			
			Map<Integer, Emp> idMap = mapper.getEmpByTitleMap("Stock Clerk");
			Set<Entry<Integer, Emp>> entrySet = idMap.entrySet();
			for (Entry<Integer, Emp> entry : entrySet) {
				System.out.println(entry.getKey()+" : "+ entry.getValue());
			}
			openSession.commit();
			System.out.println("select by id-Map...");
			
			Emp_Dept emp_Dept = mapper.getEmpDeptById(12);
			System.out.println(emp_Dept);
			openSession.commit();
			System.out.println("select Emp_Dept...");
			
			Emp_Dept empDeptStep = mapper.getEmpDeptByIdStep(12);
			System.out.println(empDeptStep);
			openSession.commit();
			System.out.println("select Emp_DeptStep...");
			
			Emp_Dept empDeptStep2 = mapper.getEmpDeptByIdStep(12);
			System.out.println(empDeptStep2.getLastname());
			System.out.println("select Emp_DeptStepLazy1...");
			System.out.println(empDeptStep2.getDept());
			System.out.println("select Emp_DeptStepLazy2...");
			
			
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(openSession!=null) 
				openSession.close();
		}
	}
	
	public void test2() {
		
		SqlSession openSession =null;
		
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			//获取 SqlSession 对象 ，执行已经映射的 sql 语句
			openSession = sqlSessionFactory.openSession();//openSession(boolean autoCommit);是否自动提交 默认false
			
			DeptMapper mapper = openSession.getMapper(DeptMapper.class);
			
			Dept dept = mapper.getDeptByIdPlus(45);
			System.out.println(dept);
			dept.getEmps().forEach(System.out::println);
			System.out.println("getDeptByIdPlus...");
			
			Dept deptStep = mapper.getDeptByIdStep(45);
			System.out.println(deptStep);
			deptStep.getEmps().forEach(System.out::println);
			System.out.println("getDeptByIdStep...");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(openSession!=null) 
				openSession.close();
		}

	}
	
	@Test
	public void test3() {
		SqlSession openSession =null;
		
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			//获取 SqlSession 对象 ，执行已经映射的 sql 语句
			openSession = sqlSessionFactory.openSession();//openSession(boolean autoCommit);是否自动提交 默认false
			EmpDynamicMapper mapper = openSession.getMapper(EmpDynamicMapper.class);
			
			Emp emp = new Emp(new BigDecimal(36),"%m%",null,new BigDecimal(3000),null);
			
			List<Emp> list = mapper.getEmpByConditionIf(emp);
			list.forEach(System.out::println);
			
			//查询时如果没有某些条件，如上没有id，会使sql拼装有问题 ...where and ...
			
			List<Emp> trim = mapper.getEmpByConditionTrim(emp);
			trim.forEach(System.out::println);
			
			List<Emp> choose = mapper.getEmpByConditionChoose(emp);
			choose.forEach(System.out::println);
			
			/*
			 * 记录：
			 * 在测试set语句时，由于在pl/sql 中对id=50执行了set语句
			 * 但却没有commit 提交事务
			 * 所以在mybatis中执行此set语句时，程序一直在等待中，不能对此数据进行set操作
			 * 要等待另一连接做提交事务后，才会立即执行此set操作。
			 * 
			 * 类似情况：
			 * 开发的时候debug到一条update的sql语句时程序就不动了，
			 * 然后我就在plsql上试了一下，发现plsql一直在显示正在执行，等了好久也不出结果。
			 * 但是奇怪的是执行其他的select语句却是可以执行的。
			 * 
			 * 这种只有update无法执行其他语句可以执行的其实是因为记录锁导致的，
			 * 在oracle中，执行了update或者insert语句后，都会要求commit，
			 * 如果不commit却强制关闭连接，oracle就会将这条提交的记录锁住。
			 * 由于我的java程序中加了事务，之前debug到一半的时候我强制把工程终止了，
			 * 这样就导致没有执行事务提交，
			 * 所以oracle将代码中update那一条的记录锁了。
			 * 
			 * 可通过下面两步解决：
			 * 1.首先查询锁定记录
			 * 2.删除锁记录
			 * */
			Emp empset = new Emp(new BigDecimal(50),"setL","setF",new BigDecimal(3000),null);
			int i = mapper.getEmpByConditionSet(empset);
			System.out.println("===========");
			openSession.commit();
			
			Emp empsetT = new Emp(new BigDecimal(51),"setTL","setTF",new BigDecimal(2000),null);
			mapper.getEmpByConditionSet_Trim(empsetT);
			System.out.println("===========");
			openSession.commit();
			
			List<Emp> foreach = mapper.getEmpByConditionForeach(Arrays.asList(1,2,3));
			foreach.forEach(System.out::println);
			
//			ArrayList<Emp> emps = new ArrayList<Emp>();
//			emps.add(new Emp(new BigDecimal(53),"foreach_batchSaveL","foreach_batchSaveLF",new BigDecimal(2000),null));
//			emps.add(new Emp(new BigDecimal(54),"foreach_batchSaveL","foreach_batchSaveLF",new BigDecimal(2000),null));
//			emps.add(new Emp(new BigDecimal(55),"foreach_batchSaveL","foreach_batchSaveLF",new BigDecimal(2000),null));
//			mapper.addEmps(emps);
//			System.out.println("===========");
//			openSession.commit();
			
			Emp empbind = new Emp(new BigDecimal(36),"m",null,new BigDecimal(3000),null);
			List<Emp> innerDatabase = mapper.getEmpInnerparameter(empbind);
			innerDatabase.forEach(System.out::println);
			
			List<Emp> empSQL = mapper.getEmpSQL();
			empSQL.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(openSession!=null)
				openSession.close();
		}
		

	}
	
}

/*
 * 总结：
 * 		接口式编程
 * 			Dao    ===> DaoImpl			[原生]
 * 			Mapper ===> xxMapper.xml	[MyBatis]
 * 		
 * 		1. SqlSession就代表和数据库的一次会话，用完需要关闭
 * 		2. SqlSession 和Connection一样是非线程安全的，每次使用够应该获取新的对象。
 * 		3. Mapper接口没有实现类，但是MyBatis会为接口生成一个代理对象。将接口与xml绑定
 * 		4. 两个重要配置文件
 * 			MyBatis全局配置文件
 * 				数据库连接池信息
 * 				事物管理器信息...
 * 			sql映射文件
 * 				每一个sql语句的映射信息[将sql抽取出来]
 * 
 * */
