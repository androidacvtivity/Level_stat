package com.bancusoft.levelstat.Helpers.structbns;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.bancusoft.levelstat.Helpers.Utils;
import com.bancusoft.levelstat.R;
import com.bancusoft.levelstat.Retrofit.Scientist;

import com.bancusoft.levelstat.Views.structbns.DetailActivity_dr_servicii_sociale;
import com.github.ivbaranov.mli.MaterialLetterIcon;

public class MyAdapter_dr_serv_sociale extends RecyclerView.Adapter<MyAdapter_dr_serv_sociale.ViewHolder>{

    private Context c;
    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private int[] mMaterialColors;
    private List<Scientist> scientists;

    public String searchString = "";

    /**
     * Our ViewHolder class. It's responsibilities include:
     * 1. Hold all the widgets which will be recycled and reference them.
     * 2. Implement click event.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private TextView nameTxt, starTxt, galaxyTxt, departTxt, sectiaTxt, serviciuTxt, phoneTxt, descriptionTxt, formnamneTxt,
                phonemobileTxt,emailTxt,noticeTxt;
        private MaterialLetterIcon mIcon;
        private MyAdapter_dr_serv_sociale.ItemClickListener itemClickListener;
        /**
         * We reference our widgets
         */
        public ViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.mMaterialLetterIcons);

            nameTxt = itemView.findViewById(R.id.mNameTxts);
            starTxt = itemView.findViewById(R.id.mstarTxts);
            galaxyTxt = itemView.findViewById(R.id.mGalaxyTxts);
            departTxt = itemView.findViewById(R.id.mdepartTxts);
            sectiaTxt =  itemView.findViewById(R.id.msectiaTxts);
            serviciuTxt = itemView.findViewById(R.id.mserviciuTxts);
            phoneTxt = itemView.findViewById(R.id.mphoneTxts);
            descriptionTxt = itemView.findViewById(R.id.mdescriptionTxts);
            formnamneTxt = itemView.findViewById(R.id.mformNameTxts);
            phonemobileTxt = itemView.findViewById(R.id.mphonemobileTxts);
            emailTxt=itemView.findViewById(R.id.emailTxts);
            noticeTxt = itemView.findViewById(R.id.mnoticeTxts);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

        public void setItemClickListener(MyAdapter_dr_serv_sociale.ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }

    /**
     * Our MyAdapter's costructor
     */
    public MyAdapter_dr_serv_sociale(Context mContext, ArrayList<Scientist> scientists) {
        this.c = mContext;
        this.scientists = scientists;
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
    public MyAdapter_dr_serv_sociale.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.model_str, parent, false);
        view.setBackgroundResource(mBackground);
        MyAdapter_dr_serv_sociale.ViewHolder vh = new MyAdapter_dr_serv_sociale.ViewHolder(view);
        return vh;
    }
    /**
     * Our onBindViewHolder method
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapter_dr_serv_sociale.ViewHolder holder, int position) {

        holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));
        //get current scientist
        final Scientist s = scientists.get(position);

        //bind data to widgets
        holder.nameTxt.setText(s.getName());
        holder.starTxt.setText(s.getStar());
        holder.galaxyTxt.setText(s.getGalaxy());
        holder.departTxt.setText(s.getDepart());
        holder.sectiaTxt.setText(s.getSectia());
        holder.serviciuTxt.setText(s.getServiciu());
        holder.phoneTxt.setText(s.getPhone());
        holder.descriptionTxt.setText(s.getDescription());
        holder.formnamneTxt.setText(s.getFormname());
        holder.phonemobileTxt.setText(s.getPhonemobil());
        holder.emailTxt.setText(s.getEmail());
        holder.noticeTxt.setText(s.getNotice());


        holder.mIcon.setInitials(true);
        holder.mIcon.setInitialsNumber(2);
        holder.mIcon.setLetterSize(25);
        holder.mIcon.setShapeColor(mMaterialColors[new Random().nextInt(
                mMaterialColors.length)]);
        holder.mIcon.setLetter(s.getName());



        //open detailactivity when clicked
        holder.setItemClickListener(pos -> Utils.sendScientistToActivity(c, s,
                DetailActivity_dr_servicii_sociale.class));
    }
    @Override
    public int getItemCount() {
        return scientists.size();
    }
    interface ItemClickListener {
        void onItemClick(int pos);
    }
}
