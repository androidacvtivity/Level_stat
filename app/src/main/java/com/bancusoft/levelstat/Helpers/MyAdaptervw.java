package com.bancusoft.levelstat.Helpers;

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

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.Scientistvw;
import com.bancusoft.levelstat.Views.DetailActivityvw;

/**
 * This is our adapter class. It has the following roles;
 * 1. Inflate our model layout into a view then subsequently recycle that view.
 * 2. Bind data to that view for all rows, making our recyclerview.
 * 3. Show name initials in icons with random icon bg color applied.
 * 4. Listen to click events of recyclerview item and pass the clicked item to recyclerview
 */
public class MyAdaptervw extends RecyclerView.Adapter<MyAdaptervw.ViewHolder> {
    private final Context c;
    private final int mBackground;
    private final int[] mMaterialColors;
    private final List<Scientistvw> scientists;
    public String searchString = "";

    /**
     * Our ViewHolder class. It's responsibilities include:
     * 1. Hold all the widgets which will be recycled and reference them.
     * 2. Implement click event.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private final TextView DEN_COM_VW_Txt;
        private final TextView IDNO_VW_Txt;
        private final TextView LIST_COND_VW_Txt;
        private final TextView ADRESA_VW_Txt;
        private final TextView LISTA_FOND_VW_Txt;
        private final TextView GEN_ACT_NE_LIC_VW_Txt;
        private final TextView GEN_ACT_LIC_VW_Txt;
        private final TextView DATA_REG_VW_Txt;
        private final TextView STATUTUL_VW_Txt;
        private final TextView act_TXT;
        private final MaterialLetterIcon mIcon;
        private ItemClickListener itemClickListener;
        /**
         * We reference our widgets
         */
        public ViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.mMaterialLetterIcon_vw);
            DEN_COM_VW_Txt = itemView.findViewById(R.id.mDEN_COM_VW_Txt);
            IDNO_VW_Txt = itemView.findViewById(R.id.mIDNO_VW_Txt);
            LIST_COND_VW_Txt = itemView.findViewById(R.id.mLIST_COND_VW_Txt);
            ADRESA_VW_Txt = itemView.findViewById(R.id.mADRESA_VW_Txt);
            LISTA_FOND_VW_Txt = itemView.findViewById(R.id.mLISTA_FOND_VW_Txt);
            GEN_ACT_NE_LIC_VW_Txt = itemView.findViewById(R.id.mGEN_ACT_NE_LIC_VW_Txt);
            GEN_ACT_LIC_VW_Txt = itemView.findViewById(R.id.mGEN_ACT_LIC_VW_Txt);
            DATA_REG_VW_Txt = itemView.findViewById(R.id.mDATA_REG_VW_Txt);
            STATUTUL_VW_Txt = itemView.findViewById(R.id.mSTATUTUL_VW_Txt);
            act_TXT = itemView.findViewById(R.id.mact_Txtr);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }

    /**
     * Our MyAdapter's costructor
     */
    public MyAdaptervw(Context mContext, ArrayList<Scientistvw> scientists) {
        this.c = mContext;
        this.scientists = scientists;
        TypedValue mTypedValue = new TypedValue();
        c.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mMaterialColors = c.getResources().getIntArray(R.array.colors);
        mBackground = mTypedValue.resourceId;
    }
    /**
     * We override the onCreateViewHolder. Here is where we inflate our model.xml
     * layout into a view object and set it's background color
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.modelvw, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }
    /**
     * Our onBindViewHolder method
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));
        //get current scientist
        final Scientistvw s = scientists.get(position);

        //bind data to widgets
        holder.DEN_COM_VW_Txt.setText(s.getDEN_COM_VW().trim());
        holder.IDNO_VW_Txt.setText(s.getIDNO_VW().trim());
        holder.LIST_COND_VW_Txt.setText(s.getLIST_COND_VW().trim());
        holder.ADRESA_VW_Txt.setText(s.getADRESA_VW().trim());
        holder.LISTA_FOND_VW_Txt.setText(s.getLISTA_FOND_VW().trim());
        holder.GEN_ACT_NE_LIC_VW_Txt.setText(s.getGEN_ACT_NE_LIC_VW().trim());
        holder.GEN_ACT_LIC_VW_Txt.setText(s.getGEN_ACT_LIC_VW().trim());
        holder.DATA_REG_VW_Txt.setText(s.getDATA_REG_VWW().trim());
        holder.STATUTUL_VW_Txt.setText(s.getSTATUTUL_VW().trim());
        holder.act_TXT.setText(s.getAct().trim());

        holder.mIcon.setInitials(true);
        holder.mIcon.setInitialsNumber(2);
        holder.mIcon.setLetterSize(25);
        holder.mIcon.setShapeColor(mMaterialColors[new Random().nextInt(
                mMaterialColors.length)]);
        holder.mIcon.setLetter(s.getLIST_COND_VW());

        //get name and galaxy
        String name = s.getDEN_COM_VW().toLowerCase(Locale.getDefault()).trim();
        String serviciu = s.getLIST_COND_VW().toLowerCase(Locale.getDefault()).trim();
        String description = s.getIDNO_VW().toLowerCase(Locale.getDefault()).trim();
        String galaxy = s.getADRESA_VW().toLowerCase(Locale.getDefault()).trim();
        String sectia = s.getLISTA_FOND_VW().toLowerCase(Locale.getDefault()).trim();
        String depart = s.getGEN_ACT_NE_LIC_VW().toLowerCase(Locale.getDefault()).trim();
        String phone = s.getGEN_ACT_LIC_VW().toLowerCase(Locale.getDefault()).trim();
        String phoneinternal = s.getSTATUTUL_VW().toLowerCase(Locale.getDefault()).trim();
        String data_reg = s.getDATA_REG_VWW().toLowerCase(Locale.getDefault()).trim();
       // String act = s.getAct().toLowerCase(Locale.getDefault());


        //highlight name text while searching
        if (data_reg.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = data_reg.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.DATA_REG_VW_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.DATA_REG_VW_Txt.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }


        //highlight name text while searching
        if (name.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = name.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.DEN_COM_VW_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.DEN_COM_VW_Txt.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }





        //highligh galaxy text while searching
        if (serviciu.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = serviciu.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.LIST_COND_VW_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.LIST_COND_VW_Txt.setText(spanString);
        }

        else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh galaxy text while searching
        if (description.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = description.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.IDNO_VW_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.IDNO_VW_Txt.setText(spanString);
        }


        else {
            //Utils.show(ctx, "Search string empty");
        }

        if (galaxy.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = galaxy.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.ADRESA_VW_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.ADRESA_VW_Txt.setText(spanString);
        }


        else {
            //Utils.show(ctx, "Search string empty");
        }

        if (sectia.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = sectia.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.LISTA_FOND_VW_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.LISTA_FOND_VW_Txt.setText(spanString);
        }

        else {
            //Utils.show(ctx, "Search string empty");
        }

        if (depart.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = depart.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.GEN_ACT_NE_LIC_VW_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.GEN_ACT_NE_LIC_VW_Txt.setText(spanString);
        }

        else {
            //Utils.show(ctx, "Search string empty");
        }

        if (phone.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = phone.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.GEN_ACT_LIC_VW_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.GEN_ACT_LIC_VW_Txt.setText(spanString);
        }

        else {
            //Utils.show(ctx, "Search string empty");
        }

        if (phoneinternal.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = phoneinternal.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.STATUTUL_VW_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.STATUTUL_VW_Txt.setText(spanString);
        }




        //open detailactivity when clicked
        holder.setItemClickListener(pos -> Utils.sendScientistvwToActivity(c, s,
                DetailActivityvw.class));
    }
    @Override
    public int getItemCount() {
        return scientists.size();
    }
    interface ItemClickListener {
        void onItemClick(int pos);
    }
}
//end

