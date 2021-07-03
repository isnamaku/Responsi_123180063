package com.example.covid_19.ui.rsRujukan;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.R;
import com.example.covid_19.api.response.ContentItem;
import com.example.covid_19.api.responseRs.DataItem;

import java.util.List;


public class RsAdapter extends RecyclerView.Adapter<RsAdapter.ViewHolder> {

    private List<DataItem> results;
    private final Context context;
    private int rowLayout;


    public RsAdapter(List<DataItem> results, int rowLayout, Context context) {
        this.results = results;
        this.context = context;
        this.rowLayout = rowLayout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rs_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
         holder.tvNamaRs.setText(results.get(position).getNama());
         holder.tvAlamat.setText(results.get(position).getAlamat());

         holder.btnMaps.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                         Uri.parse("geo:37.7749,-122.4194?q="+results.get(position).getNama()));
                 context.startActivity(intent);
             }
         });



    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAlamat, tvNamaRs;
        private Button btnMaps;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvNamaRs = itemView.findViewById(R.id.tvNamaRs);
            btnMaps = itemView.findViewById(R.id.btn_maps);
        }

    }
}



