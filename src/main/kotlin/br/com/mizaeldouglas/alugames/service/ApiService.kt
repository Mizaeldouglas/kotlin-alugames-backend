package br.com.mizaeldouglas.alugames.service

import br.com.mizaeldouglas.alugames.model.InfoJogo
import br.com.mizaeldouglas.alugames.model.Jogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ApiService {
    fun buscaJogo(id: String): InfoJogo{
        val url = "https://www.cheapshark.com/api/1.0/games?id=${id}"
        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()

        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }




}