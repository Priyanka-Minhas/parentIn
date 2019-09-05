package com.sdei.parentIn.viewModel.parent

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.repositories.parent.NewParentMessageRepository
import com.sdei.parentIn.viewModel.BaseViewModel
import okhttp3.MultipartBody
import okhttp3.RequestBody

class NewParentMessageViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: NewParentMessageRepository = NewParentMessageRepository()

    private var mChildList: MutableLiveData<ArrayList<ChildModel.DataBean>>? = null
    private var createMessage: MutableLiveData<MessagesModel>? = null

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
        if (createMessage == null) {
            createMessage = MutableLiveData()
        }
        return createMessage as MutableLiveData<MessagesModel>
    }

    fun createMessage(attachment: MultipartBody.Part,
                      to: List<RequestBody>,
                      toName: List<RequestBody>,
                      from: RequestBody,
                      fromName: RequestBody,
                      message: RequestBody) {
        mRepository.createMessage(attachment,
                to,
                toName,
                from,
                fromName,
                message) {
            createMessage!!.value = it
        }
    }


}