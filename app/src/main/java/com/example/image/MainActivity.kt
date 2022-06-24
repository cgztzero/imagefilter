package com.example.image

import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.image.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private lateinit var adapter: FilterAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = FilterAdapter(this)
        binding.recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL;
        binding.recyclerView.layoutManager = layoutManager

        adapter.setItemClickListener(object : OnItemClickListener {
            override fun onClick(view: View, position: Int) {
                val paint = Paint()
                if (position == 0) {
                    paint.colorFilter = null
                } else {
                    paint.colorFilter = ColorMatrixColorFilter(FilterData.filters[position].filterArray!!)
                }
                binding.textView.setLayerType(View.LAYER_TYPE_HARDWARE, paint)
                binding.image.setLayerType(View.LAYER_TYPE_SOFTWARE, paint)
            }
        })
    }
}