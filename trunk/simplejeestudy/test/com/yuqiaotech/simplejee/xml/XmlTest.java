package com.yuqiaotech.simplejee.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.dom4j.DocumentException;
import org.xml.sax.SAXException;
import static org.junit.Assert.*;
import org.junit.Test;


public class XmlTest {

	String msgXml = "/com/yuqiaotech/simplejee/model/Message.hbm.xml";
	/**
	 * �ο�/simplejee/src/com/yuqiaotech/simplejee/xml/SimpleSample.java�Ĵ��룬
	 * ʹ��dom4j������/simplejee/src/com/yuqiaotech/simplejee/model/Message.hbm.xml
	 * ����ȡnameΪtext��property�ڵ��column��ֵ��
	 * @throws DocumentException 
	 * @throws DocumentException 
	 */
	public String getColumnNameByProName(String proName) throws DocumentException{
		
        return null;
	}
	
	@Test
	public void testDom4J() throws DocumentException{
		String textColumnName = getColumnNameByProName("text");
    	assertTrue("MESSAGE_TEXT".equals(textColumnName));
	}

	public String getAttributeValueByXPath(String xPath,String attrName) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		return null;
	}
	
	@Test
	public void testXPath() throws ParserConfigurationException, SAXException, IOException, TransformerException{
		String textColumnName = getAttributeValueByXPath("//property[@name='text']","column");
    	assertTrue("MESSAGE_TEXT".equals(textColumnName));
	}
}
