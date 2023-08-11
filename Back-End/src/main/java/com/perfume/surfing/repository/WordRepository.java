package com.perfume.surfing.repository;


import com.perfume.surfing.domain.Word;
import com.perfume.surfing.domain.WordType;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WordRepository {

    private final EntityManager em;

    // Create =============================================
    public void save(Word word) {
        em.persist(word);
    }

    // Read ===============================================
    public Word findById(Long id){
        return em.find(Word.class, id);
    }

    public Optional<Word> findByNameAndAlias(String name, String alias){
        return em.createQuery("select w from  Word w where w.name= :name AND w.alias= :alias", Word.class)
                .setParameter("name", name)
                .setParameter("alias", alias)
                .getResultList()
                .stream()
                .findAny();
    }

    public List<Word> findAllByAlias(String alias) {
        return em.createQuery("SELECT w FROM Word w WHERE w.alias= :alias", Word.class)
                .setParameter("alias", alias)
                .getResultList();
    }

    public List<Word> findAllByTypeId(Long typeId, WordType wordType) {
        String jpql = "SELECT w FROM Word w WHERE w.type = :type" +
                " AND (w.brand = :id OR w.note = :id OR w.perfume = :id)";
        return em.createQuery(jpql, Word.class)
                .setParameter("id", typeId)
                .setParameter("type", wordType)
                .getResultList();
    }


    // Update =============================================
    public void updateWeight(List<Word> words){
        for(Word w: words){
            Word word = em.find(Word.class, w.getId());
            if(word != null){
                word.setWeight(word.getWeight()+1);
            }
        }
    }
//    public Optional<Word> updateWord(Long wordId, String newAlias, String newName) {
//        Word word = em.find(Word.class, wordId);
//        if (word != null) {
//            word.setAlias(newAlias);
//            word.setName(newName);
//            return Optional.of(word);
//        }
//        return Optional.empty();
//    }
}
