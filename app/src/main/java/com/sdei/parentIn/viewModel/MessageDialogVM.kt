package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.repositories.MessageDialogRepository

class MessageDialogVM(application: Application) : BaseViewModel(application = application) {

    private val mRepository: MessageDialogRepository = MessageDialogRepository()
    private var mMessageList: MutableLiveData<MessagesModel>? = null
    private var mSendMessage: MutableLiveData<MessagesModel>? = null

    fun messageListResponse(): MutableLiveData<MessagesModel> {
        if (mMessageList == null) {
            mMessageList = MutableLiveData()
            getMessageList()
        }
        return mMessageList as MutableLiveData<MessagesModel>
    }

    fun getMessageList() {
        mRepository.getMessageListApi {
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