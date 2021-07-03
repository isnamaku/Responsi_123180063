package com.example.covid_19.ui.kasusHarian;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.R;
import com.example.covid_19.api.response.ContentItem;
import com.example.covid_19.api.ApiClient;
import com.example.covid_19.api.BaseApiService;
import com.example.covid_19.api.response.ResponseKasus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FragmentKasus extends Fragment {

    private List<ContentItem> kasusHarianResult = new ArrayList<>();
    BaseApiService mApiService;
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    KasusHarianAdapter kasusHarianAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kasus, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Retrofit retrofit = ApiClient.getClient();
        mApiService = retrofit.create(BaseApiService.class);
        recyclerView = view.findViewById(R.id.rvKasusHarian);
        linearLayoutManager = new LinearLayoutManager(getContext());

        setKasusHarian();

    }

    private void setKasusHarian() {
        recyclerView = recyclerView.findViewById(R.id.rvKasusHarian);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        Toast toast = Toast.makeText(getContext(), "Mengambil data kasus harian..", Toast.LENGTH_SHORT);
        toast.show();
        getKasusHarian();
    }

    private void getKasusHarian() {
        Call<ResponseKasus> call = mApiService.getResponse();
        call.enqueue(new Callback<ResponseKasus>() {
            @Override
            public void onResponse(Call<ResponseKasus> call, Response<ResponseKasus> response) {
                if (response.body() != null) {
                        List<ContentItem> kasusHarian = response.body().getData().getContent();
                        recyclerView.setLayoutManager(linearLayoutManager);
                        Collections.reverse(kasusHarian);
                        recyclerView.setAdapter(new KasusHarianAdapter(kasusHarian, R.layout.fragment_kasus, getContext()));
                }
            }

            @Override
            public void onFailure(Call<ResponseKasus> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }


}










