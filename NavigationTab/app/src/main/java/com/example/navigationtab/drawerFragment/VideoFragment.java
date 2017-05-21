package com.example.navigationtab.drawerFragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navigationtab.Adapter.VideoItemAdapter;
import com.example.navigationtab.R;
import com.example.navigationtab.Utils.RecyclerViewOnItemClickListener;
import com.example.navigationtab.Utils.VideoItemObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subratkumar on 21-05-2017.
 */
public class VideoFragment extends Fragment{
    private View view;
    private RecyclerView recyclerView;
    private Activity context;
    private List<VideoItemObject> list;
    private VideoItemAdapter videoItemAdapter;
    public VideoFragment(){

    }
    @SuppressLint("ValidFragment")
    public VideoFragment(Activity context){
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=(RecyclerView)view.findViewById(R.id.fragment_video_rv);
        list=getAllVideoList();
        videoItemAdapter=new VideoItemAdapter(getActivity(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(videoItemAdapter);
        videoItemAdapter.SetOnItemClickListener(new RecyclerViewOnItemClickListener() {

            @Override
            public void onVideoItemClick(VideoItemObject videoItemObject) {
                Log.i("OnItemClicked"," Berth Name -  "+videoItemObject.getMusicName());
                Snackbar snackbar = Snackbar.make(recyclerView, videoItemObject.getMusicName(), Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setBackgroundColor(Color.GRAY);
                textView.setTextColor(Color.BLUE);
                snackbar.show();
            }

        });
        recyclerView.setNestedScrollingEnabled(false);


    }


    private List<VideoItemObject> getAllVideoList(){
        List<VideoItemObject> list=new ArrayList<>();
        list.add(new VideoItemObject(R.drawable.milian,"Dip It Low","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "18 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.perry,"Dark Hors","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "28 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.adele,"Someone like you","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "11 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.ciara,"Ride","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "21 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.gaga," Paparazzi ","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "14 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.brown,"Forever","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "15 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.milian,"Dip It Low","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "18 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.jason,"Marry me","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "21 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.milian,"Dip It Low","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "18 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.shakira,"Waka Waka","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "8 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.milian,"Dip It Low","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "18 hours ago",R.drawable.ic_schedule_black_18dp));

        list.add(new VideoItemObject(R.drawable.rihana," Stay ","Lorem Ipsum is simply dummy text to the printing and type Setting industry.",
                "22 hours ago",R.drawable.ic_schedule_black_18dp));

        return list;
    }

   /* @Override
    public void viewPagerCommunicate(View view, int position) {
        VideoItemObject allBerthCameraBean = list.get(position);
        Log.i("OnItemClicked"," Berth Name -  "+allBerthCameraBean.getMusicName());
        Snackbar snackbar = Snackbar.make(view, allBerthCameraBean.getMusicName(), Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        snackbar.show();
    }*/
}
