package br.com.mizaeldouglas.alugames.model.game

data class Game(val title:String,
                val thumb:String) {
    var description = ""
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $thumb \n" +
                "Descricao: $description"

    }


}