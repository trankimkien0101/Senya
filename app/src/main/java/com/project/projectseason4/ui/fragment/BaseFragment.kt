package com.project.projectseason4.ui.fragment

import androidx.fragment.app.Fragment
import com.project.projectseason4.data.Attraction
import com.project.projectseason4.ui.MainActivity

abstract class BaseFragment : Fragment() {
    protected val navController by lazy {
        (activity as MainActivity).navController
    }

    protected val attractions : List<Attraction>
    get() = (activity as MainActivity).attractionList
}