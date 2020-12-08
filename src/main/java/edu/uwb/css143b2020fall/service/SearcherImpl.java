package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearcherImpl implements Searcher {
    public List<Integer> search(String keyPhrase, Map<String, List<List<Integer>>> index) {
        List<Integer> result = new ArrayList<>();
        if (keyPhrase != null) {
            if (index.get(keyPhrase) != null) {
                String[] r2 = keyPhrase.split("\\s");
                if (keyPhrase.length() > 0) {
                    List<List<Integer>> list1 = new ArrayList<>();
                    HashMap<Integer, Integer> l1 = new HashMap<>();
                    for (int i = 0; i < 1; i++) {
                        list1 = index.get(r2[i]);
                        if (list1.get(i) != null) {
                            l1.put(i, i);
                        }
                        for (int j = 1; j < r2.length; j++) {
                            if (l1.put(i, i) != null) {
                                continue;
                            }
                            System.out.println(l1);
                        }
                    }
                }
                List<List<Integer>> list1 = new ArrayList<>();
                HashMap<Integer, Integer> l2 = new HashMap<>();
                list1 = index.get(keyPhrase);
                System.out.println(list1);
                for (int i = 0; i < list1.size(); i++) {
                    List<Integer> list2 = list1.get(i);
                    if (list2 != null) {
                        for (int j = 0; j < list2.size(); j++) {
                            if (list2.get(j) != null) {
                                result.add(i);
                            }
                        }
                    }
                }
            }

        }
        return result;
    }
}
/*
List<Integer> list2 = list1.get(z);
                    int count = 0;
                    System.out.println(list2);
                    for (int y = 0; y < list1.size(); y++) {

            if (index.get(keyPhrase) != null) {
                List<List<Integer>> list = index.get(keyPhrase);
                for (int i = 0; i < list.size(); i++) {
                    List<Integer> list1 = list.get(i);
                    for (int j = 0; j < list1.size(); j++) {
                        if (list.get(j) != null) {
                            result.add(i);
                        }
                    }
                }
            }
            */

            /*
            if (index.get(keyPhrase) != null) {
                for (int i = 0; i < index.get(keyPhrase).size(); i++) {
                    List<List<Integer>> list = index.get(keyPhrase);
                    for (int j = 0; j < list.size(); j++) {
                        List<Integer> list2 = list.get(i);
                        for (int z = 0; z < list2.size(); z++) {
                            if (list2.get(z) != null) {
                                result.add(j);
                            }
                        }
                    }
                }
             */