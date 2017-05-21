package com.example.navigationtab.drawerFragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navigationtab.Adapter.MileStoneItemAdapter;
import com.example.navigationtab.R;
import com.example.navigationtab.Utils.ImageItemObject;
import com.example.navigationtab.Utils.MileStoneItemObject;
import com.example.navigationtab.Utils.RecyclerViewOnItemClickListener;
import com.example.navigationtab.Utils.VideoItemObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subratkumar on 21-05-2017.
 */
public class MileStoneFragment extends Fragment {
    private Activity context;
    private RecyclerView recyclerView;
    private GridLayoutManager lLayout;

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

        lLayout = new GridLayoutManager(getContext(), 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lLayout);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(3), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        MileStoneItemAdapter mileStoneItemAdapter=new MileStoneItemAdapter(getActivity(),list);
        recyclerView.setAdapter(mileStoneItemAdapter);
        mileStoneItemAdapter.SetOnItemClickListener(new MileStoneItemAdapter.onItemClick() {

            @Override
            public void onImageItemClick(MileStoneItemObject mileStoneItemObject) {
                Log.i("OnItemClicked"," Berth Name -  "+mileStoneItemObject.getName());
                Snackbar snackbar = Snackbar.make(recyclerView, mileStoneItemObject.getName(), Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setBackgroundColor(Color.YELLOW);
                textView.setTextColor(Color.BLUE);
                snackbar.show();
            }


        });
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


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
