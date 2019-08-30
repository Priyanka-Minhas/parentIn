package com.sdei.parentIn.utils

import android.content.Context
import android.content.ContextWrapper
import android.os.Environment

import java.io.File

/**
 * Created by Ahsen Saeed on 11/1/2017.
 */

class DirectoryHelper private constructor(context: Context) : ContextWrapper(context) {

    private val isExternalStorageAvailable: Boolean
        get() {
            val extStorageState = Environment.getExternalStorageState()
            return Environment.MEDIA_MOUNTED == extStorageState
        }

    init {
        createFolderDirectories()
    }

    private fun createFolderDirectories() {
        if (isExternalStorageAvailable)
            createDirectory(ROOT_DIRECTORY_NAME)
    }

    private fun createDirectory(directoryName: String) {
        if (!isDirectoryExists(directoryName)) {
            val file = File(Environment.getExternalStorageDirectory(), directoryName)
            file.mkdir()
        }
    }

    private fun isDirectoryExists(directoryName: String): Boolean {
        val file = File(Environment.getExternalStorageDirectory().toString() + "/" + directoryName)
        return file.isDirectory && file.exists()
    }

    companion object {

        val ROOT_DIRECTORY_NAME = "CSVFile"

        fun createDirectory(context: Context) {
            DirectoryHelper(context)
        }
    }
}
