package test;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParsing_test2 {

    // tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
	
	public static void main(String[] args) {
		int page = 1;
		try{
			while(true){
				// parsing할 url 지정(API 키 포함해서)
				String url = "http://openapi.tago.go.kr/openapi/service/ArvlInfoInqireService/getSttnAcctoArvlPrearngeInfoList?serviceKey=Z0gI3tDcVL43cA%2BF6mnxJS3ZMetcwi2vOPTBYQlKZ4T1rMZAcGw4FZoNJMdnB01nsW%2FNPeeDA21XKsKJzO%2FDjQ%3D%3D&cityCode=25&nodeId=DJB8001793&"+page;
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
				
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						
						System.out.println("######################");
						// System.out.println(eElement.getTextContent());
						System.out.println("1)정류소명: " + getTagValue("nodenm", eElement));
						System.out.println("2)도착시간: " + getTagValue("arrtime", eElement));
						System.out.println("3)버스번호: " + getTagValue("routeno", eElement));
						System.out.println("4)운행형태: " + getTagValue("routetp", eElement));
						System.out.println("5)버스종류: " + getTagValue("vehicletp", eElement));
					}	// for end
				}	// if end
				
				page += 1;
				System.out.println("page number : "+page);
				if(page > 1){	
					break;
				}
			}	// while end
			
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
		
	}	// main end
}	// class end