package com.df.mppixpay.util.di

import com.df.mppixpay.data.api.ApiService
import com.df.mppixpay.data.repository.PixMainIMPL
import com.df.mppixpay.data.repository.PixMainREPO
import com.df.mppixpay.ui.PixMainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        PixMainViewModel(get())
    }
}

val repositoryesModule = module {
    single { PixMainREPO(api = get()) } bind PixMainIMPL::class
}

val apisModule = module {
    single { ApiService.callApi }
}