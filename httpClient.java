import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class httpClient extends Page{

	  
	  private static String url = "http://www.wikipedia.org/";

public static void sendRequest () throws HttpException {
	    // Create an instance of HttpClient.
	    HttpClient client =  HttpClients.createDefault();
	    // Create a method instance.
	    HttpGet getUrl = new HttpGet (url);
	  	    try {
	      // Execute the method.
	      HttpResponse statusCode = client.execute(getUrl);
	   	  //getting response line
	      PageResponseLine = getUrl.getRequestLine().getUri().toString();
	      //getting response status
	      int tmp = statusCode.getStatusLine().getStatusCode();
	      String tmp2 = statusCode.getStatusLine().getReasonPhrase();
	      PageResponseStatus =   tmp + " " + tmp2;
	      //getting response content type
	      
	      StringEntity myEntity = new StringEntity (statusCode.toString());
	      PageContentType = myEntity.getContentType().getValue();
	      System.out.println("statusCode " + statusCode);    
	      System.out.println("responseLine " + PageResponseLine);
	    } catch (IOException e) {
	      System.err.println("Fatal transport error: " + e.getMessage());
	      e.printStackTrace();
	    } finally {
	      // Release the connection.
	    	getUrl.releaseConnection();
	    }  
	}

public static void htmlParsing() throws IOException {
	
	Document doc = Jsoup.connect(url).get();
	Elements body = doc.select("body");
	Elements ExpectedElement = body.select("a[href=//ja.wikipedia.org/]"); // a with href
	
	if (ExpectedElement.isEmpty() ) {
		
		PageContainsHtmlElement = false;
		System.out.println ("Expected html-element not found");
	}else{
		PageContainsHtmlElement = true;
		System.out.println ("Expected html-element is present");
	}
}
}