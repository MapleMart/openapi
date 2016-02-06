package com.hyf.openapi.interfaces.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hyf.openapi.interfaces.ApiInterface;
import com.hyf.openapi.interfaces.entity.MethodArgs;
import com.hyf.openapi.interfaces.entity.ResultStruct;
import com.hyf.openapi.interfaces.exception.ILog;
import com.hyf.openapi.interfaces.global.GlobalContainer;
import com.hyf.openapi.interfaces.util.CheckJSONDataUtil;
import com.hyf.openapi.interfaces.util.DataValidatorUtil;
import com.hyf.openapi.interfaces.util.MethodArgsUtil;
import com.hyf.openapi.interfaces.util.MethodReflectUtil;

public class ApiInterfaceImpl implements ApiInterface,ILog
{

	@Autowired
	DataValidatorUtil dataValidatorUtil;

	/**
	 * 通过doPost调用 base服务的接口(api工具用)
	 * @param postdata 客户端传入的map集合数据
	 * @return 调用接口后返回的数据
	 * @throws Exception 
	 */
	@Override
	public String doPost(String postdata)
	{
		try
		{
			// 1、获取方法名称、服务名称、参数 数据的对象
			Map<String,Object> dataMap = CheckJSONDataUtil.checkJSONData(postdata);
			MethodArgs methodargs = MethodArgsUtil.checkPostMethodData(dataMap);
			// 2、获取传入调用接口方法参数的数据
			String validData = methodargs.getMethodData();
			// 3、获取传入调用接口的类名称
			String className = methodargs.getClassName();
			// 4、获取传入调用接口方法名称
			String methodName = methodargs.getMethodName();
			// 5、获取调用类对象
			Object classObject = GlobalContainer.getApplicationContext().getBean(className);
			// 6、数据校验
			String paramsData = dataValidatorUtil.getValidData(classObject,methodName,validData);
			// 7、调用接口方法
			String result = String.valueOf(MethodReflectUtil.invokeMethod(classObject,methodName,new Object[]{paramsData/**调用方法参数多少个这里数组就是多少个长度数组*/}));
			return result;
		}
		catch (Exception e)
		{
			log.error(e.getMessage());
			return new ResultStruct(-1,"调用doPost方法处理异常."+e.getMessage()).toString();
		}
	}
	

}
