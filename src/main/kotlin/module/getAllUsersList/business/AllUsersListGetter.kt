package module.getAllUsersList.business

import microkernel.database.abstraction.IDatabaseProvider
import microkernel.database.model.GitHubUser
import microkernel.dependencyInjection.DependencyProvider
import module.getAllUsersList.abstraction.IAllUsersListGetter

class AllUsersListGetter : IAllUsersListGetter {

    private val database: IDatabaseProvider = DependencyProvider.database

    override fun getAllUsersList(): List<GitHubUser> {
        val allUsers = database.allGitHubUsers
        return allUsers.values.toList()
    }
}