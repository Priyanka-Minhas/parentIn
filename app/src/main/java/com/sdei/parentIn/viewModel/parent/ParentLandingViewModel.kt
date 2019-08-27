package com.sdei.parentIn.viewModel.parent

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.repositories.ParentLandingRepository
import com.sdei.parentIn.viewModel.BaseViewModel

class ParentLandingViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: ParentLandingRepository = ParentLandingRepository()


    private var mChildModel: MutableLiveData<ChildModel>? = null

    fun getChild(): MutableLiveData<ChildModel> {
        if (mChildModel == null) {
            mChildModel = MutableLiveData()
        }
        return mChildModel as MutableLiveData<ChildModel>
    }

    fun hitChildListApi(id:String) {
        mRepository.getChildApi(id) {
            mChildModel!!.value = it
        }
    }


}