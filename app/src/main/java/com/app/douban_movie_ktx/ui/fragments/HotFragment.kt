package com.app.douban_movie_ktx.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.app.douban_movie_ktx.R
import com.app.douban_movie_ktx.databinding.HotFragmentBinding
import com.app.douban_movie_ktx.ui.fragments.hot.ComingSoonFragment
import com.app.douban_movie_ktx.ui.fragments.hot.InTheatersFragment
import com.google.android.material.tabs.TabLayout

class HotFragment : Fragment() {


    private lateinit var binding: HotFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HotFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager.offscreenPageLimit = 2

        val tabs: TabLayout = view.findViewById(R.id.tabs)
        tabs.setupWithViewPager(binding.viewpager)
        binding.viewpager.adapter = HotAdapter(childFragmentManager, listOf("正在热映", "即将上映"));

    }


    inner class HotAdapter(fm: FragmentManager, private val labels: List<String>) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getCount() = labels.size

        override fun getItem(position: Int): Fragment = when (position) {
            0 -> InTheatersFragment()
            1 -> ComingSoonFragment()
            else -> throw IllegalStateException()
        }

        override fun getPageTitle(position: Int): CharSequence = labels[position]
    }
}

