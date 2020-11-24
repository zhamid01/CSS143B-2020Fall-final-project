package edu.uwb.css143b2020fall.service;

import java.util.List;
import java.util.Map;

public interface Searcher {
    List<Integer> search(String keyPhrase, Map<String, List<List<Integer>>> indexes);
}
