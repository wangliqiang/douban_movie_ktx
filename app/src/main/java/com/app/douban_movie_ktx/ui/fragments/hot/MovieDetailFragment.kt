package com.app.douban_movie_ktx.ui.fragments.hot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.douban_movie_ktx.R
import com.app.douban_movie_ktx.data.model.Subject
import com.app.douban_movie_ktx.ui.viewmodels.MovieDetailViewModel

class MovieDetailFragment : Fragment() {

    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider.NewInstanceFactory().create(MovieDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }
}