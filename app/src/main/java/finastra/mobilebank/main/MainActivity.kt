package finastra.mobilebank.main

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import finastra.mobilebank.createdeposit.CreateDepositActivity
import finastra.mobilebank.createdeposit.R
import finastra.mobilebank.createdeposit.model.DepositProduct
import finastra.mobilebank.createdeposit.view.OnItemClickListener
import finastra.mobilebank.createdeposit.view.ProductListAdapter
import finastra.mobilebank.createdeposit.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_button.setOnClickListener {
            val intent = Intent(this, CreateDepositActivity::class.java)
            startActivity(intent)
        }
    }
}
