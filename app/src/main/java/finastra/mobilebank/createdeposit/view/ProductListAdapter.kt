package finastra.mobilebank.createdeposit.view

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import finastra.mobilebank.createdeposit.R
import finastra.mobilebank.createdeposit.model.DepositProduct
import kotlinx.android.synthetic.main.item_product.view.*

class ProductListAdapter(var depositProducts: ArrayList<DepositProduct>, val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    fun updateDepositProducts(newDepositProducts: List<DepositProduct>) {
        depositProducts.clear()
        depositProducts.addAll(newDepositProducts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ProductViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
    )

    override fun getItemCount() = depositProducts.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(depositProducts[position], itemClickListener)
    }

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val productName = view.name
        private val productDesc = view.desc
        fun bind(depositProduct: DepositProduct, clickListener: OnItemClickListener) {
            productName.text = depositProduct.productName
            if(depositProduct.desc.isNotEmpty()) {
                productDesc.text = depositProduct.desc
            } else {
                super.itemView.desc.visibility = GONE
            }

            itemView.setOnClickListener {
                clickListener.onItemClicked(depositProduct)
            }
        }

    }
}

interface OnItemClickListener{
    fun onItemClicked(depositProducts: DepositProduct)
}