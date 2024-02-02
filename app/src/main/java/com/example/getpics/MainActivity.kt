package com.example.getpics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.Companion
import com.example.getpics.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var contracts: ActivityResultContracts
    private val imageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        // Handle the selected image URI: display it, upload it, etc.
        if (uri != null) {
            binding.imageView.setImageURI(uri)
            // ... other processing
        }
    }
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.chooseBtn.setOnClickListener {
                getImage()
        }


    }

    private fun getImage() {


// Launch the image picker when appropriate:
        imageLauncher.launch("image/*")

    }
}