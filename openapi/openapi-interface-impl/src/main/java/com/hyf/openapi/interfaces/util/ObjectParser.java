package com.hyf.openapi.interfaces.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectParser
{
	public static Date toDate(Object date) throws ParseException
	{
		if (date == null)
		{
			return null;
		}
		Date result = null;
		String str = date.toString();
		String parse = str;
		parse = parse.replaceFirst("^[0-9]{4}([^0-9])", "yyyy$1");
		parse = parse.replaceFirst("^[0-9]{2}([^0-9])", "yy$1");
		parse = parse.replaceFirst("([^0-9])[0-9]{1,2}([^0-9])", "$1MM$2");
		parse = parse.replaceFirst("([^0-9])[0-9]{1,2}( ?)", "$1dd$2");
		parse = parse.replaceFirst("( )[0-9]{1,2}([^0-9])", "$1HH$2");
		parse = parse.replaceFirst("([^0-9])[0-9]{1,2}([^0-9])", "$1mm$2");
		parse = parse.replaceFirst("([^0-9])[0-9]{1,2}([^0-9]?)", "$1ss$2");

		SimpleDateFormat format = new SimpleDateFormat(parse);

		result = format.parse(str);

		return result;
	}

	public static Integer toInteger(Object data)
	{
		if (data == null)
		{
			return null;
		}
		return Integer.valueOf(data.toString());
	}

	public static Long toLong(Object data)
	{
		if (data == null)
		{
			return null;
		}
		return Long.valueOf(data.toString());
	}

	public static Short toShort(Object data)
	{
		if (data == null)
		{
			return null;
		}
		return Short.valueOf(data.toString());
	}

	public static Double toDouble(Object data)
	{
		if (data == null)
		{
			return null;
		}
		return Double.valueOf(data.toString());
	}

	public static String toString(Object data)
	{
		if (data == null)
		{
			return null;
		}
		return String.valueOf(data.toString());
	}

	public static Boolean toBoolean(Object data)
	{
		if (data == null)
		{
			return null;
		}
		return Boolean.valueOf(data.toString());
	}

}
