package com.service.Impl;


import com.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    private static Map<String, String> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put("hello", "chào");
        dictionaryMap.put("dog", "tài");
        dictionaryMap.put("bad", "xấu");
        dictionaryMap.put("good", "tốt");
    }

    @Override
    public String translation(String english) {
        return dictionaryMap.get(english);
    }
}
