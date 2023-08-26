# BaseApp

## 食用方法
## 具体使用方法请查看演示Demo

### 提示（2.0.0 开始移除了 java 编写的基类 BaseApp 全部转为 Kotlin  ）

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
    implementation 'com.github.luoye000:BaseApp:2.0.0'
    //kt基类 
    implementation 'com.github.luoye000.BaseApp:KtBase:2.0.0'
    //多布局RecyclerView
    implementation 'com.github.luoye000.BaseApp:complexlist:2.0.0'
} 
```

### 导入 [![](https://jitpack.io/v/luoye000/BaseApp.svg)](https://jitpack.io/#luoye000/BaseApp)


### 混淆
```
 #使用 基类 的需要添加混淆
 -keep class  使用依赖包项目的包名.databinding.* {*;}
 ...
```

### 2.1.0 开始加入注解实现 viewBinding,dataBinding 暂时支持 （Activity Fragment）
### 体使用方案查看Demo

```

//方案一
@ContentViewX(R.layout.activity_low)
public class LowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须要写的
        XTool.inject(this);
    }
}


//方案二
@ViewBindingX(binding = ActivityLow1Binding.class)
public class LowActivity1 extends AppCompatActivity {


    @BindingX
    private ActivityLow1Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须要写的
        XTool.inject(this);

        binding.text.setText(this.getClass().getName());
    }
}


//方案三
@ViewDataBindingX(binding = ActivityLow2Binding.class)
public class LowActivity2 extends AppCompatActivity {


    @BindingX
    private ActivityLow2Binding binding;

    @ViewModelX(vmClass = MainModel.class)
    private MainModel mainModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须要写的
        XTool.inject(this);


        binding.setData(mainModel);
        mainModel.getText().postValue(this.getClass().getName());
    }
}

//更多使用查看Demo



```

## 1.介绍 viewBinding,dataBinding 的封装 

### 1.1 viewBinding 关于 activity,Dialog,Fragment,RecyclerView的Adapter 的封装 

#### 1.1.1 Activity(BaseViewAppCompatActivity BaseViewFragmentActivity)
```
class MainActivity : BaseViewAppCompatActivity<ActivityMianBinding>() {
    override fun initActivity() {
    binding.finish.setOnClickListener { finish() }
    }
}
```
#### 1.1.2 Fragment(BaseViewFragment BaseLazyViewFragment) 使用方案同上
项目中包含一个LazyFragment使用方案参考Demo
#### 1.1.3 Dialog(BaseViewDialog) 使用方案同上
#### 1.1.4 Adapter(BaseViewAdapter) 使用方案同上

### 1.2 viewBinding 关于 activity,Dialog,Fragment的封装

#### 1.2.1 Activity(BaseViewAppCompatActivity BaseViewFragmentActivity)
```
class MainActivity : BaseDataAppCompatActivity<ActivityMianBinding, MainModel>() {
    override fun initActivity() {
    binding.data = viewModel  //绑定视图
    binding.finish.setOnClickListener { finish() }
    }
}
```
#### 1.2.2 fragment(BaseDataActivityFragment BaseDataAllFragment BaseDataFragment)
BaseDataActivityFragment 中的ViewModel 为Activity中的ViewModel
BaseDataAllFragment 中的存在两个ViewModel viewModelActivity 为Activity中的ViewModel
viewModel为Fragment自身ViewModel
BaseDataFragment 中的ViewModel 为Fragment自身ViewMode
#### 1.2.3 Dialog(BaseViewDialog) 使用方案同上
#### 1.2.4 Adapter(BaseViewAdapter) 使用方案同上




### 1.3 包含工具类
 位于com.luoye.ktbase.utils包下


### 1.4 包含一个ActivityTool的工具
 所有的 BaseAcivity 已经在onCreate onDestroy 方法中进行绑定

