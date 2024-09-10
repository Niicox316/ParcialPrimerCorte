// Programa principal que administra las elecciones
fun main() {
    val elecciones = Elecciones()

    while (true) {
        println("\nMenú de elecciones:")
        println("1. Votar por un candidato")
        println("2. Ver costos de campaña")
        println("3. Vaciar todas las urnas")
        println("4. Ver número total de votos")
        println("5. Ver porcentaje de votos por candidato")
        println("6. Ver costo promedio de campaña")
        println("7. Ver candidato ganador")
        println("8. Salir")
        print("Seleccione una opción: ")

        // Control de errores: validar entrada del usuario.
        val opcion = try {
            readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            println("Opción no válida. Introduzca un número.")
            continue
        }

        when (opcion) {
            1 -> {
                println("Elija el candidato (1. Candidato A, 2. Candidato B, 3. Candidato C):")
                val candidatoIndex = try {
                    readLine()!!.toInt() - 1
                } catch (e: NumberFormatException) {
                    println("Entrada no válida. Introduzca un número.")
                    continue
                }

                println("Elija el medio de influencia (1. Internet, 2. Radio, 3. Televisión):")
                val medioIndex = try {
                    readLine()!!.toInt()
                } catch (e: NumberFormatException) {
                    println("Entrada no válida. Introduzca un número.")
                    continue
                }

                elecciones.votar(candidatoIndex, medioIndex)
            }
            2 -> elecciones.mostrarCostosCampania()
            3 -> elecciones.vaciarUrnas()
            4 -> println("Número total de votos: ${elecciones.totalVotos()}")
            5 -> elecciones.mostrarPorcentajeVotos()  // Muestra % y cantidad de votos + "Para un total del 100%"
            6 -> println("Costo promedio de campaña: $${elecciones.costoPromedioCampania()}")
            7 -> elecciones.mostrarCandidatoGanador()  // Muestra el ganador y cantidad de votos
            8 -> break
            else -> println("Opción no válida.")
        }
    }
}
