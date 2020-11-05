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


import com.bancusoft.levelstat.Retrofit.Cl_cfoj;
import com.bancusoft.levelstat.Views.DetailActivityclcfoj;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import com.bancusoft.levelstat.R;


public class MyAdapterclcfoj extends RecyclerView.Adapter<MyAdapterclcfoj.ViewHolder>{

    private Context c;
    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private int[] mMaterialColors;
    private List<Cl_cfoj> cl_cfoj;
    public String searchString = "";

    /**
     * Our ViewHolder class. It's responsibilities include:
     * 1. Hold all the widgets which will be recycled and reference them.
     * 2. Implement click event.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private TextView mDENUMIRE_cfoj_Txt, mCODUL_cfoj_Txt;

        private MaterialLetterIcon mIcon;
        private MyAdapterclcfoj.ItemClickListener itemClickListener;
        /**
         * We reference our widgets
         */
        public ViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.mMaterialLetterIcon_cl_cfoj);

            mDENUMIRE_cfoj_Txt = itemView.findViewById(R.id.mDENUMIRE_cfoj_Txt);
            mCODUL_cfoj_Txt = itemView.findViewById(R.id.mCODUL_cfoj_Txt);



            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

        public void setItemClickListener(MyAdapterclcfoj.ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }

    /**
     * Our MyAdapter's costructor
     */
    public MyAdapterclcfoj(Context mContext, ArrayList<Cl_cfoj> cl_cfoj) {
        this.c = mContext;
        this.cl_cfoj = cl_cfoj;
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
    public MyAdapterclcfoj.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.model_cl_cfoj, parent, false);
        view.setBackgroundResource(mBackground);
        MyAdapterclcfoj.ViewHolder vh = new MyAdapterclcfoj.ViewHolder(view);
        return vh;
    }

//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//    }

    /**
     * Our onBindViewHolder method
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapterclcfoj.ViewHolder holder, int position) {

        holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));
        //get current scientist
        final Cl_cfoj s = cl_cfoj.get(position);

        //bind data to widgets
        holder.mDENUMIRE_cfoj_Txt.setText(s.getDENUMIRE());
        holder.mCODUL_cfoj_Txt.setText(s.getCODUL());




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
                    newSpannable(holder.mDENUMIRE_cfoj_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mDENUMIRE_cfoj_Txt.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh galaxy text while searching
        if (serviciu.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = serviciu.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.mCODUL_cfoj_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.mCODUL_cfoj_Txt.setText(spanString);
        }






        //open detailactivity when clicked
        holder.setItemClickListener(pos -> Utils.sendCl_cfojToActivity(c, s,
                DetailActivityclcfoj.class));
    }
    @Override
    public int getItemCount() {
        return cl_cfoj.size();
    }
    interface ItemClickListener {
        void onItemClick(int pos);
    }
}
