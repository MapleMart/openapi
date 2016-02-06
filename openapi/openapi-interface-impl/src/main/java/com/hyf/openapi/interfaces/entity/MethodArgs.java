package com.hyf.openapi.interfaces.entity;

public class MethodArgs
{
	/**类名称*/
	private String className;
	/**类的方法名称*/
	private String methodName;
	/**类的方法的传入参数*/
	private String methodData;

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public String getMethodName()
	{
		return methodName;
	}

	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}

	public String getMethodData()
	{
		return methodData;
	}

	public void setMethodData(String methodData)
	{
		this.methodData = methodData;
	}

	@Override
	public String toString()
	{
		return "MethodArgs [className=" + className + ", methodName=" + methodName + ", methodData=" + methodData + "]";
	}

}
