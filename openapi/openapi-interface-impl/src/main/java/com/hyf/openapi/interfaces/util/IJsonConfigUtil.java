package com.hyf.openapi.interfaces.util;

import java.sql.Timestamp;
import java.util.Date;

import net.sf.json.JsonConfig;

public class IJsonConfigUtil
{
	/**单实例*/
	public static JsonConfig config = new JsonConfig();
	/**
	 * 对JSONObject对象处理数据的时间JsonConfig对象
	 * @author 黄永丰
	 * @createtime 2016年1月29日
	 * @return JsonConfig对象
	 */
	public static JsonConfig getInstance()
	{
		config.registerJsonValueProcessor(Date.class,new DateJsonValueProcessorUtil("yyyy-MM-dd HH:mm:ss"));
		config.registerJsonValueProcessor(java.sql.Date.class,new DateJsonValueProcessorUtil("yyyy-MM-dd HH:mm:ss"));
		config.registerJsonValueProcessor(Timestamp.class,new DateJsonValueProcessorUtil("yyyy-MM-dd HH:mm:ss"));
		return config;
	}
	
}
