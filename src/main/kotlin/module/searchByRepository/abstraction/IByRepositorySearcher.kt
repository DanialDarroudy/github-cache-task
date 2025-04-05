package module.searchByRepository.abstraction

import microkernel.database.model.GitHubUser

interface IByRepositorySearcher {

    fun searchByRepository(repositoryName: String): List<GitHubUser>
}