package com.jetpack.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.viewbinding.ViewBindings
import com.jetpack.first.R.layout
import com.jetpack.first.databinding.FragmentMainBinding
import com.jetpack.first.viewmodel.LoginParaViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
const val ARG_PARAM1 = "ARG_PARAM1"
const val ARG_PARAM2 = "ARG_PARAM2"

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var param1: String? = null
    private var param2: String? = null
    private val loginParaViewModel by activityViewModels<LoginParaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.let {
            binding = FragmentMainBinding.inflate(inflater)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginParaViewModel.viewModelScope.launch {
            delay(500)
            binding.tvMainFragmentShow.text = "activity中使用viewModel的协程"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}