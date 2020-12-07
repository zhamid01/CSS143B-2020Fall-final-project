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
            for (int i = 0; i < docs.size(); i++) {
                String n1 = docs.get(i);
                String[] n2 = n1.split(" ");
                List<List<Integer>> list1 = new ArrayList<>();
                for (int j = 0; j < n2.length; j++) {
                    List<Integer> list = new ArrayList<Integer>();
                    for (int k = 0; k < n2.length; k++) {
                        if (n2[j] == n2[k]) {
                            list.add(j);
                        }
                    }
                    list1.add(list);
                    indexes.put(n2[j], list1);
                }
            }
        }
        return indexes;
    }
}