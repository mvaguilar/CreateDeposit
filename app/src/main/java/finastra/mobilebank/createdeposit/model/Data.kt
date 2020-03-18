package finastra.mobilebank.createdeposit.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    val dpProducts: List<DepositProduct>
)