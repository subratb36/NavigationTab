package com.example.navigationtab.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigationtab.R;
import com.example.navigationtab.Utils.RecyclerViewOnItemClickListener;
import com.example.navigationtab.Utils.VideoItemObject;

import java.util.List;

/**
 * Created by subratkumar on 21-05-2017.
 */
public class VideoItemAdapter extends RecyclerView.Adapter<VideoItemAdapter.MyViewHolder> {

    RecyclerViewOnItemClickListener clickListener;
    private List<VideoItemObject> listItemObject;
    private Context context;
    private LayoutInflater layoutInflater;

    public VideoItemAdapter(Context context, List<VideoItemObject> listItemObject){
        this.context=context;
        this.listItemObject=listItemObject;
        layoutInflater=LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.cardview_video_content,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final VideoItemObject videoItemObject=listItemObject.get(position);
        holder.screenShot.setImageResource(videoItemObject.getScreenShot());
        holder.musicName.setText(videoItemObject.getMusicName());
        holder.musicAuthor.setText(videoItemObject.getMusicAuthor());
        holder.imageTime.setText(videoItemObject.getUploadHr());
        holder.upTime.setImageResource(videoItemObject.getUpTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onVideoItemClick(videoItemObject);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItemObject.size();
    }

    public void SetOnItemClickListener(RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
        this.clickListener=recyclerViewOnItemClickListener;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView screenShot;
        ImageView upTime;
        TextView musicName;
        TextView musicAuthor;
        TextView imageTime;
        public MyViewHolder(View itemView){
            super(itemView);
            screenShot=(ImageView)itemView.findViewById(R.id.screen_shot);
            upTime=(ImageView)itemView.findViewById(R.id.imageView_time);
            musicName=(TextView)itemView.findViewById(R.id.musicName_tv);
            musicAuthor=(TextView)itemView.findViewById(R.id.musicAuthor_tv);
            imageTime=(TextView)itemView.findViewById(R.id.musicTime_tv);
        }

    }
}
