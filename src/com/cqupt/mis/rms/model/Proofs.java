package com.cqupt.mis.rms.model;

import java.util.Date;

public class Proofs {
	private int proofId;
	private String infoApprovedId;
	private Date timeProofUpload;
	private String descProof;
	private String proofPath; //文件所在的最终路径
	private String uploadProofName; //上传的旁证材料名称
	private String uploadRealName; //保存的旁证材料的真实名称
	private String uploadContentType; //文件类型
	public int getProofId() {
		return proofId;
	}
	public void setProofId(int proofId) {
		this.proofId = proofId;
	}
	public String getInfoApprovedId() {
		return infoApprovedId;
	}
	public void setInfoApprovedId(String infoApprovedId) {
		this.infoApprovedId = infoApprovedId;
	}
	public Date getTimeProofUpload() {
		return timeProofUpload;
	}
	public void setTimeProofUpload(Date timeProofUpload) {
		this.timeProofUpload = timeProofUpload;
	}
	public String getDescProof() {
		return descProof;
	}
	public void setDescProof(String descProof) {
		this.descProof = descProof;
	}
	public String getProofPath() {
		return proofPath;
	}
	public void setProofPath(String proofPath) {
		this.proofPath = proofPath;
	}
	public String getUploadProofName() {
		return uploadProofName;
	}
	public void setUploadProofName(String uploadProofName) {
		this.uploadProofName = uploadProofName;
	}
	public String getUploadRealName() {
		return uploadRealName;
	}
	public void setUploadRealName(String uploadRealName) {
		this.uploadRealName = uploadRealName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

}
