package com.cqupt.mis.rms.utils;
 
/**
 * <p>
 * Title:字符串处理类
 * </p>
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:重邮信管工作室
 * </p>
 * 
 * @author LM
 * @version 1.0
 * */
public class DoString {
	/** 将字符串转换为GBK编码*/
	public static String toGBK(String strvalue) {
		try {
			if (strvalue == null) {										//当变量strvalue为null时
				strvalue="";											//将变量strvalue赋值为空
			} else {
				strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK");	//将字符串转换为GBK编码(Chinese)
				strvalue = strvalue.trim();								//去除字符串的首尾空格
			}
		} catch (Exception e) {
			strvalue="";												//将变量strvalue赋值为空
		}
		return strvalue;												//返回转换后的输入变量strvalue
	}
	
	/**把null转化为""*/
	public static String nulltoEmptyString(String str)
	{
		if(str==null)str = "";
		if(str.equals("null"))str = "";
		str = str.trim();
		return str;
	}
	
	/**  处理字符串中的空值null或"",把空值转换为指定的toV字符串*/
	public static final String nulltoString(String v, String toV) {
	    if (v == null || "".equals(v)) {			//当输入变量v为空时
	        v = toV;						//将输入变量v赋值为输入变量toV
	    }
	    return v;							//返回转换后的输入变量v
	}
	
	/** 过滤危险字符（替换危险字符）*/
	public static final String filterStr(String str){
		str=str.replaceAll(";","");
		str=str.replaceAll("&","&amp;");
		str=str.replaceAll("<","&lt;");
		str=str.replaceAll(">","&gt;");
		str=str.replaceAll("'","");
		str=str.replaceAll("--"," ");
		str=str.replaceAll("/","");
		str=str.replaceAll("%","");
		return str;
	}

	/**转换成UTF8*/
	public static String toUtf8String(String src)
	{
		byte[] b = src.getBytes();
		char[] c = new char[b.length];
		for(int i=0;i<b.length;i++)
		{
			c[i] = (char)(b[i]&0x00FF);
		}
		return new String(c);
	}

	/**转换成ISO-8859-1*/
	public static String toISO8859(String str)
	{
		try 
		{
			if(str==null)
				str = "";
			else{ 
				byte c[]=str.getBytes("ISO-8859-1");
				str=new String(c);
			}
			
		}catch (Exception e) {
			System.out.println("DoString::toISO8859(String)运行时出错：错误为："+e);
			}
		return str;
	}
	
	/**转换成ASCII*/
	public static String toASCII(String str)
	{
		try 
		{
			if(str==null)
				str = "";
			else 
				str=new String(str.getBytes("GBK"),"ISO-8859-1"); 
		}catch (Exception e) {
			System.out.println("DoString::toASCII(String)运行时出错：错误为："+e);
			}
		return str;
	}

	/**替换字符串*/
	public static String Replace(String source, String oldString, String newString)
	{ 
       StringBuffer output = new StringBuffer(); 

       int lengthOfSource = source.length();   // 源字符串长度 
       int lengthOfOld = oldString.length();   // 老字符串长度 
       int posStart = 0;   // 开始搜索位置 
       int pos;            // 搜索到老字符串的位置 

       while ((pos = source.indexOf(oldString, posStart)) >= 0) { 
           output.append(source.substring(posStart, pos)); 
           output.append(newString); 
           posStart = pos + lengthOfOld; 
       } 
       if (posStart < lengthOfSource) { 
           output.append(source.substring(posStart)); 
       } 
       return output.toString(); 
	}

	/**替换字符串*/
	public static StringBuffer ReplaceStringBuffer(String source, String oldString, String newString)
	{ 
       StringBuffer output = new StringBuffer(); 

       int lengthOfSource = source.length();   // 源字符串长度 
       int lengthOfOld = oldString.length();   // 老字符串长度 
       int posStart = 0;   // 开始搜索位置 
       int pos;            // 搜索到老字符串的位置 

       while ((pos = source.indexOf(oldString, posStart)) >= 0) { 
           output.append(source.substring(posStart, pos)); 
           output.append(newString); 
           posStart = pos + lengthOfOld; 
       } 
       if (posStart < lengthOfSource) { 
           output.append(source.substring(posStart)); 
       } 
       return output; 
	}

	/**将字符串格式化为固定长度(左边补空格)*/
	public static String toLengthStrSpace(String instr,int len)
	{
		int n = instr.getBytes().length;
		for(int i=0;i<(len-n);i++)
		{
			instr = " "+instr;
		}
		return instr;
	}
	/**将字符串格式化为固定长度(右边补空格)*/
	public static String toLengthStrRightSpace(String instr,int len)
	{
		int n = instr.getBytes().length;
		for(int i=0;i<(len-n);i++)
		{
			instr = instr+" ";
		}
		return instr;
	}
	
	/**将字符串格式化为固定长度(左边补指定字符)*/
	public static String toLengthStrChar(String instr,int len,char c)
	{
		int n = instr.getBytes().length;
		for(int i=0;i<(len-n);i++)
		{
			instr = c+instr;
		}
		return instr;
	}
	
	/**将字符串格式化为固定长度(右边补指定字符)*/
	public static String toLengthStrRightChar(String instr,int len,char c)
	{
		int n = instr.getBytes().length;
		for(int i=0;i<(len-n);i++)
		{
			instr = instr+c;
		}
		return instr;
	}
	
	
	/**取得字符串字节长度*/
	public static int byteLength(String str)
	{
		return ((str.getBytes()).length);
	}

	/**取得字符串从头开始指定长度子串（字节长度）一个汉字两个字节*/	
	public static String strByteCopy(String str,int nEnd)
	{
		if(nEnd==0)
			return "";
		byte[] byteStr=str.getBytes();
		int k=byteStr.length;
		String strSub=new String(byteStr,0,nEnd<k?nEnd:k);
		if (strSub.length()==0) strSub=new String(byteStr,0,nEnd-1);
		return strSub;
	}
	
	/**字符串匹配*/		
    public static boolean strMatch(String motherStr,String childStr)
    {
      boolean matched=false;
      int mLength=motherStr.length();
      int cLength=childStr.length();
      int starWith;
      if(mLength>=cLength){
        starWith=mLength-cLength;
        for(int i=0;i<=starWith;i++){
          matched=motherStr.startsWith(childStr,i);
          if(matched)break;
        }
      }
      return matched;
    }
   
}
