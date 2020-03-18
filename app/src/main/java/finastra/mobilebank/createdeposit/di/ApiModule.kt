package finastra.mobilebank.createdeposit.di

import android.content.res.Resources
import dagger.Module
import dagger.Provides
import finastra.mobilebank.createdeposit.R
import finastra.mobilebank.createdeposit.model.DepositProductsApi
import finastra.mobilebank.createdeposit.model.DepositProductsService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val BASE_URL = "https://reqres.in/api/"
    @Provides
    fun provideDepositProductApi(): DepositProductsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DepositProductsApi::class.java)
        val result:String = Resources.getSystem().getString(R.string.sampleData)
//        return result
    }
    @Provides
    fun provideDepositProductsService(): DepositProductsService {
        return DepositProductsService()
    }


}