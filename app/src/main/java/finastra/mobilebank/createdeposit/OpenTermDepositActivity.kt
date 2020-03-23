package finastra.mobilebank.createdeposit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.opentermdeposit_activity.*

class OpenTermDepositActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.opentermdeposit_activity)
        chosenDpProduct.text = intent.getStringExtra("chosenDpProduct")
    }
}