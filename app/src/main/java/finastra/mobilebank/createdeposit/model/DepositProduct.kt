package finastra.mobilebank.createdeposit.model

import com.google.gson.annotations.SerializedName

data class DepositProduct (@SerializedName("id")
                           val id: Int,
                           @SerializedName("productName")
                           val productName: String,
                           @SerializedName("description")
                           val desc: String)