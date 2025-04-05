package microkernel.database.model

import java.util.Date

data class GitHubUser(
    val userName: String,
    var followersNumber: Int,
    var followingNumber: Int,
    val accountCreatedDate: Date,
    var publicRepositoriesList: MutableList<String>
)
