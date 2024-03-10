/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Matéria: {nome da matéria}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 * 
 * Caso não encontre a matéria no map, mostre:
 * Matéria {nome da matéria} não encontrada \n
 * 
 * Caso não seja possível mostrar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da matéria} \n
 */
fun mostrarNotas(materia: String) {

    if (!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 0
            var somaDasNotas = 0.0
            for(nota: Double in listaNotas){
                println("Nota ${++cont}: $nota")
                somaDasNotas += nota
            }
            println("Média: ${somaDasNotas / cont}")
        }
        else{
            println("Não foi possível mostrar as notas da matéria $materia")
        }

        println()
    }


}

/*Retorna a média obtida a partir de uma lista de notas */
fun calcularMedia(materia: String): Double? {
    return materiasENotas[materia]?.average()
}


/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia: String, vararg notas: Double) {
    for (nota in notas) materiasENotas[materia]?.add(nota)
}


fun main(){
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição posicional
    adicionarDisciplina("PDM", mutableListOf())
    
    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(notas = mutableListOf(), materia = "Programação para Web II")

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parâmetro notas possua um valor padrão. Dica: utilize mutableListOf()

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("GPS")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("PDM", 10.0)
    adicionarNota("GPS", 10.0)
    adicionarNota("Programação para Web II", 9.9)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    println("Notas de PDM:")
    mostrarNotas("PDM")

    println("Notas de GPS:")
    mostrarNotas("GPS")

    println("Notas de Programação para Web II:")
    mostrarNotas("Programação para Web II")

    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("CE")
    
    // 8. adicionarVariasNotas -> implemente o método adicionarVariasNotas();

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("CE", 10.0, 9.7, 9.9)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    println("Notas de CE:")
    mostrarNotas("CE")
    
    // Bônus: (Não vai ganhar nada, ou melhor, vai ganhar mais conhecimento >:O)
    
    // 11: calcularMedia -> Implemente a função calcularMedia()
    
    // 12: calcularMedia -> calcule a media de 2 disciplinas
    println("Média de PDM:")
    println(calcularMedia("PDM"))

    println("Média de CE:")
    println(calcularMedia("CE"))
    
    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a média das disciplinas

    // 14: mostrarNotas -> mostre as notas de 1 disciplina
    println("Notas de PDM:")
    mostrarNotas("PDM")

}