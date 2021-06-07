package es.jogampo;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Código Java que devuelve imprime el hex del encoding por defecto
 * y en diferentes encoding (UTF-8, ISO-8859-15, cp1252 (defecto windows)).
 * 
 * Además imprime como se verían los caracteres en las diferentes codificaciones 
 * en el encoding por defecto.
 * 
 * @author jogampo
 *
 */
public class VerEncoding {

	/**
	 * En la variable orig ponemos los caracteres que queremos verificar 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		System.out.println("Introduzca la cadena que quiera ver en diferentes encoding y pulse enter");
		Scanner in = new Scanner(System.in);
		String orig = in.nextLine();
		*/
		String orig = "p€";
		String codDefault = null;
		String utf8 = null;
		String iso15 = null;
		String windows = null;
		try {			
			codDefault = bytesToHex(orig.getBytes());
			utf8 = bytesToHex(orig.getBytes("UTF-8"));
			iso15 = bytesToHex(orig.getBytes("ISO-8859-15"));
			windows = bytesToHex(orig.getBytes("Cp1252"));					
			
			String utf8APartirDefault = new String(orig.getBytes("UTF-8"));
			String Iso15APartirDefault = new String(orig.getBytes("ISO-8859-15"));
			String windowsParaDefault = new String(orig.getBytes("Cp1252"));					
			
			System.out.println("Codigifcacion por defecto -->"+codDefault);
			System.out.println("Codigifcacion por UTF-8 -->"+utf8);
			System.out.println("Codigifcacion por ISO-8859-15 -->"+iso15);
			System.out.println("Codigifcacion por cp1252 windows -->"+windows);
			System.out.println("UTF 8 imprimida con la codificacion default --> "+utf8APartirDefault);
			System.out.println("ISO-8859-15 imprimida como default --> "+Iso15APartirDefault);
			System.out.println("cp1252 imprimida como default --> "+windowsParaDefault);
									
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Función que devuelve un String con el hexadecimal del String de byte que se le pase.
	 */
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}

}
