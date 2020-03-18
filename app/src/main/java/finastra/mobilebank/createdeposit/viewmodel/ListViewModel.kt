package finastra.mobilebank.createdeposit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import finastra.mobilebank.createdeposit.di.DaggerApiComponent
import finastra.mobilebank.createdeposit.model.Data
import finastra.mobilebank.createdeposit.model.DepositProduct
import finastra.mobilebank.createdeposit.model.DepositProductsService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel: ViewModel() {
    @Inject
    lateinit var depositProductsService: DepositProductsService
    init {
        DaggerApiComponent.create().inject(this)
    }
    private val disposable = CompositeDisposable()
    val dpProducts = MutableLiveData<List<DepositProduct>>()
    val dpProductsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchDepositProducts()
    }

    private fun fetchDepositProducts() {
        loading.value = true
        disposable.add(
            depositProductsService.getDepositProducts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Data>() {
                    override fun onSuccess(data: Data) {
                        Log.d("error ", "" + data)
                        dpProducts.value = data.dpProducts
                        dpProductsLoadError.value = false
                        loading.value = false
                    }
                    override fun onError(e: Throwable) {
                        dpProductsLoadError.value = true
                        loading.value = false
                        Log.d("error ", "" + e.printStackTrace())
                    }
                })
        )
    }
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}