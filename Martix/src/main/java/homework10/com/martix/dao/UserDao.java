package homework10.com.martix.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ironxi.entity.User;
import com.ironxi.util.MybatisUtil;

public class UserDao {
	/**search*/
	public User getById(int id) throws IOException{
		SqlSession session = MybatisUtil.getSession();
		User user = session.selectOne("com.ironxi.entity.UserMapper.selectUser",id);
		session.close();//可以写到fuilter(开始关闭)；
		return user;
	}
	/**search all
	 * @throws IOException */
	public List<User> getAll() throws IOException{
		SqlSession session = MybatisUtil.getSession();
		List<User> list= session.selectList("com.ironxi.entity.UserMapper.selectAllUser");
		session.close();
		return list;
	}
	/**add*/
	public int add(User user) throws IOException{
		SqlSession session = MybatisUtil.getSession();
		int result=session.insert("com.ironxi.entity.UserMapper.addUser",user);
		session.commit();
		session.close();
		return result;
	}
	/**update*/
	public int update(User user) throws IOException{
		SqlSession session = MybatisUtil.getSession();
		int result=session.update("com.ironxi.entity.UserMapper.updateUser",user);
		session.commit();
		session.close();
		return result;
	}
	/**delete*/
	public int deleteUser(int id) throws IOException{
		SqlSession session = MybatisUtil.getSession();
		int result=session.delete("com.ironxi.entity.UserMapper.deleteUser",id);
		session.commit();
		session.close();
		return result;
	}
}
