package com.example.binchecker.data

import com.example.binchecker.domain.BinInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BinlistApi {
    @GET("{bin}")
    suspend fun getBinInfo(@Path("bin") bin: String): Response<BinInfo>
}