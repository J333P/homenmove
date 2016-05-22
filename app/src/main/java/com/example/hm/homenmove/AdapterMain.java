package com.example.hm.homenmove;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by EPSI on 22.05.2016.
 */
public class AdapterMain extends RecyclerView.Adapter<AdapterMain.CellHolder>{

    private final Context monContext;
    private final String[] monDataSet;

    public AdapterMain(Context c, String[] d) {
        monContext = c;
        monDataSet = d;
    }

    public CellHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View cell = LayoutInflater.from(monContext).inflate(R.layout.cell_holder_main,viewGroup,false);
        return new CellHolder(cell);
    }

    public void onBindViewHolder(CellHolder cellHolder, int i) {
        cellHolder.setData("Cellule "+i);
    }

    public int getItemCount() {
        return monDataSet.length;
    }

    public class CellHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView monCellTexte;
        ImageView monCellImage;
        private String monCellData;

        public CellHolder(View itemView) {
            super(itemView);
            monCellTexte = (TextView) itemView.findViewById(R.id.chambreTextView);
            monCellImage.setOnClickListener(this);
            monCellImage= (ImageView) itemView.findViewById(R.id.chambreImageView);
        }

        public void setData(String t){
            monCellTexte.setText(t);
            monCellData = t;
        }

        @Override
        public void onClick(View view) {
            Intent detailIntent = new Intent(monContext,RoomActivity.class);
            detailIntent.putExtra(monCellData, "cellData");
            monContext.startActivity(detailIntent);
        }
    }
}