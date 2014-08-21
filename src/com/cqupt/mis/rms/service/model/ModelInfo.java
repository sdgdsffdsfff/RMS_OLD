package com.cqupt.mis.rms.service.model;

import java.util.List;

public class ModelInfo<T1, T2> {
	private T1 model;
	private List<T2> modelList;

	public T1 getModel() {
		return model;
	}

	public void setModel(T1 model) {
		this.model = model;
	}

	public List<T2> getModelList() {
		return modelList;
	}

	public void setModelList(List<T2> modelList) {
		this.modelList = modelList;
	}
}
