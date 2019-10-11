package entities;

public class DecifrarWithSha1 {

	private int numero_casas;
	private String cifrado;
	private String decifrado;
	
	public DecifrarWithSha1(String cifrado, int numero_casas) {
		this.cifrado = cifrado;
		this.numero_casas = numero_casas;
	}
	
	public DecifrarWithSha1(String cifrado, int numero_casas,String decifrado) {
		this.cifrado = cifrado;
		this.numero_casas = numero_casas;
		this.decifrado = decifrado;
	}
	
	public String getCifrado() {
		return cifrado;
	}

	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}

	public int getNumero_casas() {
		return numero_casas;
	}

	public void setNumero_casas(int numero_casas) {
		this.numero_casas = numero_casas;
	}
	
	public String getDecifrado() {
		return decifrado;
	}

	public void setDecifrado(String decifrado) {
		this.decifrado = decifrado;
	}

	public String descriptografar() {
		
		int n = cifrado.length();
		char[] char_decifrado = new char[n];
		int criptografado = 0;
		
		for(int c=0; c<n; c++)
		{
			char ch = cifrado.charAt(c);
			
			if(Character.isLetter(ch))
			{
				int UNICODE = cifrado.codePointAt(c);
				criptografado = UNICODE - numero_casas;
				
				if (criptografado < 97) 
				{
					int variavel_aux = criptografado - 97;
					criptografado = variavel_aux + 123;
				}	
			}
			else
			{
				criptografado = cifrado.charAt(c);
			}
			
		char_decifrado[c] = (char) criptografado;
		
		}
		String decifrado = new String(char_decifrado);
		return decifrado;
	}
	
	public String encriptografar() {
		
		int n = cifrado.length();
		char[] char_cifrado = new char[n];
		int criptografado = 0;
		
		for(int c=0; c<n; c++)
		{
			char ch = cifrado.charAt(c);
			
				if(Character.isLetter(ch))
				{
					int UNICODE = cifrado.codePointAt(c);
					criptografado = UNICODE + numero_casas;
					
					if (criptografado > 122) 
					{
						int variavel_aux = criptografado-123;
						criptografado = variavel_aux + 97;
					}	
				}
				else
				{
					criptografado = cifrado.charAt(c);
				}
				
			char_cifrado[c] = (char) criptografado;			
		}	
		String cifrado = new String(char_cifrado);	
		return cifrado;
	}
	
	public String conversaoSha1(String conversao) {
		return org.apache.commons.codec.digest.DigestUtils.shaHex(conversao);
	}	
}


