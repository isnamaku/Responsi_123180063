package com.example.covid_19.api;

import com.example.covid_19.api.response.ResponseKasus;
import com.example.covid_19.api.responseRs.ResponseRs;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {
    @GET("rekapitulasi_v2/jabar/harian")
    Call<ResponseKasus> getResponse();

    @GET("sebaran_v2/jabar/faskes")
    Call<ResponseRs> getResponseRs();
}
