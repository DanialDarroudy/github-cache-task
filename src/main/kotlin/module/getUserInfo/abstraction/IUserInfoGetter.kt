package module.getUserInfo.abstraction

import microkernel.database.model.GitHubUser

interface IUserInfoGetter {

    suspend fun getUserInfo(userName: String): GitHubUser?
}