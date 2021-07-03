package com.example.covid_19.ui.kasusHarian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.R;
import com.example.covid_19.api.response.ContentItem;

import java.util.List;


public class KasusHarianAdapter extends RecyclerView.Adapter<KasusHarianAdapter.ViewHolder> {

    private List<ContentItem> results;
    private final Context context;
    private int rowLayout;


    public KasusHarianAdapter(List<ContentItem> results, int rowLayout, Context context) {
        this.results = results;
        this.context = context;
        this.rowLayout = rowLayout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kasus_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String value = String.valueOf(results.get(position).getTanggal());
        String date = value.substring(8,10)+"-"+value.substring(5,7) +"-"+ value.substring(0,4);
        holder.tvTanggal.setText(date);
        holder.tvSembuh.setText(String.valueOf(results.get(position).getConfirmationSelesai())+" kasus");
        holder.tvMeninggal.setText(String.valueOf(results.get(position).getConfirmationMeninggal())+" kasus");
        holder.tvTerkonfirmasi.setText(String.valueOf(results.get(position).getConfirmationDiisolasi())+" kasus");
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSembuh, tvTanggal, tvMeninggal, tvTerkonfirmasi;
        private RecyclerView rvKasusHarian;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSembuh = itemView.findViewById(R.id.etSembuh);
            tvMeninggal = itemView.findViewById(R.id.etMeningal);
            tvTerkonfirmasi = itemView.findViewById(R.id.etTerkonfirmasi);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);
        }

    }
}



