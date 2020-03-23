package finastra.mobilebank.main

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.deh_kotlin_mpp.*
import finastra.mobilebank.createdeposit.CreateDepositActivity
import finastra.mobilebank.createdeposit.R
import finastra.mobilebank.createdeposit.model.DepositProduct
import finastra.mobilebank.createdeposit.view.OnItemClickListener
import finastra.mobilebank.createdeposit.view.ProductListAdapter
import finastra.mobilebank.createdeposit.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_activity.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        login_button.setOnClickListener {
            if (username_edit_text.text!!.isNotEmpty() && password_edit_text.text!!.isNotEmpty()) {
                Toast.makeText(this, "MPP: "+onLoginSuccess(),Toast.LENGTH_LONG).show()
                val intent = Intent(this, CreateDepositActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "MPP: "+onLoginFail(),Toast.LENGTH_LONG).show()
            }
        }

        create_button.setOnClickListener {
            if (username_edit_text.text!!.isNotEmpty() && password_edit_text.text!!.isNotEmpty()) {
                Toast.makeText(this, "MPP: " + onRegSuccess(), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "MPP: " + onRegFail(), Toast.LENGTH_LONG).show()
            }
        }
    }
}
