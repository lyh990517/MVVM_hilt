package com.example.yunho3.Presentation.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isGone
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yunho3.DataSource.Entity.DataEntity
import com.example.yunho3.Presentation.BaseFile.BaseActivity
import com.example.yunho3.Presentation.DataState
import com.example.yunho3.Presentation.ViewModel.MainViewModel
import com.example.yunho3.R
import com.example.yunho3.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.androidx.viewmodel.ext.android.viewModel
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
internal class MainActivity : BaseActivity<MainViewModel>(),CoroutineScope {

    private val Adapter = DataAdapter()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override val viewModel: MainViewModel by viewModels()

    override fun observeData() {
        viewModel.LiveData.observe(this){
            when(it){
                is DataState.Uninitialized ->{
                    initViews()
                }
                is DataState.Loading ->{
                    handleLoading()
                }
                is DataState.Success ->{
                    handleSuccess(it)
                }
                is DataState.Delete ->{
                    handleDelete()
                }
                is DataState.Error ->{

                }
            }
        }
    }

    private fun handleDelete() {
        viewModel.fetchData()
        Toast.makeText(this,"Deleted!!",Toast.LENGTH_SHORT).show()
    }

    private fun handleSuccess(state: DataState.Success) = with(binding) {
        refresh.isRefreshing = false
        refresh.isEnabled = state.Data.isNotEmpty()
        recycler.isGone = state.Data.isEmpty()
        empty.isGone = state.Data.isNotEmpty()

        Adapter.setData(
            state.Data,
            Listener = {
                viewModel.deleteOne(it.id)
            }
        )

    }

    private fun handleLoading() {
        binding.refresh.isRefreshing = true
    }

    private fun initViews() = with(binding){
        recycler.adapter = Adapter
        recycler.layoutManager = LinearLayoutManager(this@MainActivity)

        refresh.setOnRefreshListener {
            viewModel.fetchData()
        }

        inputButton.setOnClickListener {
            val entity = DataEntity(Data = input.text.toString())
            viewModel.insertOne(entity)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()
}