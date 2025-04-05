package microkernel.api.abstraction

import microkernel.api.dto.GetPublicRepositoyResponse
import microkernel.api.dto.GetUserInformationResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface IGitHubApi {
    @GET("/users/{username}")
    suspend fun getUserInformation(@Path("username") user: String): GetUserInformationResponse

    @GET("/users/{username}/repos")
    suspend fun getPublicRepositoriesList(@Path("username") user: String): List<GetPublicRepositoyResponse>
}