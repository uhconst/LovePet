package com.uhc.presentation.ui.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Constancio on 2019-05-04.
 */
abstract class BaseFragment<B : ViewDataBinding> : Fragment() {
    protected lateinit var binding: B

    protected val compositeDisposable = CompositeDisposable()

    abstract fun getLayoutRes(): Int
}