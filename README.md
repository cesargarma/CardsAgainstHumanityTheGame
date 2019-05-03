# CardsAgainstHumanityTheGame
Initial Commit
Usuarios: Como array de objeto de 3 a 8 Nombre: Sin fallo Turno: Para especificar un orden de juego NumCartas: Para que todos tengan las mismas en todo momento Score: Puntuación hasta x Master: El que decide quien gana cada ronda, va cambiando entre jugadores. El que gana se convierte en master. Primera ronda aleatoria

Las cartas del usuario se guardan en un array que según usa una carta, se sustituye por otra.

Turnos: Do while hasta que alguien tenga 10 puntos o de forma infinita, dos modos de juego con selección.

Modos de juego: De cara a chupitos: 1. El que gane puede repartirse las cartas a si mismo o a quien quiera y en modo hardcore repartir TODAS las cartas. 2. El master puede elegir la que gana y la que pierde, el que pierde tiene que beber, o al reves para motivar a los beodos.

Cartas: Booleano negro o blanca 1. Dos ArrayList para las cartas blancas, uno para usadas otra sin usar 2. Dos ArrayList para las cartas negras, uno para usadas otra sin usar Según las tiene el usuario se elimina del ArrayList para que no la pueda sacar otro usuario sin querer, cuando el usuario la deje de usar en memoria, pasa al ArrayList de usadas.

BBDD: Para un futuro, ya aplicación



Estructuración:
Main: Inicia el juego. Distribución de puntos en cada turno
Juego: Establece un estado inicial a los jugadores y a las cartas, inicializando el juego
ClaseX: Sigue la ejecución, método que da el ganador de cada ronda
Player: Constructor del usuario
