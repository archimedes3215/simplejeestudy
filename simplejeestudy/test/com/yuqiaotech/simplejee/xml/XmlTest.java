package com.yuqiaotech.simplejee.xml;

import static org.junit.Assert.assertTrue;


import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.xml.sax.SAXException;

public class XmlTest {

	String msgXml = "/com/yuqiaotech/simplejee/model/Message.hbm.xml";

	/**
	 * 参考/simplejee/src/com/yuqiaotech/simplejee/xml/SimpleSample.java的代码，
	 * 使用dom4j来解析/simplejee/src/com/yuqiaotech/simplejee/model/Message.hbm.xml
	 * 并获取name为text的property节点的column的值。
	 * 
	 * @throws DocumentException
	 * @throws DocumentException
	 */
	public String getColumnNameByProName(String proName)
			throws DocumentException {
		String textColumnName = "";
		try {
			InputStream in=this.getClass().getResourceAsStream(msgXml);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(in);
			Element root = doc.getRootElement();
			Element classEle=root.element("class");
			Element foo=null;
			for (Iterator i = classEle.elementIterator("property"); i.hasNext();) {
			    foo = (Element) i.next();
			    if ("text".equals(foo.attributeValue("name"))) {
					textColumnName = foo.attributeValue("column");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textColumnName;
	}

	@Test
	public void testDom4J() throws DocumentException {
		String textColumnName = getColumnNameByProName("text");
		assertTrue("MESSAGE_TEXT".equals(textColumnName));
	}

	public String getAttributeValueByXPath(String xPath, String attrName)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerException {
		String textColumnName = "";
		InputStream in=this.getClass().getResourceAsStream(msgXml);
/*		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		org.w3c.dom.Document doc=builder.parse(in);
		org.w3c.dom.Node rtn=null;
		org.w3c.dom.Node selectedNode=XPathAPI.selectSingleNode(doc, xPath);
		if(selectedNode!=null){
			NamedNodeMap namedNodeMap=selectedNode.getAttributes();
			rtn=namedNodeMap.getNamedItem(attrName);
			if(rtn==null){
				return null;
			}else{
				textColumnName=rtn.getNodeValue();
			}
		}*/
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(in);
			Node n = doc.selectSingleNode(xPath);
			textColumnName = n.valueOf("@"+attrName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return textColumnName;
	}

	@Test
	public void testXPath() throws ParserConfigurationException, SAXException,
			IOException, TransformerException {
		String textColumnName = getAttributeValueByXPath(
				"//property[@name='text']", "column");
		assertTrue("MESSAGE_TEXT".equals(textColumnName));
	}
}
