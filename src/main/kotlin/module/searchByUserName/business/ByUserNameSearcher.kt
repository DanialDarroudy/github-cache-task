package module.searchByUserName.business

import microkernel.database.abstraction.IDatabaseProvider
import microkernel.database.model.GitHubUser
import microkernel.dependencyInjection.DependencyProvider
import module.searchByUserName.abstraction.IByUserNameSearcher

class ByUserNameSearcher: IByUserNameSearcher {

    private val database: IDatabaseProvider = DependencyProvider.database

    override fun searchByUserName(userName: String): GitHubUser? {
        val allUsers = database.allGitHubUsers
        return allUsers[userName]
    }
}