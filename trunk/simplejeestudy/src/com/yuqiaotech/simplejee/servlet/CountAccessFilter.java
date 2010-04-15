package com.yuqiaotech.simplejee.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
		Set<Map.Entry<String, Integer>> entries = statMap.entrySet();
		List<Map.Entry<String, Integer>> entriesList = new ArrayList<Entry<String, Integer>>();
		entriesList.addAll(entries);
		Collections.sort(entriesList,
				new Comparator<Map.Entry<String, Integer>>() {
					public int compare(Entry<String, Integer> o1,
							Entry<String, Integer> o2) {
						return o2.getValue().compareTo(o1.getValue());
					}
				});
		// 将统计数据存到文件中
		FileWriter fw = null;
		BufferedWriter bw = null;
		String url = this.getClass().getResource("").toString().substring(6);
		try {
			fw = new FileWriter(url + "CountAccess.txt");
			bw = new BufferedWriter(fw);
			for (Map.Entry<String, Integer> map : entriesList) {
				bw.write(map.getKey() + "=" + map.getValue());
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		// 取出key为uri的Map中的value
		Integer clicks = statMap.get(uri);
		if (clicks == null)
			clicks = 0;
		clicks++;
		statMap.put(uri, clicks);
		// 判断是否进入排序页面
		if (uri.endsWith("/count_access_show")) {
			// 取出所有的Map
			Set<Map.Entry<String, Integer>> entries = statMap.entrySet();
			// 因为要使用Connections进行自然排序，必须将Map.Entry放入List中
			List<Map.Entry<String, Integer>> entriesList = new ArrayList<Entry<String, Integer>>();
			entriesList.addAll(entries);
			// sort第二个参数使用匿名类来确定排序规则
			Collections.sort(entriesList,
					new Comparator<Map.Entry<String, Integer>>() {
						public int compare(Entry<String, Integer> o1,
								Entry<String, Integer> o2) {
							return o2.getValue().compareTo(o1.getValue());
						}
					});

			request.setAttribute("entriesList", entriesList);
			request.getRequestDispatcher(
					"/filterlistener/count_access_show.jsp").forward(request,
					response);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		statMap = new Hashtable<String, Integer>();
		FileReader fr = null;
		BufferedReader br = null;
		String url = this.getClass().getResource("").toString().substring(6);
		try {
			fr = new FileReader(url + "CountAccess.txt");
			br = new BufferedReader(fr);
			String line=null;
			while ((line=br.readLine()) != null) {
				int i = line.indexOf("=");
				String key = line.substring(0, i);
				int value = Integer.parseInt(line.substring(i + 1));
				statMap.put(key, value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		fConfig.getServletContext().setAttribute("simpleClickstreamMap",
				statMap);
	}

}
