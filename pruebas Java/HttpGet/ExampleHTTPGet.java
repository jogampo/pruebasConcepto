import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExampleHTTPGet {
	private String siteContent = "";

	public ExampleHTTPGet(String strUrl) {
		String content;
		try {
			byte[] buffer = new byte[4096];
			URL url = new URL(strUrl);

			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			int bytesRead = 0;

			while ((bytesRead = bis.read(buffer)) != -1) {
				content = new String(buffer, 0, bytesRead);
				this.siteContent = this.siteContent + content;
			}
			bis.close();

			//System.out.println(this.siteContent);

		} catch (Exception ex) {
			System.out.println("OMG, Houston, we have a exception  "
					+ ex.getMessage() + " xD");
		}
	}

	public void ExampleGetConConnection(String strUrl) {
		String content;
		HttpURLConnection connection = null;
		try {
			byte[] buffer = new byte[4096];
			URL url = new URL(strUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			InputStream is = connection.getInputStream();
			System.out.println("Mensaje de Respuesta: "+ connection.getHeaderFields().toString());
			;
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
//			System.out.println(response.toString());

			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			int bytesRead = 0;

			while ((bytesRead = bis.read(buffer)) != -1) {
				content = new String(buffer, 0, bytesRead);
				this.siteContent = this.siteContent + content;
			}
			bis.close();

			System.out.println(this.siteContent);

		} catch (Exception ex) {

			ex.printStackTrace();			

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}

	}

	public static void main(String[] args) {
		// In my case, I use a proxy
		System.setProperty("http.proxyHost", "Host-del-proxy");
		System.setProperty("http.proxyPort", "1234");
		new ExampleHTTPGet("http://www.example.es").ExampleGetConConnection("http://www.example.es");	
	}

}
