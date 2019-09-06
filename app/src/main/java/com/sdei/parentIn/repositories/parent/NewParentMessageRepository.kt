package com.sdei.parentIn.repositories.parent

import android.app.Application
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.room.RoomDb
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.handleJson
import com.sdei.parentIn.utils.hideProgress
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewParentMessageRepository {

    fun getChildList(application: Application, returnValue: (ArrayList<ChildModel.DataBean>) -> Unit) {
        returnValue(RoomDb.getInstance(application).getDao().fetchParentChildList() as ArrayList<ChildModel.DataBean>)
    }

    fun sendMessage(to: ArrayList<String>
                    , toName: ArrayList<String>
                    , message: String, returnValue: (MessagesModel) -> Unit) {
        RetrofitClient.instance!!.createMessage(
                createBuilder(
                        to,
                        toName,
                        getAppPref().getString(InterConst.ID).toString(),
                        getAppPref().getString(InterConst.FIRST_NAME) + " " + getAppPref().getString(InterConst.LAST_NAME),
                        message)).enqueue(object : Callback<MessagesModel> {
            override fun onFailure(call: Call<MessagesModel>?, t: Throwable?) {
                hideProgress()
                returnValue(MessagesModel(t!!.message!!))
            }

            override fun onResponse(call: Call<MessagesModel>?, response: Response<MessagesModel>?) {
                hideProgress()
                when {
                    response!!.body() != null -> returnValue(response.body()!!)
                    response.errorBody() != null -> {
                        val (statusCode, message) = handleJson(response.errorBody()!!.string())
                        returnValue(MessagesModel(statusCode.toInt(), message))
                    }
                    else -> returnValue(MessagesModel(response.code(), response.message().toString()))
                }
            }
        })
    }

    private fun createBuilder(to: ArrayList<String>, toName: ArrayList<String>,
                              from: String,
                              fromName: String,
                              message: String): RequestBody {

        val builder = MultipartBody.Builder().setType(MultipartBody.FORM)

        builder.addFormDataPart("from", from)
                .addFormDataPart("fromName", fromName)
                .addFormDataPart("message", message)

        for (id in to) {
            builder.addFormDataPart("to", id)
        }
        for (name in toName) {
            builder.addFormDataPart("toName", name)
        }
        return builder.build()
    }

}