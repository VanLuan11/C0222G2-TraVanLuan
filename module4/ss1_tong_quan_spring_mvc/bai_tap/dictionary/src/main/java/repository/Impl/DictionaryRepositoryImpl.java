package repository.Impl;

import org.springframework.stereotype.Repository;
import repository.IDictionaryRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository
public class DictionaryRepositoryImpl implements IDictionaryRepository {
    private static Map<String, String > dictionary = new HashMap<>();
    static {
        dictionary.put("hello","chào");
        dictionary.put("bye","tạm biệt");
        dictionary.put("go","đi");
        dictionary.put("dog","chó");
        dictionary.put("good","tốt");
        dictionary.put("bad","xấu");
    }

    @Override
    public String translation(String english) {
        Set<String> key = dictionary.keySet();
        for (String k : key) {
            if(k.equals(english)){
                return dictionary.get(k);
            }
        }
        return null;
    }
}
