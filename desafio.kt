// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO } // nível do curso

// data class dos usuários
data class Usuario(
    val nome: String, 
    val idade: Int, 
    val email: String,
    val nivel: Nivel
)

// data class dos ConteudoEducacional
data class ConteudoEducacional(
    var nome: String, 
    val duracao: Int = 120
)

// data class da formação
data class Formacao(
    val nome: String, 
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()
    
    // aplicando a função vararg para adicionar mais usuários
    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios) 
    }
}

fun main() {
    
    // Módulos
    val modulo1 = ConteudoEducacional("", 100)
    val modulo2 = ConteudoEducacional("Introdução a linguagem Kotlin", 110)
    
     // Formacão
    val formacao = Formacao("Bootcamp da Dio", listOf(modulo1,modulo2))
    
    // Alunos
    val aluno1 = Usuario("Cristiano", 25, "cekeaudio@gmail.com", nivel = Nivel.BASICO)
    val aluno2 = Usuario("Esdras", 30, "cekeaudio@hotmail.com", nivel = Nivel.AVANCADO)
    val aluno3 = Usuario("Junior", 35, "cekeaudio@yahoo.com", nivel = Nivel.INTERMEDIARIO)
    
    // Formação Matricula
    formacao.matricular(aluno1, aluno2, aluno3)
    
    // Imprimindo lista de inscritos
    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos}")
    println()
    
    // Imprimindo nomes, carga horária e email dos alunos matriculados
    println("Informações dos usuários matriculados na formação ${formacao.nome}:")
    formacao.inscritos.forEach { usuario ->
        println("Nome: ${usuario.nome}")
        println("Email: ${usuario.email}")
        println("Carga Horária Total: ${formacao.conteudos.sumOf { it.duracao }} minutos")
        println("Nivel do Curso: ${usuario.nivel}")
        println("-------------")
    }
    
}