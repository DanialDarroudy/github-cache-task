package controller.business

import controller.abstraction.IProgramStarter
import microkernel.database.model.GitHubUser
import microkernel.dependencyInjection.DependencyProvider
import module.getAllUsersList.abstraction.IAllUsersListGetter
import module.getUserInfo.abstraction.IUserInfoGetter
import module.searchByRepository.abstraction.IByRepositorySearcher
import module.searchByUserName.abstraction.IByUserNameSearcher

class ProgramStarter : IProgramStarter {

    private val userInfoGetter: IUserInfoGetter = DependencyProvider.userInfoGetter
    private val allUsersListGetter: IAllUsersListGetter = DependencyProvider.allUsersListGetter
    private val byUserNameSearcher: IByUserNameSearcher = DependencyProvider.byUserNameSearcher
    private val byRepositorySearcher: IByRepositorySearcher = DependencyProvider.byRepositorySearcher

    override suspend fun startProgram() {
        var pageNumber = 0
        println("Hello, welcome to my program")
        while (pageNumber == 0) {
            println("Please write a number between 1 to 5")
            println()
            println("1.Get user information by username")
            println("2.Get list of all users in program")
            println("3.Search by username from all users in program")
            println("4.Search by repository name from all users in program")
            println("5.Exit program")
            pageNumber = readln().toInt()
            when (pageNumber) {
                1 -> {
                    getUserInformation()
                    pageNumber = 0
                }

                2 -> {
                    getAllUsersList()
                    pageNumber = 0
                }

                3 -> {
                    searchByUserName()
                    pageNumber = 0
                }

                4 -> {
                    searchByRepository()
                    pageNumber = 0
                }

                else -> {
                    println("Please write a number between 1 to 5")
                }
            }
        }
    }

    private suspend fun getUserInformation() {
        println("Please write username")
        val userName: String = readln()
        val gitHubUser: GitHubUser? = userInfoGetter.getUserInfo(userName)
        if (gitHubUser != null) {
            println(gitHubUser)
        } else {
            println("User not found")
        }

        println()
    }

    private fun getAllUsersList() {
        val allGitHubUsers: List<GitHubUser> = allUsersListGetter.getAllUsersList()
        println(allGitHubUsers)
        println()
    }

    private fun searchByUserName() {
        println("Please write username")
        val userName: String = readln()
        val gitHubUser: GitHubUser? = byUserNameSearcher.searchByUserName(userName)

        if (gitHubUser != null) {
            println(gitHubUser)
        } else {
            println("User not found")
        }

        println()
    }

    private fun searchByRepository() {
        println("Please write repository name")
        val repositoryName: String = readln()
        val gitHubUsers: List<GitHubUser> = byRepositorySearcher.searchByRepository(repositoryName)
        println(gitHubUsers)
        println()
    }

}