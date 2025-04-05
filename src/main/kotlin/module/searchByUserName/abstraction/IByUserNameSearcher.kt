package module.searchByUserName.abstraction

import microkernel.database.model.GitHubUser

interface IByUserNameSearcher {

    fun searchByUserName(userName: String): GitHubUser?
}