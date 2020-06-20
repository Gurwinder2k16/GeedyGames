package com.assignment.assignment.di.module.fragment

import com.assignment.assignment.module.fragments.DetailFragment
import com.assignment.assignment.module.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment
}