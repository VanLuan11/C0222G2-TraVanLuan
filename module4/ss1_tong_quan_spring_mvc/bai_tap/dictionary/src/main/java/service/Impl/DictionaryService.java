package service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IDictionaryRepository;
import service.IDictionaryService;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryRepository iDictionaryRepository;

    @Override
    public String translation(String english) {
        return iDictionaryRepository.translation(english);
    }
}
