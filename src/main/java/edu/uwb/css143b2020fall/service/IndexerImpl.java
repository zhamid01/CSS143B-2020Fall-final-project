package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexerImpl implements Indexer {
    public Map<String, List<List<Integer>>> index(List<String> docs) {
        Map<String, List<List<Integer>>> indexes = new HashMap<>();
        if (docs != null) {
            List<List<Integer>> list1 = new ArrayList<>();
            for (int i = 0; i < docs.size(); i++) {
                String n1 = docs.get(i);
                List<Integer> list = new ArrayList<Integer>();
                String[] n2 = n1.split(" ");
                while (n2 != null) {
                    for (String s : n2) {
                        for (int k = 0; k < n2.length; k++) {
                            list.add(k);
                            for (int j = 0; j < n2.length; j++) {
                                if (n2[k] == n2[j]) {
                                    list.add(j);
                                }
                            }
                            list1.add(list);
                        }
                        indexes.put(s, list1);
                    }
                }
            }
        }
        return indexes;
    }
}