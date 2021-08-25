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
import com.bancusoft.levelstat.Retrofit.Scientistscaem;
import com.bancusoft.levelstat.Views.DetailActivitycaem;


/**
 * This is our adapter class. It has the following roles;
 * 1. Inflate our model layout into a view then subsequently recycle that view.
 * 2. Bind data to that view for all rows, making our recyclerview.
 * 3. Show name initials in icons with random icon bg color applied.
 * 4. Listen to click events of recyclerview item and pass the clicked item to recyclerview
 */
public class MyAdaptercaem extends RecyclerView.Adapter<MyAdaptercaem.ViewHolder> {
    private final Context c;
    private final int mBackground;
    private final int[] mMaterialColors;
    private final List<Scientistscaem> scientists;
    public String searchString = "";

    /**
     * Our ViewHolder class. It's responsibilities include:
     * 1. Hold all the widgets which will be recycled and reference them.
     * 2. Implement click event.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private final TextView DENUMIRE_Txt;
        private final TextView VALUE_Txt;
        private final TextView act_Txt ;

        private final MaterialLetterIcon mIcon;
        private ItemClickListener itemClickListener;
        /**
         * We reference our widgets
         */
        public ViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.mMaterialLetterIcon_caem);

            DENUMIRE_Txt = itemView.findViewById(R.id.mDENUMIRE_caem_Txt);
            VALUE_Txt = itemView.findViewById(R.id.mVALUE_caem_Txt);
            act_Txt = itemView.findViewById(R.id.mact_acem_Txt);


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
    public MyAdaptercaem(Context mContext, ArrayList<Scientistscaem> scientists) {
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
        View view = LayoutInflater.from(c).inflate(R.layout.model_caem, parent, false);
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
        final Scientistscaem s = scientists.get(position);

        //bind data to widgets
        holder.DENUMIRE_Txt.setText(s.getDENUMIRE());
        holder.VALUE_Txt.setText(s.getVALUE());
        holder.act_Txt.setText(s.getAct());



        holder.mIcon.setInitials(true);
        holder.mIcon.setInitialsNumber(1);
        holder.mIcon.setLetterSize(25);
        holder.mIcon.setShapeColor(mMaterialColors[new Random().nextInt(
                mMaterialColors.length)]);
        holder.mIcon.setLetter(s.getDENUMIRE());

        //get name and galaxy
        String name = s.getDENUMIRE().toLowerCase(Locale.getDefault());
        String serviciu = s.getVALUE().toLowerCase(Locale.getDefault());



        //highlight name text while searching
        if (name.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = name.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.DENUMIRE_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.DENUMIRE_Txt.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh galaxy text while searching
        if (serviciu.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = serviciu.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.VALUE_Txt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.VALUE_Txt.setText(spanString);
        }






        //open detailactivity when clicked
        holder.setItemClickListener(pos -> Utils.sendScientistscaemToActivity(c, s,
                DetailActivitycaem.class));
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
