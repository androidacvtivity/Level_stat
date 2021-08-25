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

import com.bancusoft.levelstat.Retrofit.Cl_caem2;
import com.bancusoft.levelstat.Views.DetailActivityclcaem2;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import com.bancusoft.levelstat.R;


public class MyAdapterclcaem2  extends RecyclerView.Adapter<MyAdapterclcaem2.ViewHolder>{

    private final Context c;
    private final int mBackground;
    private final int[] mMaterialColors;
    private final List<Cl_caem2> cl_caem2;
    public String searchString = "";

    /**
     * Our ViewHolder class. It's responsibilities include:
     * 1. Hold all the widgets which will be recycled and reference them.
     * 2. Implement click event.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private final TextView mDENUMIRE_caem2_Txt;
        private final TextView mCODUL_caem2_Txt;
        private final TextView m_prim_Txt ;

        private final MaterialLetterIcon mIcon;
        private ItemClickListener itemClickListener;
        /**
         * We reference our widgets
         */
        public ViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.mMaterialLetterIcon_cl_caem2);

            mDENUMIRE_caem2_Txt = itemView.findViewById(R.id.mDENUMIRE_caem2_Txt);
            mCODUL_caem2_Txt = itemView.findViewById(R.id.mCODUL_caem2_Txt);
            m_prim_Txt = itemView.findViewById(R.id.m_prim_Txt);


            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

        public void setItemClickListener(MyAdapterclcaem2.ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }

    /**
     * Our MyAdapter's costructor
     */
    public MyAdapterclcaem2(Context mContext, ArrayList<Cl_caem2> cl_caem2) {
        this.c = mContext;
        this.cl_caem2 = cl_caem2;
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
    public MyAdapterclcaem2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.model_cl_caem2, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }


    /**
     * Our onBindViewHolder method
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapterclcaem2.ViewHolder holder, int position) {

        holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));
        //get current scientist
        final Cl_caem2 s = cl_caem2.get(position);

        //bind data to widgets
        holder.mDENUMIRE_caem2_Txt.setText(s.getDENUMIRE());
        holder.mCODUL_caem2_Txt.setText(s.getCODUL());
        holder.m_prim_Txt.setText(s.getPRIM());



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
                    newSpannable(holder.mDENUMIRE_caem2_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mDENUMIRE_caem2_Txt.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh galaxy text while searching
        if (serviciu.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = serviciu.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.mCODUL_caem2_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mCODUL_caem2_Txt.setText(spanString);
        }






        //open detailactivity when clicked
        holder.setItemClickListener(pos -> Utils.sendCl_caem2ToActivity(c, s,
                DetailActivityclcaem2.class));
    }
    @Override
    public int getItemCount() {
        return cl_caem2.size();
    }
    interface ItemClickListener {
        void onItemClick(int pos);
    }
}
