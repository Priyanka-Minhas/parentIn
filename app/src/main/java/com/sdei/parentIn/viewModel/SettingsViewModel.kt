package com.sdei.parentIn.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sdei.parentIn.model.ExportCsvModel
import com.sdei.parentIn.repositories.SettingsRepository

class SettingsViewModel(application: Application) : BaseViewModel(application = application) {
    private val mRepository: SettingsRepository = SettingsRepository()
    private var exportCsvLiveData: MutableLiveData<ExportCsvModel>? = null
    // export csv
    fun sendReqForCSVFile(id: String?): MutableLiveData<ExportCsvModel> {
        if (exportCsvLiveData == null) {
            exportCsvLiveData = MutableLiveData()
            mRepository.reqForCSV(id!!) {
                exportCsvLiveData!!.value = it
            }
        }
        return exportCsvLiveData as MutableLiveData<ExportCsvModel>
    }
}