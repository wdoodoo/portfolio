package test;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParsing_test {

    // tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}

	public ArrayList<XmlParsingVO> xmlParse(int page) {
		page = 1;	// 페이지 초기값 
		
		ArrayList<XmlParsingVO> al = new ArrayList<XmlParsingVO>();
		//ArrayList<String> kor_co_nm = new ArrayList<String>();
		
		try{
			while(true){
				// parsing할 url 지정(API 키 포함해서)
				String url = "http://finlife.fss.or.kr/finlifeapi/annuitySavingProductsSearch.xml?auth=1db6e257b5ad61c5241a1bc1c9bc863b&topFinGrpNo=050000&pageNo="+page;
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("baseinfo");
				//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
				
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						
						XmlParsingVO xmlvo = new XmlParsingVO();
						xmlvo.setKor_co_nm(getTagValue("kor_co_nm", eElement));
						xmlvo.setFin_prdt_cd(getTagValue("fin_prdt_cd", eElement));
						xmlvo.setFin_prdt_nm(getTagValue("fin_prdt_nm", eElement));
						xmlvo.setAvg_prft_rate(getTagValue("avg_prft_rate", eElement));
						xmlvo.setDcls_rate(getTagValue("dcls_rate", eElement));
						al.add(xmlvo);
						
						//kor_co_nm.add(getTagValue("kor_co_nm", eElement));
						
						System.out.println("######################");
						//System.out.println(eElement.getTextContent());
						//System.out.println("모르는값  : " + getTagValue("dcls_month", eElement));
						System.out.println("금융사  : " + getTagValue("kor_co_nm", eElement));
						System.out.println("상품 코드  : " + getTagValue("fin_prdt_cd", eElement));
						System.out.println("상품명 : " + getTagValue("fin_prdt_nm", eElement));
						System.out.println("연평균 수익률  : " + getTagValue("avg_prft_rate", eElement));
						System.out.println("공시 이율  : " + getTagValue("dcls_rate", eElement));
					}	// for end
				}	// if end
				
				page += 1;
				System.out.println("page number : "+page);
				if(page > 12){	
					break;
				}
			}	// while end
			
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
		return al;
	}	// main end
}	// class end