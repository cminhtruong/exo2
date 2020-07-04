package app.el_even.com.exo1.api

import app.el_even.com.exo1.data.Result
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.github.com/search/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface GithubService {
    @GET("repositories?q=language:kotlin&sort=stars&order=desc&page=1&per_page=10")
    fun getAllGithubRepo(): Deferred<Result>
}

object GithubApi {
    val retrofitService: GithubService by lazy {
        retrofit.create(GithubService::class.java)
    }
}