package com.sdei.parentIn.viewModel.parent

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.repositories.parent.ParentChildrenRepository
import com.sdei.parentIn.viewModel.BaseViewModel

class ParentChildrenViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: ParentChildrenRepository = ParentChildrenRepository()

    private var mChildModel: MutableLiveData<ChildModel>? = null

    fun getChild(): MutableLiveData<ChildModel> {
        if (mChildModel == null) {
            mChildModel = MutableLiveData()
        }
        return mChildModel as MutableLiveData<ChildModel>
    }

    fun hitChildListApi(id:String) {
        mRepository.getChildApi(id,getApplication()) {
            mChildModel!!.value = it
        }
    }


}