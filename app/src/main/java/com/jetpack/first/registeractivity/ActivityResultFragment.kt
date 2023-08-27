package com.jetpack.first.registeractivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.jetpack.first.R
import org.w3c.dom.Text

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ActivityResultFragment : Fragment() {
    private val TAG = "ActivityResultFragment"
    private var param1: String? = null
    private var param2: String? = null
    private var tvFragmentResult: TextView? = null
    private val activityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == ACTIVITY_RESULT_CODE) {
                val key = it.data?.getStringExtra("key")
                val num = it.data?.getIntExtra("num", 0)
                tvFragmentResult?.text = "key:$key..num:$num"
                Log.i(TAG, "key:$key..num:$num ")
            }
        }

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
        val view = inflater.inflate(R.layout.fragment_activity_result, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View?) {
        tvFragmentResult = view?.findViewById<TextView>(R.id.tv_fragment_result)
        view?.findViewById<Button>(R.id.bt_fragment_to_activity)?.setOnClickListener {
            activityLauncher.launch(Intent(requireContext(), RegisterToActivity::class.java))
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ActivityResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}