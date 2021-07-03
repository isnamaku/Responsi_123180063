package com.example.covid_19.ui.rsRujukan;


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
import com.example.covid_19.api.ApiClient;
import com.example.covid_19.api.BaseApiService;
import com.example.covid_19.api.responseRs.DataItem;
import com.example.covid_19.api.responseRs.ResponseRs;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FragmentRS extends Fragment {

    private List<DataItem> rsData = new ArrayList<>();
    BaseApiService mApiService;
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RsAdapter rsAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rs, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Retrofit retrofit = ApiClient.getClient();
        mApiService = retrofit.create(BaseApiService.class);
        recyclerView = view.findViewById(R.id.rvRsRujukan);
        linearLayoutManager = new LinearLayoutManager(getContext());

        setRs();

    }

    private void setRs() {
        recyclerView = recyclerView.findViewById(R.id.rvRsRujukan);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        Toast toast = Toast.makeText(getContext(), "Mengambil data rs rujukan..", Toast.LENGTH_SHORT);
        toast.show();
        getRs();
    }

    private void getRs() {
        Call<ResponseRs> call = mApiService.getResponseRs();
        call.enqueue(new Callback<ResponseRs>() {
            @Override
            public void onResponse(Call<ResponseRs> call, Response<ResponseRs> response) {
                if (response.body() != null) {
                    List<DataItem> data = response.body().getData();
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(new RsAdapter(data, R.layout.fragment_rs, getContext()));
                }
            }

            @Override
            public void onFailure(Call<ResponseRs> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }


}










