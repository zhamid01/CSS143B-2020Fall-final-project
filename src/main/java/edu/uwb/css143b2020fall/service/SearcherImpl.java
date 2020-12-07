package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearcherImpl implements Searcher {
    public List<Integer> search(String keyPhrase, Map<String, List<List<Integer>>> index) {
        List<Integer> result = new ArrayList<>();
        if (keyPhrase != null) {
            for (int k = 0; k < index.size(); k++) {
                if (keyPhrase == null)
                for (int i = 0; i < index.size(); i++) {
                    List<List<Integer>> list = index.get(i);
                    for (int j = 0; j < list.size(); j++) {
                        List<Integer> list2 = list.get(i);

                    }
                }
            }

        }
        return result;
    }
}