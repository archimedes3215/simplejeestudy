package com.yuqiaotech.simplejee.regex;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


public class RegexTest {


	/**
	 * 正则表达式的应用场合之-URLRewrite。
	 */
	@Test
	public void testUrlRewrite(){
		String patternStr = "^/[a-z]+/\\d+$";//请填写合适的内容
		Pattern pattern = Pattern.compile(patternStr);
		String rewriteTo = "/news_list.jsp?catCode=016";//请填写合适的内容
		Matcher matcher = pattern.matcher("/newslist/016");
		assertTrue(matcher.matches());
		String newUrl = matcher.replaceAll(rewriteTo);
		assertTrue("/news_list.jsp?catCode=016".equals(newUrl));
	}
}
