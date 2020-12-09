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
                List<Integer> list3 = new ArrayList<>();
                if (r2.length > 0) {
                    List<List<Integer>> list1 = new ArrayList<>();
                    list1 = index.get(r2[0]);
                    for (int x = 1; x < r2.length; x++) {
                        List<List<Integer>> list2 = new ArrayList<>();
                        list2 = index.get(r2[x]);
                        for (int s = 0; s < list1.size(); s++) {
                            for (int t = 0; t < list2.size(); t++) {
                                if (list2.get(t) == list1.get(s)) {
                                    list3.add(s);
                                }
                            }
                        }
                    }
                    for (int p = 0; p < list3.size(); p++) {
                        result.add(list3.get(p));
                    }
                }
                List<List<Integer>> list1 = new ArrayList<>();
                HashMap<Integer, Integer> l9 = new HashMap<>();
                list1 = index.get(keyPhrase);
                System.out.println(list1);
                int count = 0;
                for (int i = 0; i < list1.size(); i++) {
                    List<Integer> list2 = list1.get(i);
                    if (list2 != null) {
                        for (int j = 0; j < list2.size(); j++) {
                            if (list2.get(j) != null) {
                                result.add(count);
                                break;
                            }
                        }
                    }
                    count++;
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