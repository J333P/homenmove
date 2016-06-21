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
import com.example.hm.homenmove.modeles.Nuit;
import com.example.hm.homenmove.modeles.Reservation;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Exchanger;
/**
 * Created by Celine on 20/06/2016.
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
        private final TextView _chambreReservee;
        private final TextView _dateDebut;
        private final TextView _dateFin;
        List<Nuit> listeNuits = new ArrayList<Nuit>();
        public maViewHolder(View itemView) {
            super(itemView);
            _dateDebut = (TextView) itemView.findViewById(R.id.dateDebut);
            _dateFin = (TextView) itemView.findViewById(R.id.dateFin);
            _chambreReservee = (TextView) itemView.findViewById(R.id.nomChambre);
        }
        public void setData(Reservation uneReservation) {
            listeNuits = uneReservation.getNuits();
            String dateNuitSQL = null;
            java.util.Date dateNuit = null;
            java.util.Date dateDebut = null;
            java.util.Date dateFin = null;
            DateFormat stringToDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.FRANCE);
            Format dateToString = new SimpleDateFormat("dd/MM/yyyy");
            for (Nuit uneNuit : listeNuits) {
                _chambreReservee.setText(uneNuit.getChambre().getLibelleChambre());
                dateNuitSQL = uneNuit.getDateNuit();
                try {
                    dateNuit = stringToDate.parse(dateNuitSQL);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                if (dateDebut == null || dateNuit.before(dateDebut)) {
                    dateDebut = dateNuit;
                }
                if (dateFin == null || dateNuit.after(dateFin)) {
                    dateFin = dateNuit;
                }
            }

            Calendar cal = Calendar.getInstance();
            cal.setTime(dateFin);
            cal.add(Calendar.DATE, 1);
            dateFin = cal.getTime();

            //dateFin = DateUtil.addDays(dateFin, 1);
            _dateDebut.setText(dateToString.format(dateDebut));
            _dateFin.setText(dateToString.format(dateFin));
        }
        @Override
        public void onClick(View view) {
//            Intent detailIntent = new Intent(_context,DetailActivity.class);
//            detailIntent.putExtra(DetailActivity.DETAIL_TEXT_KEY, _data);
//            _context.startActivity(detailIntent);
        }
    }
}
