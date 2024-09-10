import kotlin.math.roundToInt

// Esta clase administra el proceso de elecciones.
class Elecciones {
    private val candidatos = listOf(
        Candidato("Candidato A"),
        Candidato("Candidato B"),
        Candidato("Candidato C")
    )

    // Función para registrar un voto a un candidato en un medio específico.
    fun votar(candidatoIndex: Int, medioIndex: Int) {
        // Control de errores: validar que el índice del candidato sea válido.
        if (candidatoIndex !in 0..2) {
            println("Candidato no válido.")
            return
        }

        val candidato = candidatos[candidatoIndex]

        // Asignar el medio según la elección numérica.
        when (medioIndex) {
            1 -> candidato.votosInternet++
            2 -> candidato.votosRadio++
            3 -> candidato.votosTelevision++
            else -> println("Medio no válido.")
        }
    }

    // Función para vaciar las urnas de todos los candidatos.
    fun vaciarUrnas() {
        candidatos.forEach { it.vaciarUrna() }
        println("Todas las urnas han sido vaciadas.")
    }

    // Función para obtener el total de votos en toda la elección.
    fun totalVotos(): Int {
        return candidatos.sumOf { it.totalVotos() }
    }

    // Función para mostrar el porcentaje de votos que cada candidato ha obtenido.
    fun mostrarPorcentajeVotos() {
        val totalVotos = totalVotos()
        if (totalVotos == 0) {
            println("No hay votos registrados.")
            return
        }

        // Calcula y muestra el porcentaje de votos por candidato y sus votos.
        candidatos.forEach { candidato ->
            val porcentaje = (candidato.totalVotos().toDouble() / totalVotos) * 100
            println("${candidato.nombre}: ${porcentaje.roundToInt()}% de los votos con ${candidato.totalVotos()} votos")
        }
        // Línea extra para indicar el total del 100%
        println("Para un total del 100%")
    }

    // Función para mostrar los costos de campaña de cada candidato.
    fun mostrarCostosCampania() {
        candidatos.forEach { candidato ->
            println("${candidato.nombre}: Costo de campaña $${candidato.costoCampania()}")
        }
    }

    // Función para calcular el costo promedio de campaña por voto.
    fun costoPromedioCampania(): Int {
        val totalCosto = candidatos.sumOf { it.costoCampania() }
        val totalVotos = totalVotos()
        return if (totalVotos > 0) totalCosto / totalVotos else 0
    }

    // Función para mostrar el candidato ganador.
    fun mostrarCandidatoGanador() {
        val ganador = candidatos.maxByOrNull { it.totalVotos() }
        if (ganador != null) {
            println("El candidato ganador es: ${ganador.nombre} con ${ganador.totalVotos()} votos.")
        } else {
            println("No hay votos suficientes para determinar un ganador.")
        }
    }
}
