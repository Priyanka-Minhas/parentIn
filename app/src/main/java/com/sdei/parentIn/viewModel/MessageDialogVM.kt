package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.repositories.MessageDialogRepository

class MessageDialogVM(application: Application) : BaseViewModel(application = application) {

    private val mRepository: MessageDialogRepository = MessageDialogRepository()
    private var mMessageList: MutableLiveData<MessagesModel>? = null

    fun getMessageList(): MutableLiveData<MessagesModel> {
        if (mMessageList == null) {
            mMessageList = MutableLiveData()
            mRepository.getMessageListApi {
                mMessageList!!.value=it
            }
        }
        return mMessageList as MutableLiveData<MessagesModel>
    }



}