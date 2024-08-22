data class Jogo(var titulo: String, var capa: String)   {
    var descricao = ""

    override fun toString() = """
        Jogo: 
            titulo: $titulo, 
            capa: $capa, 
            descricao: $descricao
    """.trimIndent()
}