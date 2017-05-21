package com.example.navigationtab.drawerFragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationtab.Adapter.ImageItemAdapter;
import com.example.navigationtab.Adapter.VideoItemAdapter;
import com.example.navigationtab.R;
import com.example.navigationtab.Utils.ImageItemObject;
import com.example.navigationtab.Utils.VideoItemObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subratkumar on 20/5/17.
 */
public class ImageFragment extends Fragment {
    private RecyclerView recyclerView;
    private Activity context;
    public ImageFragment(){

    }
    @SuppressLint("ValidFragment")
    public ImageFragment(Activity context){
        this.context=context;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=(RecyclerView)view.findViewById(R.id.fragment_image_rv);
        List<ImageItemObject> list=getAllImageList();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        StaggeredGridLayoutManager gridLayoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        ImageItemAdapter imageItemAdapter=new ImageItemAdapter(getActivity(),list);
        recyclerView.setAdapter(imageItemAdapter);
        recyclerView.setNestedScrollingEnabled(false);

    }
    public List<ImageItemObject> getAllImageList(){
        List<ImageItemObject> li=new ArrayList<>();
        li.add(new ImageItemObject(R.drawable.milian,"Dip It Low"));

        li.add(new ImageItemObject(R.drawable.perry,"Dark Hors"));

        li.add(new ImageItemObject(R.drawable.adele,"Someone like you"));

        li.add(new ImageItemObject(R.drawable.ciara,"Ride"));

        li.add(new ImageItemObject(R.drawable.gaga," Paparazzi "));

        li.add(new ImageItemObject(R.drawable.brown,"Forever"));

        li.add(new ImageItemObject(R.drawable.milian,"Dip It Low"));

        li.add(new ImageItemObject(R.drawable.jason,"Marry me"));

        li.add(new ImageItemObject(R.drawable.milian,"Dip It Low"));

        li.add(new ImageItemObject(R.drawable.shakira,"Waka Waka"));

        li.add(new ImageItemObject(R.drawable.milian,"Dip It Low"));

        li.add(new ImageItemObject(R.drawable.rihana," Stay "));
        return li ;
    }
}
