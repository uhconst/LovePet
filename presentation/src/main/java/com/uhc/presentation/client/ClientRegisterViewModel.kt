package com.uhc.presentation.client

import androidx.lifecycle.MutableLiveData
import com.uhc.presentation.ui.base.BaseViewModel

/**
 * Created by Constancio on 2019-05-25.
 */
class ClientRegisterViewModel : BaseViewModel() {
    val name = MutableLiveData<String>()

}