package com.natashaval.futuredatabinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natashaval.futuredatabinding.ProfileActivity.Companion.FIRST_NAME_KEY
import com.natashaval.futuredatabinding.ProfileActivity.Companion.LAST_NAME_KEY
import com.natashaval.futuredatabinding.adapter.ScoreAdapter
import com.natashaval.futuredatabinding.databinding.ActivityMainBinding
import com.natashaval.futuredatabinding.model.User
import com.natashaval.futuredatabinding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

  private val viewModel by lazy {
    ViewModelProviders.of(this).get(MainViewModel::class.java)
  };
  private lateinit var mRecyclerView: RecyclerView;
  private lateinit var mAdapter: ScoreAdapter;
  private lateinit var scoreList: Array<String>;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // TODO: A3. change how to inflate with DataBinding
    //setContentView(R.layout.activity_main)
    val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    // TODO: A4. bind user and score data with name UI
//    val firstNameText = findViewById<TextView>(R.id.tv_first_name)
//    firstNameText.text = user.firstName

//    val lastNameText = findViewById<TextView>(R.id.tv_last_name)
//    lastNameText.text = user.lastName

//    score = findViewById<TextView>(R.id.tv_score)
//    score.text = user.score.toString()

    binding.lifecycleOwner = this
    binding.viewModel = viewModel;
    binding.activity = this
//    binding.btScorePlus.setOnClickListener {
//      viewModel.updateScore(1)
//    }
//
//    binding.btScoreMinus.setOnClickListener {
//      viewModel.updateScore(-1)
//    }

    mRecyclerView = findViewById(R.id.recycleView_score_board);

  }

//  TODO: A5. implement event handling Method References when clicking Activity button
  fun openActivity(view: View) {
    val intent = Intent(this, ProfileActivity::class.java)
    intent.putExtra(FIRST_NAME_KEY, viewModel.user.firstName)
    intent.putExtra(LAST_NAME_KEY, viewModel.user.lastName)
    startActivity(intent)
  }

  // TODO: A6. implement setOnClickListener to Fragment button
  fun openFragment() {
    val fragment = ProfileFragment.newInstance(viewModel.user.firstName, viewModel.user.lastName)
    fragment.show(supportFragmentManager, ProfileFragment.TAG)
  }

  fun updateScore(value: Int) {
    viewModel.updateScore(value);
  }

  fun generateScoreList(total: Int){
    //wordlist
    scoreList = Array(total+1, {i -> (i*1).toString()})
    mAdapter = ScoreAdapter(scoreList, object: ScoreAdapter.CellClickListner{
      override fun onCellClickListener(position: Int, view: View) {
        Log.d("Masuk Klik", "Klik Item Vieew");
        redirectToActivity(position);
      }
    });
    mRecyclerView.setAdapter(mAdapter);
    mRecyclerView.layoutManager = LinearLayoutManager(this);
  }

  fun redirectToActivity(position: Int){
    val intent = Intent(this, ScoreActivity::class.java);
    intent.putExtra("score", scoreList[position]);
    startActivity(intent);
  }
}