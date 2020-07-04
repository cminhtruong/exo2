package app.el_even.com.exo1.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import app.el_even.com.exo1.R
import app.el_even.com.exo1.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ListFragmentBinding>(
            inflater,
            R.layout.list_fragment,
            container,
            false
        )
        binding.resultVM = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.photoGrid.adapter = GithubAdapter()

        return binding.root
    }

}