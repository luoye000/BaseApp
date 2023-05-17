package com.luoye.ktbase.utils

import android.app.ProgressDialog
import android.content.Context

/**
 *
 * Created by: 
 * Time: 2022/11/30
 * user: 系统弹窗  建议使用第三方
 *
 */
open class ProgressUtils {

    companion object {

        private var progressDialog: ProgressDialog? = null

        /**
         * 显示环形等待框
         */
        @Synchronized
        fun showProgressRingDialog(context: Context, message: String) {
            if (progressDialog != null) closeProgressDialog()
            progressDialog = ProgressDialog(context)
            progressDialog!!.setMessage(message)
            progressDialog!!.setCancelable(false)
            progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progressDialog!!.show()
        }

        /**
         * 显示进度条对话框
         */
        @Synchronized
        fun showProgressBarDialog(context: Context, message: String) {
            closeProgressDialog()
            progressDialog = ProgressDialog(context)
            progressDialog?.let {
                it.setMessage(message)
                it.setCancelable(false)
                it.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
                it.show()
            }
        }


        fun setProgressProgress(progress: Int) {
            progressDialog?.progress = progress
        }

        /**
         * 关闭进度对话框
         */
        fun closeProgressDialog() {
            progressDialog?.dismiss()
            progressDialog = null
        }


    }
}