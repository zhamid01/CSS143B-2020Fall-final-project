package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexerImpl implements Indexer {
    public Map<String, List<List<Integer>>> index(List<String> docs) {
        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        if (docs != null) {
            for (int i = 0; i < docs.size(); i++) {
                String n1 = docs.get(i);
                String[] n2 = n1.split("\\s");
                List<List<Integer>> list1 = new ArrayList<>();
                HashMap<String, String> s1 = new HashMap<>();
                for (int m = 0; m < n2.length; m++) {
                    s1.put(n2[m], n2[m]);
                }
                Collection<String> l = s1.values();
                String[] s2 = l.toArray(new String[0]);
                for (int j = 0; j < s2.length; j++) {
                    List<Integer> list = new ArrayList<Integer>();
                    for (int k = 0; k < n2.length; k++) {
                        if (n2[j].equals("")) {
                            continue;
                        }
                        if (s2[j] == n2[k]) {
                            list.add(k);
                        }
                    }
                    list1.add(list);
                    indexes.put(s2[j], list1);
                }
            }
        }
        return indexes;
    }
}




                    /*
                    if (s1.put(n2[j], 1) == null) {
                        continue;
                    }
                    if (n2[j].equals("")) {
                        continue;
                    }
                    List<Integer> list = new ArrayList<Integer>();
                    for (int k = 0; k < n2.length; k++) {
                        if (n2[j] == n2[k]) {
                            list.add(k);
                        }
                    }
                    list1.add(list);
                    indexes.put(n2[j], list1);
                }
                     */