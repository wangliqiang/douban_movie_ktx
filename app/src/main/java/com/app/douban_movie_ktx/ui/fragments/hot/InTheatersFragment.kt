package com.app.douban_movie_ktx.ui.fragments.hot


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.douban_movie_ktx.databinding.FragmentInTheatersBinding
import com.app.douban_movie_ktx.ui.adapters.InTheatersAdapter
import com.app.douban_movie_ktx.ui.viewmodels.InTheatersViewModel

/**
 * A simple [Fragment] subclass.
 */
class InTheatersFragment : Fragment() {

    private lateinit var viewModel: InTheatersViewModel
    private lateinit var binding: FragmentInTheatersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInTheatersBinding.inflate(inflater)

        viewModel = ViewModelProvider.NewInstanceFactory().create(InTheatersViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        var inTheatersAdapter = InTheatersAdapter();

        binding.recyclerview.adapter = inTheatersAdapter

        viewModel.InTheatersData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                inTheatersAdapter.submitList(it.subjects);
            }
        })

        return binding.root
    }


}
