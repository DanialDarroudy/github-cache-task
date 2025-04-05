package microkernel.dependencyInjection

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import controller.abstraction.IProgramStarter
import controller.business.ProgramStarter
import microkernel.api.abstraction.IGitHubApi
import microkernel.database.abstraction.IDatabaseProvider
import microkernel.database.business.DatabaseProvider
import module.getAllUsersList.abstraction.IAllUsersListGetter
import module.getAllUsersList.business.AllUsersListGetter
import module.getUserInfo.abstraction.IUserInfoGetter
import module.getUserInfo.business.UserInfoGetter
import module.searchByRepository.abstraction.IByRepositorySearcher
import module.searchByRepository.business.ByRepositorySearcher
import module.searchByUserName.abstraction.IByUserNameSearcher
import module.searchByUserName.business.ByUserNameSearcher

object DependencyProvider {
    val starter: IProgramStarter by lazy {
        ProgramStarter()
    }
    val database: IDatabaseProvider by lazy {
        DatabaseProvider()
    }
    val userInfoGetter: IUserInfoGetter by lazy {
        UserInfoGetter()
    }
    val allUsersListGetter: IAllUsersListGetter by lazy {
        AllUsersListGetter()
    }
    val byUserNameSearcher: IByUserNameSearcher by lazy {
        ByUserNameSearcher()
    }
    val byRepositorySearcher: IByRepositorySearcher by lazy {
        ByRepositorySearcher()
    }
    private val gson: Gson by lazy {
        GsonBuilder()
            .setPrettyPrinting()
            .create()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val gitHubApi: IGitHubApi by lazy {
        retrofit.create(IGitHubApi::class.java)
    }
}