package com.example.covid_19.api.responseRs;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseRs {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private List<DataItem> data;

	public int getStatusCode(){
		return statusCode;
	}

	public List<DataItem> getData(){
		return data;
	}
}