package com.sdei.parentIn.viewModel

import android.app.Application
import com.sdei.parentIn.repositories.WelcomeRepository

class WelcomeViewModel(application: Application) : BaseViewModel(application = application) {

    private val mRepository: WelcomeRepository = WelcomeRepository()

    init {
        getSchoolList()
    }

     fun getSchoolList() {
        mRepository.getSchoolDataApi(getApplication())
    }

}