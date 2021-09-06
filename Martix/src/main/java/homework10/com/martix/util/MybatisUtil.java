package homework10.com.martix.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	/**SqlSessionFactory
	 * 通过配置文件创建SqlSessionFactory，是一个SqlSession工厂类*/
	public static SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis.conf.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	/**SqlSession
	 * 通过id找到对应的sql语句并执行它*/
	public static SqlSession getSession() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		return sqlSessionFactory.openSession();
	}
}
