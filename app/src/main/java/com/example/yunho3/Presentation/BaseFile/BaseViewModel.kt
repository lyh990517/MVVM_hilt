package com.example.yunho3.Presentation.BaseFile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel() {
    abstract fun fetchData(): Job
}