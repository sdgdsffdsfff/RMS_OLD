package com.cqupt.mis.rms.utils.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class PurviewTag extends TagSupport {

	private String imagePath;

	private String url;

	private String name;
	
	private String id;
	
	private String simpleName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			if (getName().equals("删除")) {
				if(getId()!=null){
					out.print("<a href=\"#\" onclick=\"del('"+getUrl()+"');\"><img src=\""
							+ getImagePath() + "\"/>" + getName()
							+ "</a>");
				} else {
					out.print("<a href=\"" + getUrl() + "\" onclick=\"return confirm('你确认要删除所选记录吗?');\"><img src=\""
							+ getImagePath() + "\"/>" + getName()
							+ "</a>");
				}
			} else if (!getName().equals("删除")) {
				if(getId()!=null){
						out.print("<a href=\"#\" onclick=\"upd('"+getUrl()+"');\"><img src=\""
							+ getImagePath() + "\"/>" + getName()
							+ "</a>&nbsp;&nbsp;");
				} else {
					out.print("<a href=\"" + getUrl() + "\"><img src=\""
							+ getImagePath() + "\"/>" + getName()
							+ "</a>&nbsp;&nbsp;");
				}
			} else {
				out.print("");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
