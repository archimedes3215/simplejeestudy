package com.yuqiaotech.simplejee.servlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CountAccessFilter implements Filter {
	private Map<String, Integer> statMap;

	public void destroy() {
		this.destroy();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		// ȡ��keyΪuri��Map�е�value
		Integer clicks = statMap.get(uri);
		if (clicks == null)
			clicks = 0;
		clicks++;
		statMap.put(uri, clicks);
		// ȡ�����е�Map
		Set<Map.Entry<String, Integer>> entries = statMap.entrySet();
		// ��ΪҪʹ��Connections������Ȼ���򣬱��뽫Map.Entry����List��
		List<Map.Entry<String, Integer>> entriesList = new ArrayList<Entry<String, Integer>>();
		entriesList.addAll(entries);
		// sort�ڶ�������ʹ����������ȷ���������
		Collections.sort(entriesList,
				new Comparator<Map.Entry<String, Integer>>() {
					public int compare(Entry<String, Integer> o1,
							Entry<String, Integer> o2) {
						return o2.getValue().compareTo(o1.getValue());
					}
				});
		// ��ͳ�����ݴ浽�ļ���
		FileWriter fw = new FileWriter("D:\\CountAccess.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (Map.Entry<String, Integer> map : entriesList) {
			bw.write("uri:" + map.getKey());
			bw.newLine();
			bw.write("accesstimes:" + map.getValue());
			bw.newLine();
			bw.newLine();
		}
		bw.flush();
		fw.close();
		bw.close();
		//�ж��Ƿ��������ҳ��
		if (uri.endsWith("/count_access_show")) {
			request.setAttribute("entriesList", entriesList);
			request.getRequestDispatcher("/filterlistener/count_access_show.jsp").forward(
					request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		statMap = new Hashtable<String, Integer>();
		fConfig.getServletContext().setAttribute("simpleClickstreamMap",
				statMap);
	}

}
