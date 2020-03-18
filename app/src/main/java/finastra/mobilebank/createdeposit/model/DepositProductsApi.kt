package finastra.mobilebank.createdeposit.model

import io.reactivex.Single
import retrofit2.http.GET

interface DepositProductsApi {
    @GET("depositProducts")
    fun getDepositProducts(): Single<Data>
}