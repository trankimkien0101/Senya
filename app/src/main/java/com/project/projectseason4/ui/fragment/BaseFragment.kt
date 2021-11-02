package com.project.projectseason4.ui.fragment

import androidx.fragment.app.Fragment
import com.project.projectseason4.ui.MainActivity

abstract class BaseFragment : Fragment() {
    protected val navController by lazy {
        (activity as MainActivity).navController
    }
}