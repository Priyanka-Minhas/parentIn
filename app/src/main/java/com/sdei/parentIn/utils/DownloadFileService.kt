package com.sdei.parentIn.utils

import android.app.DownloadManager
import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.net.Uri


class DownloadFileService : IntentService("DownloadFileService") {

    override fun onHandleIntent(intent: Intent?) {
        val downloadPath = intent!!.getStringExtra(DOWNLOAD_PATH)
        val destinationPath = intent.getStringExtra(DESTINATION_PATH)
        startDownload(downloadPath, destinationPath)
    }

    private fun startDownload(downloadPath: String, destinationPath: String) {
        val uri = Uri.parse(downloadPath)
        val request = DownloadManager.Request(uri)
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI)  // Tell on which network you want to download file.
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)  // This will show notification on top when downloading the file.
        request.setTitle("FamiliasIn") // Title for notification.
        request.setVisibleInDownloadsUi(true)
        request.setDestinationInExternalPublicDir(destinationPath, uri.lastPathSegment)  // Storage directory path
        (getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager).enqueue(request) // This will start downloading
    }

    companion object {

        private val DOWNLOAD_PATH = "com.spartons.androiddownloadmanager_DownloadSongService_Download_path"
        private val DESTINATION_PATH = "com.spartons.androiddownloadmanager_DownloadSongService_Destination_path"

        fun getDownloadService(callingClassContext: Context, downloadPath: String, destinationPath: String): Intent {
            return Intent(callingClassContext, DownloadFileService::class.java)
                    .putExtra(DOWNLOAD_PATH, downloadPath)
                    .putExtra(DESTINATION_PATH, destinationPath)
        }
    }
}
