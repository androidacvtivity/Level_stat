package com.bancusoft.levelstat.Helpers.cl_medicament;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bancusoft.levelstat.Helpers.Utils;

import com.bancusoft.levelstat.Retrofit.Cl_medicament;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.bancusoft.levelstat.R;

import com.bancusoft.levelstat.Views.med.DetailActivity_cl_med;

public class MyAdapter_cl_med extends RecyclerView.Adapter<MyAdapter_cl_med.ViewHolder>{
    private Context c;
    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private int[] mMaterialColors;
    private List<Cl_medicament> cl_medicament;

    public String searchString = "";

    /**
     * Our ViewHolder class. It's responsibilities include:
     * 1. Hold all the widgets which will be recycled and reference them.
     * 2. Implement click event.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private TextView mdenumirea_intTxt, mnoticeTxt, mdenumirea_comercialaTxt_View, mdcodul_medicalTxt_view, mProducatorulTxt_view;
        private MaterialLetterIcon mIcon;
        private MyAdapter_cl_med.ItemClickListener itemClickListener;
        /**
         * We reference our widgets
         */
        public ViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.mMaterialLetterIcon_med);

            mdenumirea_intTxt = itemView.findViewById(R.id.mdenumirea_intTxt);
            mdenumirea_comercialaTxt_View = itemView.findViewById(R.id.mdenumirea_comercialaTxt_View);
            mdcodul_medicalTxt_view = itemView.findViewById(R.id.mdcodul_medicalTxt_view);
            mProducatorulTxt_view = itemView.findViewById(R.id.mProducatorulTxt_view);
            mnoticeTxt = itemView.findViewById(R.id.mnoticeTxt);


            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

        public void setItemClickListener(MyAdapter_cl_med.ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }

    /**
     * Our MyAdapter_cl_medicament's costructor
     */
    public MyAdapter_cl_med(Context mContext, ArrayList<Cl_medicament> cl_medicament) {
        this.c = mContext;
        this.cl_medicament = cl_medicament;
        c.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mMaterialColors = c.getResources().getIntArray(R.array.colors);
        mBackground = mTypedValue.resourceId;
    }
    /**
     * We override the onCreateViewHolder. Here is where we inflate our model_cl_med.xml
     * layout into a view object and set it's background color
     */
    @NonNull
    @Override
    public MyAdapter_cl_med.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.model_cl_med, parent, false);
        view.setBackgroundResource(mBackground);
        MyAdapter_cl_med.ViewHolder vh = new MyAdapter_cl_med.ViewHolder(view);
        return vh;
    }
    /**
     * Our onBindViewHolder method
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapter_cl_med.ViewHolder holder, int position) {

        holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));
        //get current scientist
        final Cl_medicament s = cl_medicament.get(position);

        //bind data to widgets
        holder.mdenumirea_intTxt.setText(s.getDenumirea_int());
        holder.mdenumirea_comercialaTxt_View.setText(s.getden_come());
        holder.mdcodul_medicalTxt_view.setText(s.getCodul_med());
        holder.mProducatorulTxt_view.setText(s.getProducatorul());
        holder.mnoticeTxt.setText(s.getNotice());



        holder.mIcon.setInitials(true);
        holder.mIcon.setInitialsNumber(1);
        holder.mIcon.setLetterSize(25);
        holder.mIcon.setShapeColor(mMaterialColors[new Random().nextInt(
                mMaterialColors.length)]);
        holder.mIcon.setLetter(s.getDenumirea_int());

        String denumirea_int = s.getDenumirea_int().toLowerCase(Locale.getDefault()).trim();
        String denumirea_comerciala = s.getden_come().toLowerCase(Locale.getDefault()).trim();
        String codul_medical = s.getCodul_med().toLowerCase(Locale.getDefault()).trim();
        String producatorul = s.getProducatorul().toLowerCase(Locale.getDefault()).trim();



        //highlight producatorul text while searching
        if (producatorul.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = producatorul.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.mProducatorulTxt_view.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mProducatorulTxt_view.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }


        //highlight getDenumirea_int text while searching
        if (denumirea_int.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = denumirea_int.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.mdenumirea_intTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mdenumirea_intTxt.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }

         //highlight denumirea_comerciala text while searching
        if (denumirea_comerciala.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = denumirea_comerciala.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.mdenumirea_comercialaTxt_View.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mdenumirea_comercialaTxt_View.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }

        //highlight codul medical text while searching
        if (codul_medical.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = codul_medical.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.mdcodul_medicalTxt_view.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mdcodul_medicalTxt_view.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }









        //open detailactivity when clicked
        holder.setItemClickListener(pos -> Utils.sendCl_mediToActivity(c, s,
                DetailActivity_cl_med.class));
    }

    @Override
    public int getItemCount() {
        return cl_medicament.size();
    }
    interface ItemClickListener {
        void onItemClick(int pos);
    }

}
