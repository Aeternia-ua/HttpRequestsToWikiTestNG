import org.apache.http.Header;
import org.apache.http.StatusLine;


public class Page {
static String PageResponseLine;
static String PageResponseStatus;
static String PageContentType;
static boolean PageContainsHtmlElement;

public static boolean isPageContainsHtmlElement() {
	return PageContainsHtmlElement;
}
public static void setPageContainsHtmlElement(boolean pageContainsHtmlElement) {
	PageContainsHtmlElement = pageContainsHtmlElement;
}
public String getPageResponseLine() {
	return PageResponseLine;
}
public void setPageResponseLine(String pageStatusCode) {
	PageResponseLine = pageStatusCode;
}
public String getPageResponseStatus() {
	return PageResponseStatus;
}
public void setPageResponseStatus(String pageResponseStatus) {
	PageResponseStatus = pageResponseStatus;
}
public String getPageContentType() {
	return PageContentType;
}
public void setPageContentType(String pageContentType) {
	PageContentType = pageContentType;
}


}
