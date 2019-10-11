package aplicacao;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import entities.DecifrarWithSha1;
import entities.RequisicaoGet;

public class Programa {

	public static void main(String[] args) throws JSONException, IOException {

		//Fazer a requisição
		RequisicaoGet requisicaoGet = new RequisicaoGet();
		String json = requisicaoGet.requisicao();
		JSONObject myResponse = new JSONObject(json);
		
		//Salvar nas variaveis o valor de numCasas e cifrado, resultados obtidos na API
		int numero_casas = myResponse.getInt("numero_casas");
		String cifrado = myResponse.getString("cifrado");
		
		//Setar as variaveis obtidas para o construtor 
		//NOTA:deci e sha1
		DecifrarWithSha1 decifrarWithSha1 = new DecifrarWithSha1(cifrado, numero_casas); 
		
		//Realizar métodos de decriptografia e conversão para sha1
		String decifrado = decifrarWithSha1.descriptografar();
		String resumo_criptografico = decifrarWithSha1.conversaoSha1(decifrado);
		
		//Atualizar campos values das keys decifrado e resumo 
		myResponse.put("decifrado", decifrado);
		myResponse.put("resumo_criptografico", resumo_criptografico);
		
		//Definir local de salvar arquivo
		//obs:Nome do arquivo = answer.json
		FileWriter writeFile = new FileWriter("D://trab/answer.json");
		
		//Salvar conteudo no formato json
		writeFile.write(myResponse.toString());
		writeFile.close();
	}
	//Para fazer o metodo POST foi utilizado o software postman
}


