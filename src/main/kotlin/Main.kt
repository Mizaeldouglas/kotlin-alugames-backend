import br.com.mizaeldouglas.alugames.model.game.Game
import br.com.mizaeldouglas.alugames.service.ApiService
import java.util.*


fun main() {
    val api = ApiService()
    val sc = Scanner(System.`in`)

    println("Digite um codigo de jogo para buscar: ")
    val search = sc.nextLine()

    var myGame: Game? = null

    val result = runCatching {
        val myInfoGame = api.searchGame(search)
        myGame = Game(
            myInfoGame.info.title,
            myInfoGame.info.thumb)
    }

    result.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    result.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = sc.nextLine().uppercase()
        if (opcao.equals("S", true)){
            println("Digite a descrição personalizada para o jogo: ")
            val descriptionCustom = sc.nextLine()
            myGame?.description = descriptionCustom
        }else{
            myGame?.description = myGame?.title.toString()
        }
    }

    println(myGame)

    result.onSuccess {
        println("\nBusca  Finalizado com sucesso!!")
    }
}
