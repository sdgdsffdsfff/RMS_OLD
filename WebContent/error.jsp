<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.json.simple.*" %>
<%
String url = (String)request.getAttribute("url")==null?"":(String)request.getAttribute("url");
String warning = (String)request.getAttribute("warning");

JSONObject json = new JSONObject();
json.put("url",url);
json.put("warning",warning);
out.print(json.toJSONString());
%>
<s:property value="alert"/>