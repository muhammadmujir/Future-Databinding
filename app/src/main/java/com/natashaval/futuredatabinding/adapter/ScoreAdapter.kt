package com.natashaval.futuredatabinding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.natashaval.futuredatabinding.R
import kotlinx.android.synthetic.main.score_item.view.*

class ScoreAdapter(private val dataSet: Array<String>, private val cellClickListener: ScoreAdapter.CellClickListner)
    : RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {
    inner class ScoreViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        val textView: TextView
        init {
            textView = view.findViewById(R.id.tv_score_item)
        }

        override fun onClick(p0: View?) {
            var position: Int = adapterPosition;
            cellClickListener.onCellClickListener(position, p0!!);
        }

    }

    interface CellClickListner{
        fun onCellClickListener(position: Int, view: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.score_item, parent, false);
        return ScoreViewHolder(view);
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        holder.textView.text = dataSet.get(position);
        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickListener(position, it);
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}