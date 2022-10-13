package com.maoying.baseapp.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.luoye.apptool.utils.BaseUtils;
import com.luoye.apptool.viewbinding.BaseViewFragment;
import com.luoye.complexlist.bean.AdapterBean;
import com.luoye.complexlist.binding.ComplexBindingAdapter;
import com.luoye.complexlist.binding.ItemBindingView;
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
public class ComplexBindingFragment extends BaseViewFragment<FragmentComplexBinding> {

    @Override
    protected void initFragment() {


        Map<Integer, ItemBindingView<AdapterBean>> viewMap = new HashMap<>();

        viewMap.put(0, new ItemBindingView<>(new ItemBindingView.ItemViewInterface<AdapterBean>() {
            @NonNull
            @Override
            public ViewBinding onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return ItemComplex1Binding.inflate(LayoutInflater.from(context), parent, false);
            }

            @Override
            public void onBindViewHolder(AdapterBean bean, @NonNull ComplexBindingAdapter.ViewHolder holder, int position) {

                ItemComplex1Binding binding = (ItemComplex1Binding) holder.getBinding();
                binding.text.setText("这是第一类样式");
                binding.text.setOnClickListener(v -> BaseUtils.makeLongText(context, "item" + position));

            }
        }));

        viewMap.put(1, new ItemBindingView<>(new ItemBindingView.ItemViewInterface<AdapterBean>() {
            @NonNull
            @Override
            public ViewBinding onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return ItemComplex2Binding.inflate(LayoutInflater.from(context), parent, false);
            }

            @Override
            public void onBindViewHolder(AdapterBean bean, @NonNull ComplexBindingAdapter.ViewHolder holder, int position) {

                ItemComplex2Binding binding = (ItemComplex2Binding) holder.getBinding();
                binding.text.setText("这是第二类样式");
                binding.text.setOnClickListener(v -> BaseUtils.makeLongText(context, "item" + position));

            }
        }));

        viewMap.put(2, new ItemBindingView<>(new ItemBindingView.ItemViewInterface<AdapterBean>() {
            @NonNull
            @Override
            public ViewBinding onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return ItemComplex3Binding.inflate(LayoutInflater.from(context), parent, false);
            }

            @Override
            public void onBindViewHolder(AdapterBean bean, @NonNull ComplexBindingAdapter.ViewHolder holder, int position) {

                ItemComplex3Binding binding = (ItemComplex3Binding) holder.getBinding();
                binding.text.setText("这是第三类样式");
                binding.text.setOnClickListener(v -> BaseUtils.makeLongText(context, "item" + position));

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

        ComplexBindingAdapter<AdapterBean> complexBindingAdapter = new ComplexBindingAdapter<>(viewMap, list);
        binding.recyclerView.setLayoutManager(BaseUtils.getLinearLayoutManager(context, LinearLayoutManager.VERTICAL));
        binding.recyclerView.setAdapter(complexBindingAdapter);

    }

}
