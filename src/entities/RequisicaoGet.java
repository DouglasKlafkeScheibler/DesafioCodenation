package entities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequisicaoGet {
	
	public String requisicao(){
	
		String line = null;

		try{
			URL u = new URL("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=1c283516df3ec19e2f3914bdfebb090e7cc0dbe2");
			HttpURLConnection hr = (HttpURLConnection)u.openConnection();		
			if(hr.getResponseCode()==200) {
				InputStream im = hr.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(im));
				line = br.readLine();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return line;
	}
}


