import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test extends httpClient{
Map<Integer, String> testMap;
	
	@BeforeClass
	public void setup() throws HttpException, IOException{
	httpClient.sendRequest();
	httpClient.htmlParsing();
	}

	@Test(groups = "responceLine")
	public void test_responceLine (){
		String expectedResult = "http://www.wikipedia.org/";
		System.out.println("Expected res: " + expectedResult);
		System.out.println("Actual res: " + PageResponseLine);
		Assert.assertTrue(expectedResult.equalsIgnoreCase(PageResponseLine));
	}
	
	@Test(groups = "responceStatus")
	public void test_responceStatus (){
		String expectedResult = "200 ok";
		System.out.println("Expected res: " + expectedResult);
		System.out.println("Actual res: " + PageResponseStatus);
		Assert.assertTrue(expectedResult.equalsIgnoreCase(PageResponseStatus));
	}
	
	@Test(groups = "contentType")
	public void test_contentType (){
	String expectedResult = "text/plain; charset=ISO-8859-1";
	System.out.println("Expected res: " + expectedResult);
	System.out.println("Actual res: " + PageContentType);
	Assert.assertTrue(expectedResult.equalsIgnoreCase(PageContentType.toString()));
}
	@Test(groups = "expectedHtmlElementIsPresent")
	public void test_expectedHtmlElementIsPresent (){
		System.out.println("Expected res: true");
		System.out.println("Actual res: " + PageContainsHtmlElement);
		Assert.assertTrue(PageContainsHtmlElement);
	}
}
