package myPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class GetMaxRepeatedWordCountFromFile {
	
	
	public static HashMap<String, Integer> getWordCount(File f) throws IOException {
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
		FileInputStream fis = new FileInputStream(f);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str = "";
		while((str=br.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(str, " ");
			while(st.hasMoreTokens()) {
				String word = st.nextToken().toLowerCase();
				if(wordCountMap.containsKey(word)) {
					wordCountMap.put(word, wordCountMap.get(word)+1);
				}else
					wordCountMap.put(word, 1);
			}
		}
		return wordCountMap;
	}
	
	public static List<Entry<String, Integer>> sortMapByValue(HashMap<String, Integer> hm) {
		Set<Entry<String, Integer>> entry = hm.entrySet();
		List<Entry<String, Integer>> al = new ArrayList<Entry<String, Integer>>(entry);
		Comparator customComp = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}};
		Collections.sort(al, customComp);
		return al;
		
	}

	public static void main(String[] args) throws IOException {
		
		URL url = GetMaxRepeatedWordCountFromFile.class.getResource("req.txt");
		File f = new File(url.getPath());
		HashMap<String, Integer> hm = getWordCount(f);
		List<Entry<String, Integer>> l = sortMapByValue(hm);
		for(Map.Entry entry : l) {
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
	}

}
