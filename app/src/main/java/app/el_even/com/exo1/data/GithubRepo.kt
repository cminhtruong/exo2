package app.el_even.com.exo1.data

import com.squareup.moshi.Json

data class Result(@Json(name = "items") val githubRepos: List<GithubRepo>)

data class GithubRepo(val id: Long, val owner: Owner)

data class Owner(
    val id: Long,
    @Json(name = "avatar_url") val avatarUrl: String
)