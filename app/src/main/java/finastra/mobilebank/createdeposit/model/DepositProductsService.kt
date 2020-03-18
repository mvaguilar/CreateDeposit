package finastra.mobilebank.createdeposit.model

import finastra.mobilebank.createdeposit.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class DepositProductsService {
    @Inject
    lateinit var api: DepositProductsApi
    init {
        DaggerApiComponent.create().inject(this)
    }
    fun getDepositProducts(): Single<Data> {
        return api.getDepositProducts()
    }

}