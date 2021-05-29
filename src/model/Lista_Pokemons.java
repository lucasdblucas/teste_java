package model;

import java.util.HashMap;
import java.util.Map;

public class Lista_Pokemons {
	private Map<String, Pokemon> lista_pokemons;
	
	public Lista_Pokemons () {
		this.lista_pokemons = new HashMap<String, Pokemon>();
	}

	public Map<String, Pokemon> getLista_pokemons() {
		return lista_pokemons;
	}

	public void setLista_pokemons(Map<String, Pokemon> lista_pokemons) {
		this.lista_pokemons = lista_pokemons;
	}
}
