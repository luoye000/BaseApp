package com.text.luoye.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.luoye.complexlist.bean.ComplexBean;
import com.luoye.complexlist.view.ComplexAdapter;
import com.luoye.complexlist.view.ItemView;
import com.luoye.ktbase.binding.fragment.lazy.LazyInterFace;
import com.luoye.ktbase.binding.fragment.viewbinding.BaseViewFragment;
import com.luoye.ktbase.utils.LogUtils;
import com.luoye.ktbase.utils.RecyclerViewUtils;
import com.luoye.ktbase.utils.ToastUtils;
import com.text.luoye.R;
import com.text.luoye.databinding.FragmentComplexBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: luoye
 * Time: 2022/10/13
 * user:
 */
public class ComplexFragment extends BaseViewFragment<FragmentComplexBinding> implements LazyInterFace {


    @Override
    public void lazyInit() {

        LogUtils.Companion.i("lazyInit");
    }

    @Override
    protected void initFragment() {


        Map<Integer, ItemView<ComplexBean>> viewMap = new HashMap<>();

        viewMap.put(0, new ItemView<ComplexBean>() {
            @NonNull
            @Override
            public View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return LayoutInflater.from(getContext()).inflate(R.layout.item_complex1,parent,false);
            }

            @Override
            public void onBindViewHolder(ComplexBean bean, @NonNull ComplexAdapter.ViewHolder holder, int position) {
                View view = holder.getView();
                TextView textView = view.findViewById(R.id.text);
                textView.setText("这是第1类样式");
                textView.setOnClickListener(v -> ToastUtils.Companion.makeLong(getContext(),  "item" + position));

            }
        });

        viewMap.put(1, new ItemView<ComplexBean>() {
            @NonNull
            @Override
            public View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return LayoutInflater.from(getContext()).inflate(R.layout.item_complex2,parent,false);
            }

            @Override
            public void onBindViewHolder(ComplexBean bean, @NonNull ComplexAdapter.ViewHolder holder, int position) {
                View view = holder.getView();
                TextView textView = view.findViewById(R.id.text);
                textView.setText("这是第2类样式");
                textView.setOnClickListener(v ->ToastUtils.Companion.makeLong(getContext(),  "item" + position));

            }
        });

        viewMap.put(2, new ItemView<ComplexBean>() {
            @NonNull
            @Override
            public View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return LayoutInflater.from(getContext()).inflate(R.layout.item_complex3,parent,false);
            }

            @Override
            public void onBindViewHolder(ComplexBean bean, @NonNull ComplexAdapter.ViewHolder holder, int position) {
                View view = holder.getView();
                TextView textView = view.findViewById(R.id.text);
                textView.setText("这是第3类样式");
                textView.setOnClickListener(v -> ToastUtils.Companion.makeLong(getContext(), "item" + position));

            }
        });


        List<ComplexBean> list = new ArrayList<>();
        list.add(new ComplexBean(0));
        list.add(new ComplexBean(1));
        list.add(new ComplexBean(2));
        list.add(new ComplexBean(0));
        list.add(new ComplexBean(1));
        list.add(new ComplexBean(2));
        list.add(new ComplexBean(0));
        list.add(new ComplexBean(1));
        list.add(new ComplexBean(2));
        list.add(new ComplexBean(2));
        list.add(new ComplexBean(0));
        list.add(new ComplexBean(1));
        list.add(new ComplexBean(2));
        list.add(new ComplexBean(0));
        list.add(new ComplexBean(1));
        list.add(new ComplexBean(0));
        list.add(new ComplexBean(1));
        list.add(new ComplexBean(2));
        list.add(new ComplexBean(0));
        list.add(new ComplexBean(1));
        list.add(new ComplexBean(2));
        list.add(new ComplexBean(2));
        list.add(new ComplexBean(0));
        list.add(new ComplexBean(1));

        ComplexAdapter<ComplexBean> complexAdapter = new ComplexAdapter<>(viewMap, list);
        getBinding().recyclerView.setLayoutManager(RecyclerViewUtils.Companion.getLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL));
        getBinding().recyclerView.setAdapter(complexAdapter);

    }


}

