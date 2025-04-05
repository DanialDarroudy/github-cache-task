package microkernel.database.business

import microkernel.database.abstraction.IDatabaseProvider
import microkernel.database.model.GitHubUser

class DatabaseProvider : IDatabaseProvider {
    private val gitHubUsers = mutableMapOf<String, GitHubUser>()

    override fun addGitHubUser(user: GitHubUser){
        gitHubUsers[user.userName] = user
    }

    override val allGitHubUsers: Map<String, GitHubUser>
        get() = gitHubUsers
}