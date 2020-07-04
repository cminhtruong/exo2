package app.el_even.com.exo1.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.el_even.com.exo1.data.GithubRepo
import app.el_even.com.exo1.databinding.ResultItemBinding

class GithubAdapter : ListAdapter<GithubRepo, GithubAdapter.GithubViewHolder>(DiffCallBack) {

    inner class GithubViewHolder(private val binding: ResultItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(githubRepo: GithubRepo) {
            binding.model = githubRepo
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder =
        GithubViewHolder(
            ResultItemBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<GithubRepo>() {
        override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return oldItem.id == newItem.id
        }

    }
}