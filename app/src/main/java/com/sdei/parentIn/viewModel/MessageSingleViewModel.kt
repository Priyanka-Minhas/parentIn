package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.repositories.MessageSingleUserRepository

class MessageSingleViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: MessageSingleUserRepository = MessageSingleUserRepository()
    private var mMessageList: MutableLiveData<MessagesModel>? = null

    fun getSingleMessageList(from:String,to:String): MutableLiveData<MessagesModel> {
        if (mMessageList == null) {
            mMessageList = MutableLiveData()
            mRepository.getSingleMessageApi(from,to) {
                mMessageList!!.value=it
            }
        }
        return mMessageList as MutableLiveData<MessagesModel>
    }
}