package com.example.navigationtab.drawerFragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationtab.Adapter.MileStoneItemAdapter;
import com.example.navigationtab.R;
import com.example.navigationtab.Utils.ImageItemObject;
import com.example.navigationtab.Utils.MileStoneItemObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subratkumar on 20/5/17.
 */
public class MileStoneFragment extends Fragment {
    private Activity context;
    private RecyclerView recyclerView;

    public MileStoneFragment(){

    }
    @SuppressLint("ValidFragment")
    public MileStoneFragment(Activity context){
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_milestone,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=(RecyclerView)view.findViewById(R.id.fragment_mileStone_rv);

        List<MileStoneItemObject> list=getAllMileStoneObject();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        MileStoneItemAdapter mileStoneItemAdapter=new MileStoneItemAdapter(getActivity(),list);
        recyclerView.setAdapter(mileStoneItemAdapter);
        recyclerView.setNestedScrollingEnabled(false);
    }
    public List<MileStoneItemObject> getAllMileStoneObject(){
        List<MileStoneItemObject> mList=new ArrayList<>();
        mList.add(new MileStoneItemObject(R.drawable.rihana,"Stay"));

        mList.add(new MileStoneItemObject(R.drawable.ciara,"Ride"));

        mList.add(new MileStoneItemObject(R.drawable.gaga," Paparazzi "));

        mList.add(new MileStoneItemObject(R.drawable.brown,"Forever"));

        mList.add(new MileStoneItemObject(R.drawable.milian,"Dip It Low"));

        mList.add(new MileStoneItemObject(R.drawable.jason,"Marry me"));

        mList.add(new MileStoneItemObject(R.drawable.milian,"Dip It Low"));

        mList.add(new MileStoneItemObject(R.drawable.shakira,"Waka Waka"));

        mList.add(new MileStoneItemObject(R.drawable.milian,"Dip It Low"));

        mList.add(new MileStoneItemObject(R.drawable.milian,"Dip It Low"));

        mList.add(new MileStoneItemObject(R.drawable.perry,"Dark Hors"));


        return mList;

    }

}
