package model;

public class Equipo {

    private final int CANTIDAD_JUGADORES = 6;

    protected String nombreEquipo;

    private JugadorHockey[] jugadores = new JugadorHockey[CANTIDAD_JUGADORES];

    public Equipo(String nombre) {
        this.nombreEquipo = nombreEquipo;
        
    }

    public void agregarJugadorHockey(JugadorHockey jugador, int posicion) {
        if (posicion >= 0 && posicion < jugadores.length) {
            jugadores[posicion] = jugador;
        }
    }

    public JugadorHockey crearJugadorHockey(String nombre, int edad, Posicion posicion) {
		JugadorHockey jugadorHockey = new JugadorHockey(nombre, edad, posicion);
    	return jugadorHockey;
    }

    public JugadorHockey[] getJugadores() {
        return jugadores;
    }

    public String getNombre() {
        return nombreEquipo;
    }
}