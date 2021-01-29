package com.natashaval.futuredatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natashaval.futuredatabinding.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScoreBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater);
        setContentView(binding.root);

        if(intent.getStringExtra("score") != null){
            binding.scoreTv.text = intent.getStringExtra("score");
        }
    }
}