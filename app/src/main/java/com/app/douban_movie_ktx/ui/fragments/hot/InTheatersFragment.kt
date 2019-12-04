package com.app.douban_movie_ktx.ui.fragments.hot

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.douban_movie_ktx.databinding.FragmentInTheatersBinding
import com.app.douban_movie_ktx.ui.adapters.InTheatersAdapter
import com.app.douban_movie_ktx.ui.fragments.HotFragmentDirections
import com.app.douban_movie_ktx.ui.viewmodels.InTheatersViewModel

/**
 * A simple [Fragment] subclass.
 */
class InTheatersFragment : Fragment() {

    private lateinit var viewModel: InTheatersViewModel
    private lateinit var binding: FragmentInTheatersBinding
    private lateinit var inTheatersAdapter: InTheatersAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInTheatersBinding.inflate(inflater)
        viewModel =
            ViewModelProvider.NewInstanceFactory().create(InTheatersViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        inTheatersAdapter = InTheatersAdapter()

        binding.recyclerview.apply {
            adapter = this@InTheatersFragment.inTheatersAdapter
            setRecycledViewPool(RecyclerView.RecycledViewPool())
            (layoutManager as LinearLayoutManager).recycleChildrenOnDetach = true
            (itemAnimator as DefaultItemAnimator).run {
                supportsChangeAnimations = false
                addDuration = 160L
                moveDuration = 160L
                changeDuration = 160L
                removeDuration = 120L
            }
        }

        viewModel.theatersData.observe(viewLifecycleOwner, Observer {
            inTheatersAdapter.submitList(it?.subjects);
        })
        return binding.root
    }

    class ClickProxy {
        fun toMovieDetail(id: String, view: View) {
            val action = HotFragmentDirections.actionHotFragmentToMovieDetailFragment(id)
            findNavController(view).navigate(action)
        }
    }

}