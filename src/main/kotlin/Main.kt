import br.com.mizaeldouglas.alugames.model.Jogo
import br.com.mizaeldouglas.alugames.service.ApiService
import java.util.*


fun main() {
    val api = ApiService()
    val sc = Scanner(System.`in`)

    println("Digite um codigo de jogo para buscar: ")
    val busca = sc.nextLine()

    var meuJogo: Jogo? = null

    val result = runCatching {
        val meuInfoJogo = api.buscaJogo(busca)
        meuJogo = Jogo(
            meuInfoJogo.info.title,
            meuInfoJogo.info.thumb)
    }

    result.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    result.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = sc.nextLine().uppercase()
        if (opcao.equals("S", true)){
            println("Digite a descrição personalizada para o jogo: ")
            val descricaoPersonalizada = sc.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        }else{
            meuJogo?.descricao = meuJogo?.titulo.toString()
        }
    }

    println(meuJogo)

    result.onSuccess {
        println("\nBusca  Finalizado com sucesso!!")
    }
}
