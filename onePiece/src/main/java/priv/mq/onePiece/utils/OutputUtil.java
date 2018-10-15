package priv.mq.onePiece.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class OutputUtil {

	public static void outputJson(HttpServletResponse response, Object o){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		try {
			response.getWriter().write(JSON.toJSONString(o,SerializerFeature.DisableCircularReferenceDetect));
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
