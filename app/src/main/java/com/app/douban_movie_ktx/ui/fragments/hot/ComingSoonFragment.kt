package com.app.douban_movie_ktx.ui.fragments.hot


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.app.douban_movie_ktx.R

/**
 * A simple [Fragment] subclass.
 */
class ComingSoonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coming_soon, container, false)
    }


}
