package com.cqupt.mis.rms.action.college;

import java.io.InputStream;
import java.util.List;


import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.service.GetDownloadInfoService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
/**
 * <p>Title:实现下载的action</p>
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:重邮信管工作室 </p>
 * @author HHY
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class DownloadAction extends ActionSupport
{
	//实例化下载的类 得到一个对象
	private GetDownloadInfoService getDownloadInfoService;
    private String fileUrl;
    private String fileType;
    private String fileShowName;
	
	
	public String getFileType() {
		return fileType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileShowName() {
		return fileShowName;
	}

	public void setFileShowName(String fileShowName) {
		this.fileShowName = fileShowName;
	}


	//上传的旁证材料的id
	private String proofId;
	
	private String inputPath;

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	public String getProofId() {
		return proofId;
	}

    public void setProofId(String proofId) {
		this.proofId = proofId;
	}

    public GetDownloadInfoService getGetDownloadInfoService() {
		return getDownloadInfoService;
	}

	public void setGetDownloadInfoService(
			GetDownloadInfoService getDownloadInfoService) {
		this.getDownloadInfoService = getDownloadInfoService;
	}

    public InputStream getInputStream() throws Exception{
		
    
		return ServletActionContext.getServletContext().getResourceAsStream(fileUrl);
	}
    
    public String execute() throws Exception{
    	
		@SuppressWarnings("unchecked")
		List<Proofs> proofslist = (List<Proofs>) getDownloadInfoService.getExcelDownloadInfoByFactor("Proofs", "proofId", proofId);
		 Proofs proofs = null;
		 for(int i=0;i<proofslist.size();i++){
			  proofs = proofslist.get(i);
			    String fileName = proofs.getUploadRealName();
			    String file = proofs.getProofPath();
			    if(file!=null){
			    	 fileUrl ="/"+ file+"/"+fileName;
			    }
			    else{
			    	fileUrl = fileName;
			    }
				 fileType = proofs.getUploadContentType();
				 fileShowName = proofs.getUploadProofName();
		 }
		return SUCCESS;
	}
	
    

}