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


import com.bancusoft.levelstat.Retrofit.Cl_cfp;
import com.bancusoft.levelstat.Views.DetailActivityclcfp;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import com.bancusoft.levelstat.R;

public class MyAdapterclcfp  extends RecyclerView.Adapter<MyAdapterclcfp.ViewHolder>{

    private final Context c;
    private final int mBackground;
    private final int[] mMaterialColors;
    private final List<Cl_cfp> cl_cfp;
    public String searchString = "";

    /**
     * Our ViewHolder class. It's responsibilities include:
     * 1. Hold all the widgets which will be recycled and reference them.
     * 2. Implement click event.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private final TextView mDENUMIRE_cl_cfp_Txt;
        private final TextView mCODUL_cl_cfp_Txt;

        private final MaterialLetterIcon mIcon;
        private MyAdapterclcfp.ItemClickListener itemClickListener;
        /**
         * We reference our widgets
         */
        public ViewHolder(View itemView) {
            super(itemView);

            mIcon = itemView.findViewById(R.id.mMaterialLetterIcon_cl_cfp);
            mDENUMIRE_cl_cfp_Txt = itemView.findViewById(R.id.mDENUMIRE_cl_cfp_Txt);
            mCODUL_cl_cfp_Txt = itemView.findViewById(R.id.mCODUL_cl_cfp_Txt);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

        public void setItemClickListener(MyAdapterclcfp.ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }

    /**
     * Our MyAdapter's costructor
     */
    public MyAdapterclcfp(Context mContext, ArrayList<Cl_cfp> cl_cfp) {
        this.c = mContext;
        this.cl_cfp = cl_cfp;
        TypedValue mTypedValue = new TypedValue();
        c.getTheme().resolveAttribute(io.github.inflationx.viewpump.R.attr.selectableItemBackground, mTypedValue, true);
        mMaterialColors = c.getResources().getIntArray(R.array.colors);
        mBackground = mTypedValue.resourceId;
    }
    /**
     * We override the onCreateViewHolder. Here is where we inflate our model.xml
     * layout into a view object and set it's background color
     */
    @NonNull
    @Override
    public MyAdapterclcfp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.model_cl_cfp, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }


    /**
     * Our onBindViewHolder method
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapterclcfp.ViewHolder holder, int position) {

        holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));
        //get current scientist
        final Cl_cfp s = cl_cfp.get(position);

        //bind data to widgets
        holder.mDENUMIRE_cl_cfp_Txt.setText(s.getDENUMIRE());
        holder.mCODUL_cl_cfp_Txt.setText(s.getCODUL());




        holder.mIcon.setInitials(true);
        holder.mIcon.setInitialsNumber(1);
        holder.mIcon.setLetterSize(25);
        holder.mIcon.setShapeColor(mMaterialColors[new Random().nextInt(
                mMaterialColors.length)]);
        holder.mIcon.setLetter(s.getDENUMIRE());

        //get name and galaxy
        String name = s.getDENUMIRE().toLowerCase(Locale.getDefault());
        String serviciu = s.getCODUL().toLowerCase(Locale.getDefault());



        //highlight name text while searching
        if (name.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = name.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.mDENUMIRE_cl_cfp_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mDENUMIRE_cl_cfp_Txt.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh galaxy text while searching
        if (serviciu.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = serviciu.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.mCODUL_cl_cfp_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mCODUL_cl_cfp_Txt.setText(spanString);
        }






        //open detailactivity when clicked
        holder.setItemClickListener(pos -> Utils.sendCl_cfpToActivity(c, s,
                DetailActivityclcfp.class));
    }
    @Override
    public int getItemCount() {
        return cl_cfp.size();
    }
    interface ItemClickListener {
        void onItemClick(int pos);
    }

}
