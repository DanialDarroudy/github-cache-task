package module.getUserInfo.business

import microkernel.api.abstraction.IGitHubApi
import microkernel.database.abstraction.IDatabaseProvider
import microkernel.database.model.GitHubUser
import microkernel.dependencyInjection.DependencyProvider
import module.getUserInfo.abstraction.IUserInfoGetter
import retrofit2.HttpException

class UserInfoGetter : IUserInfoGetter {

    private val database: IDatabaseProvider = DependencyProvider.database
    private val gitHubApi: IGitHubApi = DependencyProvider.gitHubApi

    override suspend fun getUserInfo(userName: String): GitHubUser? {
        val cachedGitHubUser = database.allGitHubUsers[userName]
        if (cachedGitHubUser != null){
            return cachedGitHubUser
        }
        try {
            val getUserInformationResponse = gitHubApi.getUserInformation(userName)
            val getPublicRepositoriesListResponse = gitHubApi.getPublicRepositoriesList(userName)
            val repositoryNames = mutableListOf<String>()
            for (response in getPublicRepositoriesListResponse){
                repositoryNames.add(response.RepositoryName)
            }
            val gitHubUser = GitHubUser(
                getUserInformationResponse.userName,
                getUserInformationResponse.followersNumber,
                getUserInformationResponse.followingNumber,
                getUserInformationResponse.accountCreatedDate,
                repositoryNames
            )
            database.addGitHubUser(gitHubUser)
            return gitHubUser
        } catch (e: HttpException) {
            println(e.response()?.errorBody()?.string())
            return null
        }catch (e: Exception) {
            println(e)
            return null
        }
    }
}