package priv.mq.onePiece.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.mq.onePiece.dao.IopDao;
import priv.mq.onePiece.entities.User;

@Service
public class UserService {

	@Autowired
	private IopDao<User> iopDao;
	
	public void save(User user){
		iopDao.save(user);
	}
	
	/**
	 * @author MaQuan
	 * @time 2017年9月25日 下午8:38:28
	 * @description : 用户登录业务逻辑，根据用户名或手机号从数据库中查询出该对象，若存在，则比较密码是否匹配，若匹配，则返回true，若不匹配，则返回false。
	 */
	public Map<String, Object> userLogin(Map<String, String> paramMap){
		
		Map<String, Object> resultMap = new HashMap<>();
		List<User> resultList = null;
		if(paramMap.containsKey("phone")){
			resultList = iopDao.queryObjectByOneField("phone", paramMap.get("phone"), User.class);
		}else{
			//查询条件的字符串为字母或数字时，单引号可加可不加，但查询条件的字符串为汉字时，如“墨宝宝”时，必须要加上单引号:''。
			resultList = iopDao.queryObjectByOneField("userName", paramMap.get("userName"), User.class);
		}
		
		if(resultList == null || resultList.isEmpty()){
			resultMap.put("errcode", -1);
			resultMap.put("errmsg", "该用户不存在！");
			return resultMap;
		}else{
			User user = resultList.get(0);
			if(!user.getPassword().equals(paramMap.get("password"))){
				resultMap.put("errcode", -2);
				resultMap.put("errmsg", "密码错误！");
				return resultMap;
			}else{
				resultMap.put("errcode", 0);
				resultMap.put("errmsg", "登陆成功！");
				resultMap.put("user", user);
			}
		}
		return resultMap;
	}

}
