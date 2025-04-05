package module.searchByRepository.business

import microkernel.database.abstraction.IDatabaseProvider
import microkernel.database.model.GitHubUser
import microkernel.dependencyInjection.DependencyProvider
import module.searchByRepository.abstraction.IByRepositorySearcher

class ByRepositorySearcher: IByRepositorySearcher {

    private val database: IDatabaseProvider = DependencyProvider.database

    override fun searchByRepository(repositoryName: String): List<GitHubUser> {
        val allUsers = database.allGitHubUsers.values.toList()
        val result = mutableListOf<GitHubUser>()
        for (user in allUsers){
            if(user.publicRepositoriesList.contains(repositoryName)){
                result.add(user)
            }
        }
        return result
    }

}