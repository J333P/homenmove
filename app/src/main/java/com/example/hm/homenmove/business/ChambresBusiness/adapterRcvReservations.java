package com.example.hm.homenmove.business.ChambresBusiness;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hm.homenmove.R;
import com.example.hm.homenmove.modeles.Chambre;
import com.example.hm.homenmove.modeles.Reservation;

import java.util.List;

/**
 * Created by Khaderik on 15/06/2016.
 */
public class adapterRcvReservations extends RecyclerView.Adapter<adapterRcvReservations.maViewHolder> {

    private List<Reservation> _lesReservations;

    public adapterRcvReservations(List<Reservation> listesReservations) {
        _lesReservations = listesReservations;
    }

    @Override
    public maViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_reservation, viewGroup, false);
        return new maViewHolder(view);
    }

    @Override
    public void onBindViewHolder(maViewHolder holder, int position) {
        Reservation uneReservation = _lesReservations.get(position);
        holder.setData(uneReservation);
    }

    @Override
    public int getItemCount() {
        return _lesReservations.size();
    }

    public class maViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView _dateReservation;

        public maViewHolder(View itemView) {
            super(itemView);
            _dateReservation = (TextView) itemView.findViewById(R.id.dateReservation);
        }

        public void setData(Reservation uneReservation) {
            _dateReservation.setText(uneReservation.getDateReservation());
        }

        @Override
        public void onClick(View view) {
//            Intent detailIntent = new Intent(_context,DetailActivity.class);
//            detailIntent.putExtra(DetailActivity.DETAIL_TEXT_KEY, _data);
//            _context.startActivity(detailIntent);
        }
    }
}
