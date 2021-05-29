package arquivo_contato;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import model.Lista_Pokemons;
import model.Pokemon;
import factory.Conector;

public class Contato {
	
	private Connection conector;
	
	public Contato(){
		this.conector = new Conector().getConnection();
	}
	
	public void RecuperarLista() throws IOException {
		// TODO Auto-generated method stub
		
		//Recupera o arquivo na raiz do projeto
		File file = new File("arquivos/pokemon");
		FileReader reader =  new FileReader(file);
	    BufferedReader bufferedReader = new BufferedReader(reader);
	    
	    ArrayList<String[]> recuperarDados = new ArrayList<String[]>();
	    Pokemon pok = new Pokemon();
	    Lista_Pokemons lista_pok = new Lista_Pokemons();
	    int cont = 0;
	    
	    while(true){
	    	String line = bufferedReader.readLine();
	    	if(line == null) break;	
	    	
	    	if(line.contains("\"id")){
	    		cont++;
	    		if(cont >1) {
	    			if(!lista_pok.getLista_pokemons().containsKey(pok.getNum())) {
	    				lista_pok.getLista_pokemons().put(pok.getNum(), pok);
	    			}
	    			pok = new Pokemon();
	    		}	    
	    		String aux = line.split(":")[1].trim().replaceAll(",", "");	    			    		
	    		pok.setId(Integer.parseInt(aux));	    		
	    		
	    	}
	    	
	    	if(line.contains("\"num")){	    		
	    		String aux = line.split(":")[1].trim().replaceAll(",", "").replaceAll("\"", "");	    			    		
	    		pok.setNum(aux);	    		
	    		
	    	}
	    	
	    	if(line.contains("\"name")){	    		
	    		String aux = line.split(":")[1].trim().replaceAll(",", "").replaceAll("\"", "");	    			    		
	    		pok.setName(aux);	    			    		
	    		
	    	}
	    	
	    	if(line.contains("\"type")){
	    		
	    		while(true) {
	    			String lineaux = bufferedReader.readLine();
	    			if(lineaux.contains("]")) break;
	    				    			
	    			String aux = lineaux.replaceAll(",", "").replaceAll("\"", "");		    		
	    			pok.getType().add(aux);	    			
	    		}
	    		
	    	}
	    	
	    	if(line.contains("\"next_evolution")){
	    		
	    		while(true) {
	    			String lineaux = bufferedReader.readLine();
	    			if(lineaux.contains("]")) break;
	    			
	    			if(lineaux.contains("num")) {	    				
	    	    		String aux = lineaux.split(":")[1].trim().replaceAll(",", "").replaceAll("\"", "");	    	    		
	    	    		pok.getNext_evolution().add(aux);
	    	    		
	    			}
	    		}
	    		
	    	}
	    	
	    	if(line.contains("\"prev_evolution")){
	    		
	    		while(true) {
	    			String lineaux = bufferedReader.readLine();
	    			if(lineaux.contains("]")) break;
	    			
	    			if(lineaux.contains("num")) {	    			
	    	    		String aux = lineaux.split(":")[1].trim().replaceAll(",", "").replaceAll("\"", "");	    	    	
	    	    		pok.getPre_evolution().add(aux);
	    	    	
	    			}
	    		}
	    		
	    	}
	    }
	    	

	    
//	    bufferedReader.close();
//	    reader.close();
//	    
//	    Set<String> chaves = lista_pok.getLista_pokemons().keySet();
//	    int contn = 0;
//        for(String chave : chaves) {
//        	System.out.println("Teste número: " +lista_pok.getLista_pokemons().get(chave).getNum());
//            System.out.println("Teste nome: " +lista_pok.getLista_pokemons().get(chave).getName());
//            System.out.println("Teste tipo: " +lista_pok.getLista_pokemons().get(chave).getType().toString());
//            System.out.println("Teste pre: " +lista_pok.getLista_pokemons().get(chave).getPre_evolution().toString());
//            System.out.println("Teste next: " +lista_pok.getLista_pokemons().get(chave).getNext_evolution().toString());
//            contn++;
//        }
//        System.out.print(contn);
        
	    //Salvar no banco de dados MySQL
		SalvarBD(lista_pok);
	}
	
	//Salvar no Banco de dados MySQL
	public void SalvarBD (Lista_Pokemons lista) {
		
        try {
            String sql;
            Set<String> chaves = lista.getLista_pokemons().keySet();
            for(String chave : chaves) {
            	sql = "INSERT INTO pokemon(num, name, tipo, pre_evolution, next_evolution) VALUES(?,?,?,?,?)";
                PreparedStatement stmt = conector.prepareStatement(sql);
                
                stmt.setString(1, lista.getLista_pokemons().get(chave).getNum());
                stmt.setString(2, lista.getLista_pokemons().get(chave).getName());
                stmt.setString(3, lista.getLista_pokemons().get(chave).getType().toString());
                stmt.setString(4, lista.getLista_pokemons().get(chave).getPre_evolution().toString());
                stmt.setString(5, lista.getLista_pokemons().get(chave).getNext_evolution().toString());
                
                stmt.execute();
                stmt.close();
                
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    
	}
}
