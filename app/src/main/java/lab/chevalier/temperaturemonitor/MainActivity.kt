package lab.chevalier.temperaturemonitor

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import lab.chevalier.temperaturemonitor.adapter.PBSAdapter
import lab.chevalier.temperaturemonitor.api.ApiStatus
import lab.chevalier.temperaturemonitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = PBSAdapter()

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = DataBindingUtil.setContentView(this, (R.layout.activity_main))
        this.binding.rvData.apply {
            this.adapter = this@MainActivity.adapter
            this.layoutManager = LinearLayoutManager(this@MainActivity)
        }
        this.initViewModel()
    }

    private fun initViewModel() {
        this.viewModel.apply {
            this.getFeeds().observe(this@MainActivity, { this@MainActivity.adapter.setData(it) })
            this.getApiStatus().observe(this@MainActivity, { this@MainActivity.updateProgress(it) })
        }
    }

    private fun updateProgress(status: ApiStatus) {
        this.binding.apply {
            when (status) {
                ApiStatus.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                }
                ApiStatus.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    rvData.visibility = View.VISIBLE
                }
                ApiStatus.FAILED -> {
                    progressBar.visibility = View.GONE
                }
            }
        }
    }
}