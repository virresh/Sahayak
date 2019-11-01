package com.mobilecomputing.sahayak.JavaClasses;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mobilecomputing.sahayak.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(View itemView) {
        super(itemView);

        mView = itemView;

        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });
        //item long click
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });

    }

    //set details to recycler view row
    public void setDetails(Context ctx, String sTeacher, String sStudent, String sDate,
                           String sDuration, String sSkill){
        //Views
//        Log.d("Date received:", sDate);
        TextView teacher = mView.findViewById(R.id.teacher);
        TextView student = mView.findViewById(R.id.student);
        TextView duration = mView.findViewById(R.id.duration);
        TextView date = mView.findViewById(R.id.interaction_date);
        TextView skill = mView.findViewById(R.id.skill);

        teacher.setText("Mentor: "+sTeacher);
        student.setText("Mentee: "+sStudent);
        duration.setText("Duration: "+sDuration);
        date.setText("Date: "+sDate);
        skill.setText("Skill: "+sSkill);
//        Picasso.get().load(image).into(mImageIv);
    }

    private ViewHolder.ClickListener mClickListener;

    //interface to send callbacks
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View  view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}