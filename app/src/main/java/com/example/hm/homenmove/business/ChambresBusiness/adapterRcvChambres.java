package com.example.hm.homenmove.business.ChambresBusiness;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hm.homenmove.R;
import com.example.hm.homenmove.modeles.Chambre;

import java.util.List;

/**
 * Created by Khaderik on 15/06/2016.
 */
public class adapterRcvChambres extends RecyclerView.Adapter<adapterRcvChambres.maViewHolder> {

    private List<Chambre> _lesChambres;

    public adapterRcvChambres(List<Chambre> listesChambres) {
        _lesChambres = listesChambres;
    }

    @Override
    public maViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_chambre, viewGroup, false);
        return new maViewHolder(view);
    }

    @Override
    public void onBindViewHolder(maViewHolder holder, int position) {
        Chambre uneChambre = _lesChambres.get(position);
        holder.setData(uneChambre);
    }

    @Override
    public int getItemCount() {
        return _lesChambres.size();
    }

    public class maViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView _libelleChambre;
        private final TextView _villeChambre;
        ImageView _image;
        private String _data;

        public maViewHolder(View itemView) {
            super(itemView);

            _libelleChambre = (TextView) itemView.findViewById(R.id.libelleChambre);
            _villeChambre = (TextView) itemView.findViewById(R.id.villeChambre);

            //_libelleChambre.setOnClickListener(this);
            _image = (ImageView) itemView.findViewById(R.id.photoChambre);
        }

        public void setData(Chambre uneChambre) {
            _libelleChambre.setText(uneChambre.getLibelleChambre());
            _villeChambre.setText(uneChambre.getAdresse().getVille());
            _image.setImageResource(R.drawable.ph);

            // TODO: 16/06/2016 CH penser à gérer les photos des chambres
        }

        @Override
        public void onClick(View view) {
//            Intent detailIntent = new Intent(_context,DetailActivity.class);
//            detailIntent.putExtra(DetailActivity.DETAIL_TEXT_KEY, _data);
//            _context.startActivity(detailIntent);
        }
    }
}
