package finastra.mobilebank.createdeposit

import android.os.Bundle
import android.view.View.GONE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import finastra.mobilebank.createdeposit.model.DepositProduct
import finastra.mobilebank.createdeposit.view.OnItemClickListener
import finastra.mobilebank.createdeposit.view.ProductListAdapter
import finastra.mobilebank.createdeposit.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OnItemClickListener {

    lateinit var viewModel: ListViewModel
    private val productsAdapter = ProductListAdapter(arrayListOf(), this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sampleData()

        dpProductsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = productsAdapter
        }
        val itemDecor = DividerItemDecoration(dpProductsList.context, VERTICAL)
        dpProductsList.addItemDecoration(itemDecor)

//        observeViewModel()
    }

    override fun onItemClicked(depositProducts: DepositProduct) {
        Toast.makeText(this,"Product: ${depositProducts.productName} \n ${depositProducts.desc}",Toast.LENGTH_LONG)
            .show()
    }

    private fun sampleData() {
        val sampleDepositProducts = mutableListOf<DepositProduct>()
        sampleDepositProducts.add(DepositProduct(0, "Fixed Term Deposit","Standard Term Deposit"))
        sampleDepositProducts.add(DepositProduct(1, "Demand Deposit","A deposit of money that can be withdrawn without prior notice."))
        sampleDepositProducts.add(DepositProduct(2, "Tax Saver Deposit","You can get tax deduction"))
        sampleDepositProducts.add(DepositProduct(2, "1 Year Bond","Minimum 10000 GBP for a 1 year term"))
        val newDepositProducts: List<DepositProduct> = sampleDepositProducts
        productsAdapter.updateDepositProducts(newDepositProducts);
        list_error.visibility = GONE
        loading_view.visibility = GONE
    }

//    fun observeViewModel() {
//        viewModel.dpProducts.observe(this, Observer { dpProducts ->
//            dpProducts?.let {
//                dpProductsList.visibility = View.VISIBLE
//                productsAdapter.updateDepositProducts(it)
//            }
//        })
//        viewModel.dpProductsLoadError.observe(this, Observer { isError ->
//            isError?.let { list_error.visibility = if (it) View.VISIBLE else View.GONE }
//        })
//        viewModel.loading.observe(this, Observer { isLoading ->
//            isLoading?.let {
//                loading_view.visibility = if (it) View.VISIBLE else View.GONE
//                if (it) {
//                    list_error.visibility = View.GONE
//                    dpProductsList.visibility = View.GONE
//                }
//            }
//        })
//    }

}
