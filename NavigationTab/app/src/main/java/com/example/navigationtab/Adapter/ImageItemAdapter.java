package com.example.navigationtab.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigationtab.R;
import com.example.navigationtab.Utils.ImageItemObject;

import java.util.List;

/**
 * Created by subratkumar on 20/5/17.
 */
public class ImageItemAdapter extends RecyclerView.Adapter<ImageItemAdapter.MyViewHolder> {
    private List<ImageItemObject> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public ImageItemAdapter(Context context,List<ImageItemObject> list){
        this.context=context;
        this.list=list;
        layoutInflater=LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.cardview_image_content,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageItemAdapter.MyViewHolder holder, int position) {
        ImageItemObject imageItemObject=list.get(position);
        holder.image.setImageResource(imageItemObject.getImage());
        holder.name.setText(imageItemObject.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        public MyViewHolder(View itemView){
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.screen_shot);
            name=(TextView)itemView.findViewById(R.id.music_name);
        }
    }
}
