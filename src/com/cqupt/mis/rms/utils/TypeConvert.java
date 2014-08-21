package com.cqupt.mis.rms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
/**
 * <p>
 * Title:类型转换工具类
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
public class TypeConvert {
	
	//Date类型转换成String类型
	public static String dateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(date);
		return s;
	}
	//boolean类型转换成String类型
	public static String booleanToString(boolean b,String str,String str2){
		return !b?str:str2;			
	}
	//String类型转换成boolean类型
	public static boolean stringToBoolean(String str,String str1){
		return str.equals(str1)?false:true;			
	}
	//将以分号分隔的字符串转换成字符数组
	public static String[] StringToStringArray(String s){
		String str[] = s.split(";");
		return str;
	}
	//将以逗号分隔的字符串转换成字符数组
	public static String[] StringToStringArrayByComma(String s){
		String str[] = s.split(",");
		return str;
	}
	//将毫秒转换成日期
	public static String ObjectToString(Object object){
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		String str = sdf.format(object);
		return str;
	}
	//将字符串数组转换成指定的字符串类型
	public static String objectArrayToString(int[] object){
		StringBuffer sb = new StringBuffer();
		if(object.length>0){
			for(Object obj : object){
				sb.append("'").append(obj).append("'").append(",");
			}
		}
		String s = sb.toString().substring(0, sb.lastIndexOf(","));
		return s;
	}
	
	public static String objectArrayStringToString(String[] object){
		StringBuffer sb = new StringBuffer();
		if(object.length>0){
			for(Object obj : object){
				sb.append("'").append(obj).append("'").append(",");
			}
		}
		String s = sb.toString().substring(0, sb.lastIndexOf(","));
		return s;
	}
	
	//String类型或者null转换成Date类型
	public static Date stringOrNullToDate(String s){
		if("".equals(s)){
			return null;
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			try {
				date = sdf.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}
	}
	
	//判断字符是否为int型
	public static boolean StringIsInt(String str){
		  
		Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();   
	}
	
	   
	//判断字符是否为浮点型
    public static boolean StringisFloatPointNumber(String number){  
        number=number.trim();  
        String pointPrefix="(\\-|\\+){0,1}\\d*\\.\\d+";//浮点数的正则表达式-小数点在中间与前面  
        String pointSuffix="(\\-|\\+){0,1}\\d+\\.";//浮点数的正则表达式-小数点在后面  
        if(number.matches(pointPrefix)||number.matches(pointSuffix))  
            return true;  
        else  
            return false;  
    } 
    
  
    
  //转换字符是Date类型的字符串
    public static Date StringtoDate(String Date){  
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
		  Date toDate = null;
		  int x=0;
	    	 for(int i=0;i<=Date.length()-1;i++) {  
	              String getstr=Date.substring(i,i+1);  
	              if(getstr.equals(".")){  
	                  x++;  
	              }  
	          } 
	    	 
	    	 if(x==2){
	    		 try {
					toDate = simpleDateFormat.parse(Date);
				} catch (ParseException e) {
					return null;
				}
	    	 }
	    	 else if(x==1){
	    		 Date = Date + ".01"; 
	    		 try {
					toDate = simpleDateFormat.parse(Date);
				} catch (ParseException e) {
					return null;
				}
	    	 }
	    	 else if(x==0){
	    		 Date = Date + ".01.01"; 
	    		 try {
					toDate = simpleDateFormat.parse(Date);
				} catch (ParseException e) {
					return null;
				}
	    	 }
	    	
	        return toDate;
	   }
    
    public static ArrayList<String> getNames(String names){
		ArrayList<String> name=new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(names,",;、:：， ");
        while(st.hasMoreTokens())
        	name.add(st.nextToken());
        return name;
	}

}
