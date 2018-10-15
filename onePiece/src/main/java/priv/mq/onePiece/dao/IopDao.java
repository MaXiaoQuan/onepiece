package priv.mq.onePiece.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IopDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.openSession();
	}
	
	/**
	 * @author MaQuan
	 * @time 2017年9月23日 下午2:46:33
	 * @description : 通过传入的泛型参数类将该类对象保存到数据库中。
	 */
	public void save(T t) {
		Session session = getSession();
		session.save(t);
		session.close();
	}
	
	/**
	 * @author MaQuan
	 * @time 2017年9月23日 下午2:49:57
	 * @description : 根据一条hql语句查询出该类对象。
	 */
	@SuppressWarnings("unchecked")
	public List<T> queryObjectByHQL(String hql) {
		Session session = getSession();
		Query<T> query = session.createQuery(hql);
		List<T> resultList = query.list();
		session.close();
		return resultList;
	}
	
	/**
	 * @author MaQuan
	 * @time 2017年9月23日 下午2:50:56
	 * @description : 根据某一实体类的一个字段及该字段的值查询出该对象。
	 */
	@SuppressWarnings("unchecked")
	public List<T> queryObjectByOneField(String fieldKey, String fieldValue, Class<T> c){
		Session session = getSession();
		String hql = "FROM " + c.getSimpleName() + " where " + fieldKey + " = '" + fieldValue + "'";
		Query<T> query = session.createQuery(hql);
		List<T> resultList = query.list();
		session.close();
		return resultList;
	}

}
