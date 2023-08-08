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
    implementation 'com.github.luoye000:BaseApp:+'
    //java基类(2.0.0后被移除)
    implementation 'com.github.luoye000.BaseApp:BaseApp:+'
    //kt基类 
    implementation 'com.github.luoye000.BaseApp:KtBase:+'
    //多布局RecyclerView
    implementation 'com.github.luoye000.BaseApp:complexlist:+'//使用方案参考Demo
} 
```

### 混淆
```
 #使用 基类 的需要添加混淆
 -keep class  使用依赖包项目的包名.databinding.* {*;}
 ...
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

