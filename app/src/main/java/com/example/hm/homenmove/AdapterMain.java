//package com.example.hm.homenmove;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class AdapterMain extends RecyclerView.Adapter<AdapterMain.maViewHolder>{
//
//    private final Context monContext;
//    private final String[] monDataSet;
//
//    public AdapterMain(Context c, String[] d) {
//        monContext = c;
//        monDataSet = d;
//    }
//
//    public maViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View cell = LayoutInflater.from(monContext).inflate(R.layout.cell_chambre,viewGroup,false);
//        return new maViewHolder(cell);
//    }
//
//    public void onBindViewHolder(maViewHolder cellHolder, int i) {
//        cellHolder.setData("Cellule "+i);
//    }
//
//    public int getItemCount() {
//        return monDataSet.length;
//    }
//
//    public class maViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        private final TextView monCellTexte;
//        ImageView monCellImage;
//        private String monCellData;
//
//        public maViewHolder(View itemView) {
//            super(itemView);
//            monCellTexte = (TextView) itemView.findViewById(R.id.cell_text);
//            monCellImage.setOnClickListener(this);
//            monCellImage= (ImageView) itemView.findViewById(R.id.cell_image);
//        }
//
//        public void setData(String t){
//            monCellTexte.setText(t);
//            monCellData = t;
//        }
//
//        public void onClick(View view) {
//            Intent detailIntent = new Intent(monContext,RoomActivity.class);
//            detailIntent.putExtra(monCellData, "cellData");
//            monContext.startActivity(detailIntent);
//        }
//    }
//}