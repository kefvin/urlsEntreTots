package Segon.urlsEntreTots;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/******************* Gestiona las cookies *******************/
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        try {
			
        	 /****************** GET *******************/
        	//http://projectes.cendrassos.net && http://projectes.cendrassos.net/checklogin.php
			URL url = new URL("http://projectes.cendrassos.net");
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); // Crea la conexion
			// También se puede usar URLConnection con = url.openConnection();
			System.out.println(con.getResponseCode()); // Devuelve la respuesta del servidor, en caso de ser correcto da 200
			InputStream in = new  BufferedInputStream(con.getInputStream());
			int d;
			
			while(( d = in.read()) != -1){
				System.out.print((char) d );
			}
			System.out.println("");
			
			/******************* POST ********************/
			URL urld = new URL("http://projectes.cendrassos.net/checklogin.php");
			HttpURLConnection cond = (HttpURLConnection) urld.openConnection();
			cond.setDoOutput(true);
			cond.setRequestMethod("POST");
			String dades = "usuari=picornell&contrasenya=jesus";
			DataOutputStream dos = new DataOutputStream(cond.getOutputStream());
			dos.writeBytes(dades); // Envia los datos
			dos.flush(); // Se asegura de haberlo enviado todo
			dos.close(); 
			InputStream ind = new  BufferedInputStream(cond.getInputStream());
			int c;
			while(( c = ind.read()) != -1){
				System.out.print((char) c );
			
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
