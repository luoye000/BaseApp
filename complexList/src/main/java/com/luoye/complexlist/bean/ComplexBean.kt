package com.luoye.complexlist.bean

open class ComplexBean() {

    var viewType: Int = 0

    constructor(viewType: Int) : this() {
        this.viewType = viewType;
    }

}