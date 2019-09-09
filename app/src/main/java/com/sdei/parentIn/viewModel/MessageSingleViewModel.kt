package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.repositories.MessageSingleUserRepository

class MessageSingleViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: MessageSingleUserRepository = MessageSingleUserRepository()
    private var mMessageList: MutableLiveData<MessagesModel>? = null

    private var mSendMessage: MutableLiveData<MessagesModel>? = null


    fun getSingleMessageList(from:String,to:String): MutableLiveData<MessagesModel> {
        if (mMessageList == null) {
            mMessageList = MutableLiveData()
            hitMessageListApi(from, to)
        }
        return mMessageList as MutableLiveData<MessagesModel>
    }

    fun hitMessageListApi(from: String, to: String) {
        mRepository.getSingleMessageApi(from, to) {
            mMessageList!!.value = it
        }
    }

    fun messageCreated(): MutableLiveData<MessagesModel> {
        if (mSendMessage == null) {
            mSendMessage = MutableLiveData()
        }
        return mSendMessage as MutableLiveData<MessagesModel>
    }

    fun sendMessage(to: ArrayList<String>,
                    toName: ArrayList<String>,
                    message: String) {
        mRepository.sendMessage(to, toName, message) {
            mSendMessage!!.value = it
        }
    }
}