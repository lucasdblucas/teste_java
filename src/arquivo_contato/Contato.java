package arquivo_contato;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Pokemon;

public class Contato {
	
	public Contato(){
		
	}
	
	public void RecuperarLista() throws IOException {
		// TODO Auto-generated method stub
		
		//Recupera o arquivo na raiz do projeto
		File file = new File("arquivos/pokemon");
		FileReader reader =  new FileReader(file);
	    BufferedReader bufferedReader = new BufferedReader(reader);
	    
	    ArrayList<String[]> recuperarDados = new ArrayList<String[]>();
	    Pokemon pok = new Pokemon();
	    int cont = 0;
	    while(true){
	    	String line = bufferedReader.readLine();
	    	if(line == null) break;	
	    	
	    	if(line.contains("\"id")){
	    		cont++; System.out.println("Contatdor: "+cont);
	    		if(cont >1) {
	    			cont = 0; System.out.println("contador: "+cont);
	    			//adicionar pokemon
	    			pok = new Pokemon();
	    		}
	    		System.out.println("teste id"+line);
	    		String aux = line.split(":")[1].trim().replaceAll(",", "");
	    		System.out.println("teste id 2:"+aux);
	    		
	    		pok.setId(Integer.parseInt(aux));
	    		System.out.println("id: " + line.split(":")[1]);
	    		System.out.println("id: " + pok.getId());
	    		
	    	}
	    	
	    	if(line.contains("\"num")){
	    		System.out.println("teste num:"+line);
	    		String aux = line.split(":")[1].trim().replaceAll(",", "").replaceAll("\"", "");
	    		System.out.println("teste achei a stirng 2:"+aux);
	    		
	    		pok.setNum(aux);
	    		System.out.println("num: " + line.split(":")[1]);
	    		System.out.println("num: " + pok.getNum());
	    		
	    		
	    	}
	    	
	    	if(line.contains("\"name")){
	    		System.out.println("teste num:"+line);
	    		String aux = line.split(":")[1].trim().replaceAll(",", "").replaceAll("\"", "");
	    		System.out.println("teste achei a stirng 3:"+aux);
	    		
	    		pok.setName(aux);
	    		System.out.println("name: " + line.split(":")[1]);
	    		System.out.println("name: " + pok.getName());
	    		
	    		
	    	}
	    	
	    	if(line.contains("\"type")){
	    		
	    		while(true) {
	    			String lineaux = bufferedReader.readLine();
	    			if(lineaux.contains("]")) break;
	    			
	    			System.out.println("teste type:"+lineaux);
	    			String aux = lineaux.replaceAll(",", "").replaceAll("\"", "");
		    		
	    			pok.getType().add(aux);
	    			System.out.println("teste type lista:"+pok.getType());
	    		}
	    		
	    	}
	    	
	    	if(line.contains("\"next_evolution")){
	    		
	    		while(true) {
	    			String lineaux = bufferedReader.readLine();
	    			if(lineaux.contains("]")) break;
	    			
	    			if(lineaux.contains("num")) {
	    				System.out.println("teste next:"+lineaux);
	    	    		String aux = lineaux.split(":")[1].trim().replaceAll(",", "").replaceAll("\"", "");
	    	    		System.out.println("teste next:"+aux);
	    	    		
	    	    		pok.getNext_evolution().add(aux);
	    	    		System.out.println("num: " + lineaux.split(":")[1]);
	    	    		System.out.println("num: " + pok.getNext_evolution());
	    			}
	    		}
	    		
	    	}
	    	
	    	if(line.contains("\"prev_evolution")){
	    		
	    		while(true) {
	    			String lineaux = bufferedReader.readLine();
	    			if(lineaux.contains("]")) break;
	    			
	    			if(lineaux.contains("num")) {
	    				System.out.println("teste next:"+lineaux);
	    	    		String aux = lineaux.split(":")[1].trim().replaceAll(",", "").replaceAll("\"", "");
	    	    		System.out.println("teste next:"+aux);
	    	    		
	    	    		pok.getPre_evolution().add(aux);
	    	    		System.out.println("num: " + lineaux.split(":")[1]);
	    	    		System.out.println("num: " + pok.getPre_evolution());
	    			}
	    		}
	    		
	    	}
	    }
	    	
		
	    
	    bufferedReader.close();
	    reader.close();
	}
}
