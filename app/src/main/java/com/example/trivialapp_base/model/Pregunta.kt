package com.example.trivialapp_base.model

// Definición de la clase de datos Pregunta según requisitos
data class Pregunta(
    val pregunta: String,
    val categoria: String,
    val dificultad: String, // "Facil", "Medio", "Dificil"
    val respuesta1: String,
    val respuesta2: String,
    val respuesta3: String,
    val respuesta4: String,
    val respuestaCorrecta: String // Debe coincidir con una de las anteriores
)

// Objeto para simular la base de datos local (Hardcoded)
object ProveedorPreguntas {
    fun obtenerPreguntas(): MutableList<Pregunta> {
        return mutableListOf(
            // --- GEOGRAFÍA (10) ---
            Pregunta("¿Capital de Francia?", "Geografía", "Facil", "Madrid", "París", "Berlín", "Roma", "París"),
            Pregunta("¿País más grande del mundo?", "Geografía", "Facil", "China", "EEUU", "Rusia", "Canadá", "Rusia"),
            Pregunta("¿Río más largo del mundo?", "Geografía", "Facil", "Nilo", "Amazonas", "Danubio", "Misisipi", "Amazonas"),
            Pregunta("¿En qué continente está Egipto?", "Geografía", "Medio", "Asia", "África", "Europa", "Oceanía", "África"),
            Pregunta("¿Capital de Australia?", "Geografía", "Medio", "Sídney", "Melbourne", "Canberra", "Perth", "Canberra"),
            Pregunta("¿País con más islas del mundo?", "Geografía", "Medio", "Grecia", "Suecia", "Indonesia", "Filipinas", "Suecia"),
            Pregunta("¿Capital de Mongolia?", "Geografía", "Dificil", "Ulán Bator", "Astaná", "Tiflis", "Biskek", "Ulán Bator"),
            Pregunta("¿Punto más bajo de la Tierra?", "Geografía", "Dificil", "Mar Muerto", "Fosa Marianas", "Valle de la Muerte", "Lago Baikal", "Mar Muerto"),
            Pregunta("¿Qué país tiene más fronteras?", "Geografía", "Dificil", "Rusia", "China", "Brasil", "India", "China"),
            Pregunta("¿Capital de Nigeria?", "Geografía", "Dificil", "Lagos", "Abuya", "Kano", "Ibadán", "Abuya"),

            // --- CIENCIA (10) ---
            Pregunta("¿Fórmula del agua?", "Ciencia", "Facil", "H2O", "CO2", "O2", "H2O2", "H2O"),
            Pregunta("¿Planeta más grande?", "Ciencia", "Facil", "Tierra", "Marte", "Júpiter", "Saturno", "Júpiter"),
            Pregunta("¿El Sol es una...?", "Ciencia", "Facil", "Planeta", "Cometa", "Galaxia", "Estrella", "Estrella"),
            Pregunta("¿Hueso más largo del cuerpo?", "Ciencia", "Medio", "Fémur", "Tibia", "Húmero", "Radio", "Fémur"),
            Pregunta("¿Símbolo químico del Oro?", "Ciencia", "Medio", "Ag", "Fe", "Au", "Pb", "Au"),
            Pregunta("¿Cuántos elementos tiene la tabla periódica?", "Ciencia", "Medio", "100", "118", "92", "125", "118"),
            Pregunta("¿Velocidad de la luz?", "Ciencia", "Dificil", "300.000 km/s", "150.000 km/s", "1000 km/s", "340 m/s", "300.000 km/s"),
            Pregunta("¿Partícula de carga negativa?", "Ciencia", "Dificil", "Protón", "Neutrón", "Electrón", "Positrón", "Electrón"),
            Pregunta("¿Qué gas usamos para respirar?", "Ciencia", "Dificil", "Nitrógeno", "Argón", "Oxígeno", "Hidrógeno", "Oxígeno"),
            Pregunta("¿Quién propuso la Selección Natural?", "Ciencia", "Dificil", "Newton", "Tesla", "Darwin", "Einstein", "Darwin"),

            // --- DEPORTES (Fútbol) (10) ---
            Pregunta("¿Campeón mundial fútbol 2010?", "Deportes", "Facil", "Brasil", "Alemania", "España", "Italia", "España"),
            Pregunta("¿Cuántos jugadores por equipo?", "Deportes", "Facil", "10", "11", "12", "9", "11"),
            Pregunta("¿Máximo goleador histórico mundiales?", "Deportes", "Facil", "Pelé", "Klose", "Messi", "Ronaldo", "Klose"),
            Pregunta("¿Club con más Champions League?", "Deportes", "Medio", "Milán", "Liverpool", "Real Madrid", "Bayern", "Real Madrid"),
            Pregunta("¿Dónde se jugó el mundial 1930?", "Deportes", "Medio", "Brasil", "Francia", "Uruguay", "Italia", "Uruguay"),
            Pregunta("¿Quién ganó el mundial 1966?", "Deportes", "Medio", "Alemania", "Inglaterra", "Portugal", "Argentina", "Inglaterra"),
            Pregunta("¿Portero con más porterías a cero?", "Deportes", "Dificil", "Casillas", "Buffon", "Lev Yashin", "Neuer", "Lev Yashin"),
            Pregunta("¿Único jugador con 3 Mundiales?", "Deportes", "Dificil", "Maradona", "Pelé", "Zidane", "Cruyff", "Pelé"),
            Pregunta("¿Quién ganó el Balón de Oro 1995?", "Deportes", "Dificil", "Weah", "Baggio", "Stoichkov", "Ronaldo", "Weah"),
            Pregunta("¿Primer campeón de la Eurocopa?", "Deportes", "Dificil", "España", "URSS", "Yugoslavia", "Italia", "URSS"),

            // --- HISTORIA (10) ---
            Pregunta("¿Año descubrimiento América?", "Historia", "Facil", "1492", "1500", "1485", "1992", "1492"),
            Pregunta("¿Primer hombre en la Luna?", "Historia", "Facil", "Aldrin", "Armstrong", "Collins", "Gagarin", "Armstrong"),
            Pregunta("¿Ciudad destruida por el Vesubio?", "Historia", "Facil", "Roma", "Atenas", "Pompeya", "Cartago", "Pompeya"),
            Pregunta("¿Revolución Francesa (año)?", "Historia", "Medio", "1776", "1789", "1812", "1750", "1789"),
            Pregunta("¿Nacionalidad de Adolf Hitler?", "Historia", "Medio", "Alemán", "Austriaco", "Polaco", "Suizo", "Austriaco"),
            Pregunta("¿Nombre del barco de Darwin?", "Historia", "Medio", "Titanic", "Beagle", "Santa María", "Endeavour", "Beagle"),
            Pregunta("¿Duración Guerra de los 100 años?", "Historia", "Dificil", "100", "116", "99", "105", "116"),
            Pregunta("¿Último emperador azteca?", "Historia", "Dificil", "Moctezuma", "Cuauhtémoc", "Cuitláhuac", "Atahualpa", "Cuauhtémoc"),
            Pregunta("¿Qué civilización usaba jeroglíficos?", "Historia", "Dificil", "Mayas", "Incas", "Egipcios", "Sumerios", "Egipcios"),
            Pregunta("¿Fundador del Imperio Mongol?", "Historia", "Dificil", "Kublai Kan", "Gengis Kan", "Attila", "Tamerlán", "Gengis Kan"),

            // --- ARTE (10) ---
            Pregunta("¿Quién pintó la Mona Lisa?", "Arte", "Facil", "Picasso", "Van Gogh", "Da Vinci", "Dalí", "Da Vinci"),
            Pregunta("¿Autor de 'La noche estrellada'?", "Arte", "Facil", "Monet", "Van Gogh", "Rembrandt", "Renoir", "Van Gogh"),
            Pregunta("¿Nacionalidad de Pablo Picasso?", "Arte", "Facil", "Francés", "Italiano", "Español", "Mexicano", "Español"),
            Pregunta("¿Quién esculpió el 'David'?", "Arte", "Medio", "Bernini", "Donatello", "Miguel Ángel", "Canova", "Miguel Ángel"),
            Pregunta("¿Estilo de Salvador Dalí?", "Arte", "Medio", "Cubismo", "Surrealismo", "Impresionismo", "Pop Art", "Surrealismo"),
            Pregunta("¿Pintor de 'Las Meninas'?", "Arte", "Medio", "Goya", "Velázquez", "El Greco", "Murillo", "Velázquez"),
            Pregunta("¿Autor de 'El Grito'?", "Arte", "Dificil", "Klimt", "Munch", "Kandinsky", "Mondrian", "Munch"),
            Pregunta("¿En qué museo está el Guernica?", "Arte", "Dificil", "Prado", "Louvre", "Reina Sofía", "British", "Reina Sofía"),
            Pregunta("¿Quién pintó 'La joven de la perla'?", "Arte", "Dificil", "Vermeer", "Rubens", "Hals", "Steen", "Vermeer"),
            Pregunta("¿Movimiento de Andy Warhol?", "Arte", "Dificil", "Dadaísmo", "Futurismo", "Pop Art", "Minimalismo", "Pop Art"),

            // --- LITERATURA (10) ---
            Pregunta("¿Autor del Quijote?", "Literatura", "Facil", "Cervantes", "Quevedo", "Lope", "Góngora", "Cervantes"),
            Pregunta("¿Quién escribió 'Hamlet'?", "Literatura", "Facil", "Dante", "Shakespeare", "Goethe", "Moliere", "Shakespeare"),
            Pregunta("¿Libro con el niño y el zorro?", "Literatura", "Facil", "Pinocho", "El Principito", "Peter Pan", "Bambi", "El Principito"),
            Pregunta("¿Autor de 'Cien años de soledad'?", "Literatura", "Medio", "Borges", "Neruda", "García Márquez", "Cortázar", "García Márquez"),
            Pregunta("¿Detective de Baker Street?", "Literatura", "Medio", "Poirot", "Dupin", "Sherlock Holmes", "Maigret", "Sherlock Holmes"),
            Pregunta("¿Género de 'La Odisea'?", "Literatura", "Medio", "Ensayo", "Épica", "Drama", "Lírica", "Épica"),
            Pregunta("¿Autor de 'La Divina Comedia'?", "Literatura", "Dificil", "Petrarca", "Boccaccio", "Dante Alighieri", "Maquiavelo", "Dante Alighieri"),
            Pregunta("¿País de origen de Kafka?", "Literatura", "Dificil", "Alemania", "Rep. Checa", "Austria", "Hungría", "Rep. Checa"),
            Pregunta("¿Quién escribió 'Fausto'?", "Literatura", "Dificil", "Schiller", "Mann", "Goethe", "Kafka", "Goethe"),
            Pregunta("¿Obra famosa de Homero?", "Literatura", "Dificil", "Eneida", "Ilíada", "Edipo Rey", "Antígona", "Ilíada")
        )
    }
}
