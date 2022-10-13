package com.maoying.baseapp.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.luoye.apptool.utils.BaseUtils;
import com.luoye.apptool.viewbinding.BaseViewFragment;
import com.luoye.complexlist.bean.AdapterBean;
import com.luoye.complexlist.binding.ComplexBindingAdapter;
import com.luoye.complexlist.binding.ItemBindingView;
import com.luoye.complexlist.view.ComplexAdapter;
import com.luoye.complexlist.view.ItemView;
import com.maoying.baseapp.R;
import com.maoying.baseapp.databinding.FragmentComplexBinding;
import com.maoying.baseapp.databinding.ItemComplex1Binding;
import com.maoying.baseapp.databinding.ItemComplex2Binding;
import com.maoying.baseapp.databinding.ItemComplex3Binding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: luoye
 * Time: 2022/10/13
 * user:
 */
public class ComplexFragment extends BaseViewFragment<FragmentComplexBinding> {

    @Override
    protected void initFragment() {


        Map<Integer, ItemView<AdapterBean>> viewMap = new HashMap<>();

        viewMap.put(0, new ItemView<>(new ItemView.ItemViewInterface<AdapterBean>() {
            @NonNull
            @Override
            public View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return LayoutInflater.from(context).inflate(R.layout.item_complex1,parent,false);
            }

            @Override
            public void onBindViewHolder(AdapterBean bean, @NonNull ComplexAdapter.ViewHolder holder, int position) {
                View view = holder.getView();
                TextView textView = view.findViewById(R.id.text);
                textView.setText("这是第1类样式");
                textView.setOnClickListener(v -> BaseUtils.makeLongText(context, "item" + position));

            }
        }));

        viewMap.put(1, new ItemView<>(new ItemView.ItemViewInterface<AdapterBean>() {
            @NonNull
            @Override
            public View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return LayoutInflater.from(context).inflate(R.layout.item_complex2,parent,false);
            }

            @Override
            public void onBindViewHolder(AdapterBean bean, @NonNull ComplexAdapter.ViewHolder holder, int position) {
                View view = holder.getView();
                TextView textView = view.findViewById(R.id.text);
                textView.setText("这是第2类样式");
                textView.setOnClickListener(v -> BaseUtils.makeLongText(context, "item" + position));

            }
        }));

        viewMap.put(2, new ItemView<>(new ItemView.ItemViewInterface<AdapterBean>() {
            @NonNull
            @Override
            public View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return LayoutInflater.from(context).inflate(R.layout.item_complex3,parent,false);
            }

            @Override
            public void onBindViewHolder(AdapterBean bean, @NonNull ComplexAdapter.ViewHolder holder, int position) {
                View view = holder.getView();
                TextView textView = view.findViewById(R.id.text);
                textView.setText("这是第3类样式");
                textView.setOnClickListener(v -> BaseUtils.makeLongText(context, "item" + position));

            }
        }));


        List<AdapterBean> list = new ArrayList<>();
        list.add(new AdapterBean(0));
        list.add(new AdapterBean(1));
        list.add(new AdapterBean(2));
        list.add(new AdapterBean(0));
        list.add(new AdapterBean(1));
        list.add(new AdapterBean(2));
        list.add(new AdapterBean(0));
        list.add(new AdapterBean(1));
        list.add(new AdapterBean(2));
        list.add(new AdapterBean(2));
        list.add(new AdapterBean(0));
        list.add(new AdapterBean(1));
        list.add(new AdapterBean(2));
        list.add(new AdapterBean(0));
        list.add(new AdapterBean(1));
        list.add(new AdapterBean(0));
        list.add(new AdapterBean(1));
        list.add(new AdapterBean(2));
        list.add(new AdapterBean(0));
        list.add(new AdapterBean(1));
        list.add(new AdapterBean(2));
        list.add(new AdapterBean(2));
        list.add(new AdapterBean(0));
        list.add(new AdapterBean(1));

        ComplexAdapter<AdapterBean> complexAdapter = new ComplexAdapter<>(viewMap, list);
        binding.recyclerView.setLayoutManager(BaseUtils.getLinearLayoutManager(context, LinearLayoutManager.VERTICAL));
        binding.recyclerView.setAdapter(complexAdapter);

    }

}

