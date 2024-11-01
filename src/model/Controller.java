package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import model.*;


public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;

    private int contadorEquipos = 0;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(4);
        int equipo2;
        do {
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2;
        fixture += "\n";

        do {
            equipo1 = random.nextInt(4);
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }

    public Equipo crearEquipo(String nombre) {
		Equipo equipo = new Equipo(nombre);
    	return equipo;
    }

    public void agregarEquipo(Equipo e) {
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] == null) {
                equipos[i] = e;
                break;
            }
        }
    }

    public void crearObjetosDePrueba() {
		// Voy a crear una Tienda por defecto, como Tienda comunica con la Controladora
		// Me apoyo en los mismos métodos que ya tengo para realizarlo
		// Al llamar métodos de la controladora dentro de la misma controladora, no debo especificar 
		// "cont" o una variable donde esté controladora, pues ya me encuentro en la controladora.
        for (int i = 0; i < 4; i++) {
            agregarEquipo(crearEquipo("equipo" + Integer.toString(i+1)));
        }
		
		// Vamos a buscar una tienda en especifico (JPGR), y con ella crearemos productos
		Equipo teamToAddPlayers = busquedaNombreDeEquipo("equipo1");
		/*
		agregarYCrearProductoATienda(tiendaALaQueLeAgregareProductos, "Yogurt Griego Uchuva", 3400.0, "04-11-2024", "AX8973", 5);
		agregarYCrearProductoATienda(tiendaALaQueLeAgregareProductos, "Yogurt Griego Frutos Rojos", 3600.0, "27-10-2024", "AX4873", 3);
		*/
		String nombreJugador = "Jugador";
	
		for(int i = 0; i < 3; i++) {
			nombreJugador += (i+1);
			agregarYCrearJugadorAEquipo(teamToAddPlayers, nombreJugador, i, Posicion.values()[(i+1)%6], i);
		}
	}

    public Equipo busquedaNombreDeEquipo(String nombrePosible) {
		Equipo equipoARetornar = null;
		for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
				equipoARetornar = equipos[i];
            }
        }
		return equipoARetornar;
	}

    public void agregarYCrearJugadorAEquipo(Equipo equipo, String nombreJ, int edadJ, Posicion posicionJ, int pos) {

		equipo.agregarJugadorHockey(equipo.crearJugadorHockey(nombreJ, edadJ, posicionJ), pos);

	}


    public void jugadoresSePasan(){


    }
}