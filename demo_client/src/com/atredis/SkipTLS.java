package com.atredis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SkipTLS {

	public static void main(String[] args) throws Exception {
		
/*		final HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(final String arg0, final SSLSession arg1) {
				return true;
			}
		};
		
		TrustManager[] trustAllCerts = new TrustManager[] {
				new X509TrustManager() {
					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}
					
					public void checkClientTrusted(X509Certificate[] certs, String authType) { }
					public void checkServerTrusted(X509Certificate[] certs, String authType) { }
				}
		};
		
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
				
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
*/		

        //MITM the connection however you want, or for testing, map it in /etc/hosts
		URL url = new URL("https://www.google.com:443/");
		HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
				
		System.out.println("*** Content ***");
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input;
				
		while ((input = br.readLine()) != null) {
			System.out.println(input);
		}
		br.close();
  }

}
