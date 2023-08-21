package com.perfume.surfing.service;


import com.perfume.surfing.domain.Word;
import com.perfume.surfing.domain.WordType;
import com.perfume.surfing.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    @Transactional(readOnly = false)
    public Word saveWordWithMapping(String name, String alias, WordType type) {
        validateDuplicateWord(name, alias); // 중복 검사
        Word word = new Word(name, alias, type);
        word.setCreated_at(SqlDate.now());
        word.setUpdated_at(SqlDate.now());
        wordRepository.save(word);
        return word;
    }

    public void validateDuplicateWord(String name, String alias){
        wordRepository.findByNameAndAlias(name, alias)
                .ifPresent(w ->{
                    throw new IllegalStateException("이미 존재하는 키워드입니다.");
                });
    }

    public List<Word> getAutocompleteWords(String alias) {
        return wordRepository.findAllByAlias(alias)
                .stream()
                .sorted((w1, w2) -> Long.compare(w2.getWeight(), w1.getWeight()))
                .toList();
    }


    @Transactional(readOnly = false)
    public void plusWordsWeight(Long typeId, WordType wordType){
        List<Word> words = wordRepository.findAllByTypeId(typeId, wordType);
        wordRepository.updateWeight(words);
    }
}
