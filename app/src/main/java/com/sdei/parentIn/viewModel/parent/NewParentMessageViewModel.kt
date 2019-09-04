package com.sdei.parentIn.viewModel.parent

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.repositories.parent.NewParentMessageRepository
import com.sdei.parentIn.viewModel.BaseViewModel

class NewParentMessageViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: NewParentMessageRepository = NewParentMessageRepository()

    private var mChildList: MutableLiveData<ArrayList<ChildModel.DataBean>>? = null

    fun getChildList(): MutableLiveData<ArrayList<ChildModel.DataBean>> {
        if (mChildList == null) {
            mChildList = MutableLiveData()
            mRepository.getChildList(getApplication()) {
                mChildList!!.value = it
            }
        }
        return mChildList as MutableLiveData<ArrayList<ChildModel.DataBean>>
    }

}