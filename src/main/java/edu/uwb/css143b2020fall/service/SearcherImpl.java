package edu.uwb.css143b2020fall.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
I wasn't able to get the code to check if the phrases were in order when I found which
documents they are in, however, I was able to get the correct documents.
The way I approached this was to split up the phrase into a string array.
Then create List<List<Integer>> lists from index and Strings and then put those values into
a List<Integer>. Then I would go through and check in which documents the words all occur and
add those to a list. I was not able to check if they were in order, I am thinking I could've
checked where in the index the words occur and made sure the position of those documents in the
index were correct. If the keyPhrase was one word I would do similar steps as the multi word
phrases but instead I would just see where the one word occurred in the List<Integer> and return
those documents.
*/

@Service
public class SearcherImpl implements Searcher {
    public List<Integer> search(String keyPhrase, Map<String, List<List<Integer>>> index) {
        List<Integer> result = new ArrayList<>();
        if (keyPhrase != null) {
            String[] r2 = keyPhrase.split("\\s+");
            for (int g = 0; g < r2.length; g++) {
                if (index.get(r2[g]) == null) {
                    return result;
                }
            }
            List<Integer> list3 = new ArrayList<>();
            if (r2.length > 0) {
                List<List<Integer>> list1 = new ArrayList<>();
                list1 = index.get(r2[0]);
                List<Integer> i1 = new ArrayList<>();
                for (int x = 1; x < r2.length; x++) {
                    for (int h = 0; h < list1.size(); h++) {
                        List<Integer> tmp = list1.get(h);
                        if (!tmp.isEmpty()) {
                            i1.add(h);
                        }
                    }
                    List<List<Integer>> list2 = new ArrayList<>();
                    list2 = index.get(r2[x]);
                    List<Integer> i2 = new ArrayList<>();
                    for (int g = 0; g < list2.size(); g++) {
                        List<Integer> tmp2 = list2.get(g);
                        if (!tmp2.isEmpty()) {
                            i2.add(g);
                        }
                    }
                    for (int j = 0; j < i1.size(); j++) {
                        for (int s = 0; s < i2.size(); s++) {
                            if (i1.get(j) == i2.get(s)) {
                                result.add(i1.get(j));
                            }
                        }
                    }
                    return result;
                }
            }
            List<List<Integer>> list1 = new ArrayList<>();
            list1 = index.get(keyPhrase);
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
        return result;
    }
}