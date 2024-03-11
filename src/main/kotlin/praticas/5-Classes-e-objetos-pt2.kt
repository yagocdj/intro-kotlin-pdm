/** SISTEMA DE REGISTROS DE FUNCIONÁRIOS
 *
 * Desenvolva um sistema de registro de funcionários para uma empresa.
 * O sistema deverá permitir registrar diferentes tipos de funcionários e apresentar suas informações.
 *
 * Alguns passos abaixo:
 *
 * 1.Crie uma classe base chamada Funcionario com as seguintes propriedades:
 * - Nome (string): o nome do funcionário.
 * - Idade (int): a idade do funcionário.
 *
 * 2.Crie uma classe Gerente que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Setor (string): o setor em que o gerente trabalha.
 *
 * 3.Crie uma classe Desenvolvedor que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Linguagem (string): a linguagem de programação que o desenvolvedor utiliza.
 *
 * 4.Crie uma classe Analista que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Area (string): a área de especialização do analista.
 *
 * 5.Imprima uma mensagem informando que um novo funcionário foi registrado, juntamente com o nome e a idade do
 * funcionário. (Lembre-se do init)
 *
 * 6. Crie um método na classe Funcionario chamado Apresentar que imprima uma mensagem de apresentação do funcionário,
 * incluindo o nome e a idade.
 *
 * 7. Crie uma lista de funcionários e adicione diferentes tipos de funcionários (gerentes, desenvolvedores e analistas)
 * à lista.
 *
 * 8. Utilize o typecast (is e as) para verificar o tipo de cada funcionário na lista e chamar o método Apresentar
 * correspondente.
 */

open class Funcionario (protected var nome: String, protected var idade: Int) {
    init {
        println("Novo funcionário registrado -> nome: $nome; idade: $idade ano(s)")
    }

    open fun apresentar() {
        println("Olá! Eu me chamo $nome e tenho $idade ano(s).")
    }
}
class Gerente(nome: String, idade: Int, var setor: String) : Funcionario(nome, idade) {
    override fun apresentar() {
        println("Olá! Eu me chamo $nome e tenho $idade ano(s). Sou gerente de $setor.")
    }
}
class Desenvolvedor(nome: String, idade: Int, var linguagem: String) : Funcionario(nome, idade) {
    override fun apresentar() {
        println("Olá! Eu me chamo $nome e tenho $idade ano(s). Sou especialista em $linguagem.")
    }
}
class Analista(nome: String, idade: Int, var area: String) : Funcionario(nome, idade) {
    override fun apresentar() {
        println("Olá! Eu me chamo $nome e tenho $idade ano(s). Sou analista de $area.")
    }
}

fun main() {
    val funcionarios = mutableListOf(
        Gerente("Camila", 35, "Finanças"),
        Gerente("Luíza", 42, "TI"),
        Desenvolvedor("Ana", 20, "Kotlin"),
        Desenvolvedor("Luciana", 40, "JavaScript"),
        Analista("Maria", 24, "Dados"),
        Analista("Vitoria",  54, "Redes")
    )

    for (funcionario in funcionarios) {
        when (funcionario) {
            is Gerente -> {
                println("-- Gerente --")
                funcionario.apresentar()
            }
            is Desenvolvedor -> {
                println("-- Desenvolvedor --")
                funcionario.apresentar()
            }
            is Analista -> {
                println("-- Analista --")
                funcionario.apresentar()
            }
        }
    }
}