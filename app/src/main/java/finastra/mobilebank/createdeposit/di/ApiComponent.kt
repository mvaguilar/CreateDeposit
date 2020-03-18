package finastra.mobilebank.createdeposit.di

import dagger.Component
import finastra.mobilebank.createdeposit.model.DepositProductsService
import finastra.mobilebank.createdeposit.viewmodel.ListViewModel

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: DepositProductsService)
    fun inject(viewModel: ListViewModel)
}