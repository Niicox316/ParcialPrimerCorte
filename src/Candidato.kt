// Esta clase representa a un candidato en las elecciones.
class Candidato(val nombre: String) {
    var votosInternet = 0
    var votosRadio = 0
    var votosTelevision = 0

    // Función para calcular el costo total de campaña en función de los votos recibidos.
    fun costoCampania(): Int {
        return (votosInternet * 700000) + (votosRadio * 200000) + (votosTelevision * 600000)
    }

    // Función que retorna el número total de votos recibidos por el candidato.
    fun totalVotos(): Int {
        return votosInternet + votosRadio + votosTelevision
    }

    // Función para vaciar los votos de un candidato.
    fun vaciarUrna() {
        votosInternet = 0
        votosRadio = 0
        votosTelevision = 0
    }
}
