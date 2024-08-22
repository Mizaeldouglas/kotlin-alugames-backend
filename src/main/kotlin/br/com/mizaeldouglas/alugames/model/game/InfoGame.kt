package br.com.mizaeldouglas.alugames.model.game

data class InfoGame(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}