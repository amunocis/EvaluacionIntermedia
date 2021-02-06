package com.example.evaluacinintermedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.evaluacinintermedia.databinding.FragmentFirstBinding
import android.widget.NumberPicker


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var mBinding: FragmentFirstBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFirstBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return mBinding.root
        mBinding.spCtd.minValue = 1
        mBinding.spCtd.maxValue = 100
        mBinding.spCtd.value = 10
        mBinding.spCtd.displayedValues = values
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}