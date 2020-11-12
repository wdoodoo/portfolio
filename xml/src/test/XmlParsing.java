package test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParsing {

    // tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}

	public List<XmlParsingVO> xmlParse() {
		
		/* VO 객체를 (데이터)를 담을 그릇을 만들자 */
		List<XmlParsingVO> list = new ArrayList<XmlParsingVO>();
		
		try{
			//while(true){
				// parsing할 url 지정(API 키 포함해서) 아래사이트의 정보를 읽어 올 수 있음 
				String url = "http://openapi.tago.go.kr/openapi/service/ArvlInfoInqireService/getCtyCodeList?serviceKey=o3a0ZKtgEJitIrv1EcjoYdCWDZvc%2F%2FKKjRvns97MgtBDkzUvJ1kyM%2FhHTkLdkbOv9ychEALTcdaQeuVPV%2BE29Q%3D%3D&";
				
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
						
						XmlParsingVO vo = new XmlParsingVO();
						
						vo.setFin_prdt_cd("fin_prdt_cd");
						vo.setFin_prdt_nm("fin_prdt_nm");
						
						/*생성된 VO 객체를 리스트에 담아주자 */
						list.add(vo);
						
						/*
						 * System.out.println("######################");
						 * //System.out.println(eElement.getTextContent());
						 * System.out.println("도시코드  : " + getTagValue("citycode", eElement));
						 * System.out.println("도시명  : " + getTagValue("cityname", eElement));
						 */
					
					}	// if end
				
				}	// for end
			
			//}	// while end
			
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
		/* 웹페이지에 보여줄거니까 return 해주는데, VO 객체를 담고 있는 리스트를 리턴해주자 */
		return list;
	}	// main end
}	// class end