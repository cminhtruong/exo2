package app.el_even.com.exo1.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import app.el_even.com.exo1.MainFragmentDirections
import app.el_even.com.exo1.R
import app.el_even.com.exo1.databinding.MainFragmentBinding

/**
 * First fragment of my application
 *
 * @author el_even
 * @version 1.0
 * @since 27/06/2020
 */
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MainFragmentBinding>(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.isButtonClicked.observe(viewLifecycleOwner, Observer { isCliked ->
            if (isCliked) {
                view?.findNavController()
                    ?.navigate(MainFragmentDirections.actionMainFragmentToListFragment())
                viewModel.navigateToListGithubDone()
            }
        })

        return binding.root
    }

}