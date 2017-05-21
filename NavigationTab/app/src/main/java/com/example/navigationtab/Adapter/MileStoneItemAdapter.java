package com.example.navigationtab.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigationtab.R;
import com.example.navigationtab.Utils.MileStoneItemObject;

import java.util.List;

/**
 * Created by subratkumar on 20/5/17.
 */
public class MileStoneItemAdapter extends RecyclerView.Adapter<MileStoneItemAdapter.MyViewHolder> {

    private List<MileStoneItemObject> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public MileStoneItemAdapter(Context context, List<MileStoneItemObject> list){
        this.context=context;
        this.list=list;
        layoutInflater=LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.cardview_milestone_content,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        MileStoneItemObject mileStoneItemObject=list.get(position);
        holder.imageView.setImageResource(mileStoneItemObject.getImage());
        holder.name.setText(mileStoneItemObject.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;

        public MyViewHolder(View itemView){
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.screen_shotm);
            name=(TextView)itemView.findViewById(R.id.music_namem);
        }

    }
}
