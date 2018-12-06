package com.asis.myasis;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AbsenAdapter extends RecyclerView.Adapter<AbsenAdapter.AbsensiViewHolder>{
    private Context mAbsensi;
    private List<Absensi> absensiList;
    OnItemClick handler;


    public AbsenAdapter(Context mAbsensi, List<Absensi> absensiList) {
        this.absensiList = absensiList;
        this.mAbsensi = mAbsensi;
        notifyDataSetChanged();
    }

    public void setHandler(OnItemClick clickHandler) {
        handler=clickHandler;
    }

    @NonNull
    @Override
    public AbsensiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mAbsensi);
           View view =inflater.inflate(R.layout.riwayat_absensi, null);
        AbsensiViewHolder holder = new AbsensiViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AbsensiViewHolder holder, int position) {
        Absensi absensi = absensiList.get(position);

        holder.textTanggal.setText(absensi.getTangga());
        holder.textWaktu.setText(absensi.getWaktu());
        holder.imageSelfie.setImageDrawable(mAbsensi.getResources().getDrawable(absensi.getImage()));
    }

    @Override
    public int getItemCount() {
        return absensiList.size();
    }

    public interface OnItemClick {
        void click (Absensi m);
    }

    class AbsensiViewHolder extends RecyclerView.ViewHolder{

        ImageView imageSelfie;
        TextView textTanggal;
        TextView textWaktu;

        public AbsensiViewHolder(@NonNull View itemView) {
            super(itemView);

            imageSelfie = itemView.findViewById(R.id.imageSelfie);
            textTanggal = itemView.findViewById(R.id.textTanggal);
            textWaktu = itemView.findViewById(R.id.textWaktu);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Absensi m = absensiList.get(position);
                    handler.click(m);
                }
            });
        }

    }


}
