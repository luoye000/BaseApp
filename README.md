# BaseApp

## 食用方法

### 提示
项目 1.3.0 开始向kt语言转换 1.3.0 后不建议使用导入所有的包 KtBase 当前处于测试阶段谨慎使用！！
### 导入 [![](https://jitpack.io/v/luoye000/BaseApp.svg)](https://jitpack.io/#luoye000/BaseApp)

```
android {
    ...
    buildFeatures {
        viewBinding true
        dataBinding true
    }
}

dependencies {
    ...
    //所有
    implementation 'com.github.luoye000:BaseApp:1.3.0'
    //java基类
    implementation 'com.github.luoye000.BaseApp:BaseApp:1.3.0'
    //kt基类 
    implementation 'com.github.luoye000.BaseApp:KtBase:1.3.0'
    //多布局RecyclerView
    implementation 'com.github.luoye000.BaseApp:complexlist:1.3.0'
} 
```

### 混淆
```
 #使用 基类 的需要添加混淆
 -keep class  包名.databinding.* {*;}//包名=使用依赖的包名 在其他依赖中使用不能只添加主项目的包名 需添加所有用到依赖的项目的包名
 -keep class  使用到的依赖包名.databinding.* {*;}
 ...
 -keep class  使用到的依赖包名.databinding.* {*;}
```

## 1.介绍 viewBinding,dataBinding 的封装

### 1.1 viewBinding 关于 activity,Dialog,Fragment,RecyclerView的Adapter 的封装 

#### 1) BaseViewActivity
```
public class MainActivity extends BaseViewActivity<ActivityMainBinding> {
    @Override
    protected void initActivity() throws Exception { 
        binding.控件id 等价 findViewById
    }
}
```

### 2) BaseViewDialog 
 implements DefaultLifecycleObserver 观察activity 生命周期
```
public class ViewDialog extends BaseViewActivity<String,ActivityMainBinding> {
    @Override
    protected void initDialog(){
    binding.控件id 等价 findViewById
    if(onBaseListener!=null)onBaseListener.方法
    }
    
    DefaultLifecycleObserver 可以实现 onStart onResume onPause onStop onDestroy 方法用于观察activity
}

```

### 3) BaseViewFragment 
 implements DefaultLifecycleObserver 观察activity 生命周期
 ```
 public class ViewFragment extends BaseViewFragment<ActivityMainBinding> {
    @Override
    protected void initFragment(){
    binding.控件id 等价 findViewById
    }
    
    DefaultLifecycleObserver 可以实现 onStart onResume onPause onStop onDestroy 方法用于观察activity
}
 ```
 
 ### 4）BaseViewAdapter
  ```
 public class ViewFragment extends BaseViewAdapter<String,ActivityMainBinding> {
    @Override
    protected void initAdapter(ViewHolder holder，String str, int position){
        holder.binding.控件id
    }
    
    DefaultLifecycleObserver 可以实现 onStart onResume onPause onStop onDestroy 方法用于观察activity
}
 ```
 

### 1.2 dataBinding 关于 activity,Dialog,Fragment 的封装 


#### 1) BaseDataActivity
```
public class MainActivity extends BaseViewActivity<ActivityMainBinding,ViewModel> {
    @Override
    protected void initActivity() throws Exception { 
       //固定写法  setMainViewModel 需要在 xml <data> <variable  name="mainViewModel"   type="com.maoying.baseapp.MainViewModel" /> <data>
        binding.setMainViewModel(viewModel)
        binding.控件id 等价 findViewById
    }
}
```

#### 2) BaseDataDialog
 implements DefaultLifecycleObserver 观察activity 生命周期
```
public class ViewDialog extends BaseDataDialog<String,ActivityMainBinding,ViewModel> {
    @Override
    protected void initDialog(){
      //固定写法  setMainViewModel 需要在 xml <data> <variable  name="mainViewModel"   type="com.maoying.baseapp.MainViewModel" /> <data>
        binding.setMainViewModel(viewModel)
      binding.控件id 等价 findViewById
      if(onBaseListener!=null)onBaseListener.方法
    }
     DefaultLifecycleObserver 可以实现 onStart onResume onPause onStop onDestroy 方法用于观察activity
}
```

### 2) BaseDataFragment 
 implements DefaultLifecycleObserver 观察activity 生命周期
 ```
 public class ViewFragment extends BaseViewFragment<ActivityMainBinding> {
    @Override
    protected void initFragment(){
      //固定写法  setMainViewModel 需要在 xml <data> <variable  name="mainViewModel"   type="com.maoying.baseapp.MainViewModel" /> <data>
    binding.setMainViewModel(viewModel)
    binding.控件id 等价 findViewById
    }
    
    DefaultLifecycleObserver 可以实现 onStart onResume onPause onStop onDestroy 方法用于观察activity
}
 ```

### 1.3 包含一个BaseUtils的一个工具类
方案看注释

### 1.4 包含一个ActivityTool的工具
 BaseViewActivity,BaseDataActivity 已经绑定
```
       /*绑定Activity*/
        ActivityTool.getInstance().addActivity(activity);

        /*解绑Activity*/
        public void removeActivity(activity);

        /*关闭指定的Activity... 可多个*/
        public void finishActivity(MainActivity.class.getName());

        /*只保留某些Activity...可多个*/
        public void finishOtherActivity(MainActivity.class.getName());

        /*关闭所有Activity*/
        public void finishAll();
```
