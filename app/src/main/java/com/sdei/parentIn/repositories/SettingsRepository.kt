package com.sdei.parentIn.repositories

import com.sdei.parentIn.model.ExportCsvModel
import com.sdei.parentIn.network.RetrofitClient
import com.sdei.parentIn.utils.handleJson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SettingsRepository {

    fun reqForCSV(id: String, returnValue: (ExportCsvModel) -> Unit) {
        RetrofitClient.instance!!.getCSVFile(id).enqueue(object : Callback<ExportCsvModel> {
            override fun onFailure(call: Call<ExportCsvModel>, t: Throwable) {
                returnValue(ExportCsvModel(t.message!!))
            }

            override fun onResponse(call: Call<ExportCsvModel>, response: Response<ExportCsvModel>) {
                when {
                    response.body() != null -> returnValue(response.body()!!)
                    response.errorBody() != null -> {
                        val (statusCode, message) = handleJson(response.errorBody()!!.string())
                        returnValue(ExportCsvModel(statusCode.toInt(), message))
                    }
                    else -> returnValue(ExportCsvModel(response.code(), response.message().toString()))
                }
            }

        })
    }
}