package com.hyden.daggersample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

open abstract class BaseFragment<B : ViewDataBinding>(
    private val layoutId : Int
) : Fragment() {


    abstract fun initEventHandler()
    abstract fun initBinding()

    lateinit var binding : B

//    val viewModel by viewModel<BaseViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater,layoutId,container,false)
        binding.lifecycleOwner = this
//        LayoutInflater.from(binding.root.context).inflate(R.layout.loading,container,false).let {
//            lottie = it.findViewById(R.id.lottie_loading)
//            lottie.playAnimation()
//        }


        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this@BaseFragment

        initEventHandler()
        initBinding()
    }


}