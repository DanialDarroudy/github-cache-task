package microkernel.api.dto

import com.google.gson.annotations.SerializedName
import java.util.Date

data class GetUserInformationResponse(
    @SerializedName("login") val userName: String,
    @SerializedName("followers") val followersNumber: Int,
    @SerializedName("following") val followingNumber: Int,
    @SerializedName("created_at") val accountCreatedDate: Date
)
