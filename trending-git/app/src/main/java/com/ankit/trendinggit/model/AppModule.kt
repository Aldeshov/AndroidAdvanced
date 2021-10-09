package com.ankit.trendinggit.model

import com.ankit.trendinggit.view.ui.repolist.RepoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // single instance of RepoRepository
    single<RepoRepository> { RepoRepositoryImpl() }

    // RepoListViewModel ViewModel
    viewModel { RepoListViewModel(get()) }
}