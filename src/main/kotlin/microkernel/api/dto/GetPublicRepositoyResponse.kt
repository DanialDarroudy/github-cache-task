package microkernel.api.dto

import com.google.gson.annotations.SerializedName

data class GetPublicRepositoyResponse(
    @SerializedName("name") val RepositoryName: String
)
