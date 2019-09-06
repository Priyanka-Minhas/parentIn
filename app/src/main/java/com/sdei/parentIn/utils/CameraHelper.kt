package com.sdei.parentIn.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class CameraHelper(private val activity: Activity) {
    var imageUri: Uri? = null
    var currentPhotoPath: String? = null
    var IMAGE_DIRECTORY_NAME ="FamiliasIn"
    var photoFile : File?=null
    private val simpleDateFormat = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)

    fun testCamera(){
        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (pictureIntent.resolveActivity(activity.packageManager) != null) {

            var photoFile: File? = null
            try {
                photoFile = createNewImageFile()
            } catch (e: IOException) {
                e.printStackTrace()
                return
            }
            // Continue only if the File was successfully created
            photoFile?.also {
                val photoURI: Uri = FileProvider.getUriForFile(
                        activity,
                        "com.sdei.parentIn.fileprovider",
                        it
                )
                pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                activity.startActivityForResult(pictureIntent, TAKE_PICTURE)
            }

        }
    }

    private fun createNewImageFile(): File? {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val imageFileName = "IMG_" + timeStamp + "_"
        val storageDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(imageFileName, ".jpg", storageDir)
        currentPhotoPath = image.absolutePath

        return image
    }


    fun takeCameraPicture() {

        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(activity.packageManager)?.also {
                // Create the File where the photo should go
               photoFile = try {
                    createImageFile()
                }catch (ex:IOException){
                    null
                }


                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                            activity,
                            "com.sdei.parentIn.fileprovider",
                            it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    activity.startActivityForResult(takePictureIntent, TAKE_PICTURE)
                }
            }
        }



       /* val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(activity.packageManager) != null) {
            val imageFile = createImageFile()
            imageUri = FileProvider.getUriForFile(activity,
                "com.sdei.parentIn.fileprovider",
                imageFile)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            activity.startActivityForResult(intent, TAKE_PICTURE)
        }*/
    }
    @Throws(IOException::class)
    private fun createImageFile(): File {
        val storageDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${simpleDateFormat.format(Date())}_",
            ".jpg",
            storageDir
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }

    // take picture for lower version

    fun takePicIfLowerVersion(){
        try {
            val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            photoFile = createImageForLowerVersion()
            if (photoFile != null) {
                val photoURI = Uri.fromFile(photoFile)
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                activity.startActivityForResult(cameraIntent, TAKE_PICTURE)
            }
        } catch (e: Exception) {
            //displayMessage(getBaseContext(), "Camera is not available.$e")
        }

    }



    // create file for lower version

    private fun createImageForLowerVersion():File{
        // External sdcard location
        val mediaStorageDir = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME)
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                //displayMessage(getBaseContext(), "Unable to create directory.")
                //null
                mediaStorageDir.mkdirs()
            }
        }

        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(Date())

        return File(mediaStorageDir.path + File.separator
                + "IMG_" + timeStamp + ".jpg")
    }

}