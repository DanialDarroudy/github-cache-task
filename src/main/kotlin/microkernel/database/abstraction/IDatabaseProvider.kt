package microkernel.database.abstraction

import microkernel.database.model.GitHubUser

interface IDatabaseProvider {
    fun addGitHubUser(user: GitHubUser)
    val allGitHubUsers: Map<String, GitHubUser>
}