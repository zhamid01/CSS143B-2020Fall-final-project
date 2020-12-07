package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IndexerImpl implements Indexer {
    public Map<String, List<List<Integer>>> index(List<String> docs) {
        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        if (docs != null) {
            String l1 = " ";
            for (int r = 0; r < docs.size(); r++) {
                l1 += " ";
                l1 += docs.get(r);
            }
            String[] r2 = l1.split("\\s");
            HashMap<String, String> s1 = new HashMap<>();
            for (int n = 0; n < r2.length; n++) {
                if (r2[n].equals(" ")) {
                    continue;
                }
                if (r2[n].equals("")) {
                    continue;
                }
                s1.put(r2[n], r2[n]);
            }
            Collection<String> l = s1.values();
            String[] s2 = l.toArray(new String[0]);
            for (int q = 0; q < s2.length; q++) {
                List<List<Integer>> list1 = new ArrayList<>();
                for (int i = 0; i < docs.size(); i++) {
                    String n1 = docs.get(i);
                    String[] n2 = n1.split("\\s");
                    List<Integer> list = new ArrayList<Integer>();
                    int count = 0;
                    for (int k = 0; k < n2.length; k++) {
                        if (n2[k].equals("")) {
                            continue;
                        }
                        if (s2[q].equals(n2[k])) {
                            list.add(count);
                        }
                        count++;
                    }
                    list1.add(list);
                    indexes.put(s2[q], list1);
                }

            }
        }
        return indexes;
    }
}