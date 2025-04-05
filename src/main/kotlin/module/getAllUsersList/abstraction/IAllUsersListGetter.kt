package module.getAllUsersList.abstraction

import microkernel.database.model.GitHubUser

interface IAllUsersListGetter {

    fun getAllUsersList(): List<GitHubUser>
}