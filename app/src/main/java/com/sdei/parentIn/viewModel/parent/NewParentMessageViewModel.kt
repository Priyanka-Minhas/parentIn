package com.sdei.parentIn.viewModel.parent

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.repositories.parent.NewParentMessageRepository
import com.sdei.parentIn.viewModel.BaseViewModel

class NewParentMessageViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: NewParentMessageRepository = NewParentMessageRepository()

    private var mChildList: MutableLiveData<ArrayList<ChildModel.DataBean>>? = null
    private var mSendMessage: MutableLiveData<MessagesModel>? = null

    fun getChildList(): MutableLiveData<ArrayList<ChildModel.DataBean>> {
        if (mChildList == null) {
            mChildList = MutableLiveData()
            mRepository.getChildList(getApplication()) {
                mChildList!!.value = it
            }
        }
        return mChildList as MutableLiveData<ArrayList<ChildModel.DataBean>>
    }

    fun messageCreated(): MutableLiveData<MessagesModel> {
        if (mSendMessage == null) {
            mSendMessage = MutableLiveData()
        }
        return mSendMessage as MutableLiveData<MessagesModel>
    }

    fun sendMessage(filepath:String,to: ArrayList<String>,
                    toName: ArrayList<String>,
                    message: String) {
        mRepository.sendMessage(filepath,to, toName, message) {
            mSendMessage!!.value = it
        }
    }


}