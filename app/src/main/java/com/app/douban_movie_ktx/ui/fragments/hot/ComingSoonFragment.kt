package com.app.douban_movie_ktx.ui.fragments.hot


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.douban_movie_ktx.databinding.FragmentComingSoonBinding
import com.app.douban_movie_ktx.ui.adapters.CommingSoonAdapter
import com.app.douban_movie_ktx.ui.viewmodels.ComingSoonViewModel

/**
 * A simple [Fragment] subclass.
 */
class ComingSoonFragment : Fragment() {

    private lateinit var viewModel: ComingSoonViewModel
    private lateinit var binding: FragmentComingSoonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentComingSoonBinding.inflate(inflater)
        viewModel = ViewModelProvider.NewInstanceFactory().create(ComingSoonViewModel::class.java)

        binding.lifecycleOwner = this
        binding.vm = viewModel

        var commingSoonAdapter = CommingSoonAdapter();

        binding.recyclerview.adapter = commingSoonAdapter

        viewModel.commingSoonData.observe(viewLifecycleOwner, Observer {
            commingSoonAdapter.submitList(it?.subjects);
        })
        return binding.root
    }
}