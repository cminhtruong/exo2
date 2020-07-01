package app.el_even.com.exo1

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.github.com/search/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface GithubService {
    @GET("repositories?q=language:kotlin&sort=stars&order=desc&page=1&per_page=10")
    fun getAllGithubRepo(): Call<String>
}

object GithubApi {
    val retrofitService: GithubService by lazy {
        retrofit.create(GithubService::class.java)
    }
}