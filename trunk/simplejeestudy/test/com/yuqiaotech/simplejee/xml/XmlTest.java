package com.yuqiaotech.simplejee.xml;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;
import static org.junit.Assert.*;
import org.junit.Test;

public class XmlTest {

	String msgXml = "src/com/yuqiaotech/simplejee/model/Message.hbm.xml";

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
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File(proName));
			Element root = doc.getRootElement();
			for (Iterator i = root.elementIterator("class"); i.hasNext();) {
				Element child = (Element) i.next();
				for (Iterator j = child.elementIterator("property"); j
						.hasNext();) {
					Element leaf = (Element) j.next();
					if ("text".equals(leaf.attributeValue("name"))) {
						textColumnName = leaf.attributeValue("column");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textColumnName;
	}

	@Test
	public void testDom4J() throws DocumentException {
		String textColumnName = getColumnNameByProName(msgXml);
		assertTrue("MESSAGE_TEXT".equals(textColumnName));
	}

	public String getAttributeValueByXPath(String xPath, String attrName)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerException {
		String textColumnName = "";
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File(msgXml));
			Node n = doc.selectSingleNode("//hibernate-mapping/class" + xPath);
			textColumnName = n.valueOf("@" + attrName);
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
