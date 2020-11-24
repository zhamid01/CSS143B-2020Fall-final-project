package edu.uwb.css143b2020fall;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uwb.css143b2020fall.model.Index;
import edu.uwb.css143b2020fall.repository.IndexRepository;
import edu.uwb.css143b2020fall.service.Indexer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
DO NOT CHANGE
 */

@SpringBootApplication
public class MiniSearchEngine implements CommandLineRunner {

    @Autowired
    private IndexRepository indexRepository;

    @Autowired
    private Indexer indexer;

    private static final Logger logger = LoggerFactory.getLogger(MiniSearchEngine.class);

    private static List<String> documents() {
        return new ArrayList<>(
                Arrays.asList(
                        "say hello world like you mean hello world not just world",
                        "hello world",
                        "hello",
                        "world",
                        "world world hello",
                        "world seattle rains hello abc world",
                        "sunday hello world fun"));
    }

    public static void main(String[] args) {
        SpringApplication.run(MiniSearchEngine.class, args);
        logger.info("service ready");
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        List<String> docs = documents();
        Map<String, List<List<Integer>>> indices = indexer.index(docs);

        // convert map to json for storage
        // hacky. need better way to store it in DB
        String jsonIdx = new ObjectMapper().writeValueAsString(indices);
        String jsonDoc = new ObjectMapper().writeValueAsString(docs);
        indexRepository.save(new Index(jsonIdx, jsonDoc));
    }
}