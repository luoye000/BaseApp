package com.text.luoye.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.luoye.complexlist.bean.ComplexBean;
import com.luoye.complexlist.binding.ComplexBindingAdapter;
import com.luoye.complexlist.binding.ItemBindingView;
import com.luoye.ktbase.binding.fragment.viewbinding.BaseViewFragment;
import com.luoye.ktbase.utils.RecyclerViewUtils;
import com.luoye.ktbase.utils.ToastUtils;
import com.text.luoye.databinding.FragmentComplexBinding;
import com.text.luoye.databinding.ItemComplex1Binding;
import com.text.luoye.databinding.ItemComplex2Binding;
import com.text.luoye.databinding.ItemComplex3Binding;

import org.jetbrains.annotations.NotNull;

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


        Map<Integer, ItemBindingView<ComplexBean>> viewMap = new HashMap<>();

        viewMap.put(0, new ItemBindingView<ComplexBean>() {
            @NonNull
            @Override
            public ViewBinding onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return ItemComplex1Binding.inflate(LayoutInflater.from(getContext()), parent, false);
            }

            @Override
            public void onBindViewHolder(@NotNull ComplexBean bean, @NotNull ViewBinding binding, int position) {

                ((ItemComplex1Binding) binding).text.setText("这是第一类样式");
                ((ItemComplex1Binding) binding).text.setOnClickListener(v -> ToastUtils.Companion.makeLong(getContext(), "item" + position));

            }
        });

        viewMap.put(1, new ItemBindingView<ComplexBean>() {
            @NonNull
            @Override
            public ViewBinding onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return ItemComplex2Binding.inflate(LayoutInflater.from(getContext()), parent, false);
            }

            @Override
            public void onBindViewHolder(@NotNull ComplexBean bean, @NotNull ViewBinding binding, int position) {
                ((ItemComplex2Binding) binding).text.setText("这是第二类样式");
                ((ItemComplex2Binding) binding).text.setOnClickListener(v -> ToastUtils.Companion.makeLong(getContext(), "item" + position));

            }
        });

        viewMap.put(2, new ItemBindingView<ComplexBean>() {
            @NonNull
            @Override
            public ViewBinding onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return ItemComplex3Binding.inflate(LayoutInflater.from(getContext()), parent, false);
            }

            @Override
            public void onBindViewHolder(@NotNull ComplexBean bean, @NotNull ViewBinding binding, int position) {
                ((ItemComplex3Binding) binding).text.setText("这是第三类样式");
                ((ItemComplex3Binding) binding).text.setOnClickListener(v -> ToastUtils.Companion.makeLong(getContext(), "item" + position));
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

        ComplexBindingAdapter<ComplexBean> complexBindingAdapter = new ComplexBindingAdapter<>(viewMap,list);
        getBinding().recyclerView.setLayoutManager(RecyclerViewUtils.Companion.getLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL));
        getBinding().recyclerView.setAdapter(complexBindingAdapter);
        complexBindingAdapter.notifyDataSetChanged();

    }

}
