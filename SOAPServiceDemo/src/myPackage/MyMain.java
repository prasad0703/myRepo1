package myPackage;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class MyMain {

	public static void main(String[] args) throws URISyntaxException, IOException, ParserConfigurationException, SAXException, XPathExpressionException {
		//------Read request
		InputStream is = new FileInputStream("src\\input\\req.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String strRequest = "";
		String str = "";
		while((str = br.readLine())!=null) {
			strRequest = strRequest+str;
		}
		br.close();
		
		//------------------create URI for post method-----------------
		//provide endpoint for operation
		URI uri = new URI("https://www.w3schools.com/xml/tempconvert.asmx");
		
		HttpPost hp = new HttpPost(uri);
		
		//------------------add header for post method-----------------
		hp.addHeader("SOAPAction", "https://www.w3schools.com/xml/CelsiusToFahrenheit");
		
		//------------------create entity of post method-----------------
		StringEntity se = new StringEntity(strRequest);
		se.setContentType("text/xml");
		se.setContentEncoding("utf-8");
		
		//------------------set entity for post method-----------------
		hp.setEntity(se);
		
		//-----------------------------------
		HttpClient hc = HttpClients.createDefault();
		HttpResponse hr = hc.execute(hp);
		System.out.println(hr.getStatusLine());
		System.out.println("--------------------------------------------------");
		System.out.println(hr.getStatusLine().getStatusCode());
		System.out.println("--------------------------------------------------");
		System.out.println(hr.getEntity());
		System.out.println("--------------------------------------------------");
		System.out.println(hr.getEntity().getContentLength());
		System.out.println("--------------------------------------------------");
		String responseBody = EntityUtils.toString(hr.getEntity(), "utf-8");
		System.out.println(responseBody);
		System.out.println("--------------------------------------------------");
		
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		ByteArrayInputStream bais = new ByteArrayInputStream(responseBody.getBytes("utf-8"));
		Document xmlDoc = db.parse(bais);
		NodeList nodes = (NodeList) XPathFactory.newInstance().newXPath().evaluate("Envelope/Body/CelsiusToFahrenheitResponse/CelsiusToFahrenheitResult", xmlDoc, XPathConstants.NODESET);
		System.out.println(nodes.item(0).getTextContent());
	}

}
