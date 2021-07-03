package com.example.covid_19.api.response;

import com.google.gson.annotations.SerializedName;

public class Metadata{

	@SerializedName("last_update")
	private Object lastUpdate;

	public void setLastUpdate(Object lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public Object getLastUpdate(){
		return lastUpdate;
	}
}