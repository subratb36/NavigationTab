package com.example.navigationtab.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigationtab.R;
import com.example.navigationtab.Utils.IViewpagerCommunicator;
import com.example.navigationtab.Utils.VideoItemObject;

import java.util.List;

/**
 * Created by subratkumar on 20/5/17.
 */
public class VideoItemAdapter extends RecyclerView.Adapter<VideoItemAdapter.MyViewHolder> {

    private IViewpagerCommunicator clickListener;
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
    public void setClickListener(IViewpagerCommunicator itemClickListener) {
        this.clickListener = itemClickListener;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        VideoItemObject videoItemObject=listItemObject.get(position);
        holder.screenShot.setImageResource(videoItemObject.getScreenShot());
        holder.musicName.setText(videoItemObject.getMusicName());
        holder.musicAuthor.setText(videoItemObject.getMusicAuthor());
        holder.imageTime.setText(videoItemObject.getUploadHr());
        holder.upTime.setImageResource(videoItemObject.getUpTime());
    }

    @Override
    public int getItemCount() {
        return listItemObject.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

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
        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.viewPagerCommunicate(view, getAdapterPosition());
        }
    }
}
