package com.perfume.surfing.service;

import com.perfume.surfing.domain.WordType;
import com.perfume.surfing.domain.Word;
import com.perfume.surfing.repository.WordRepository;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WordServiceTest {

    @Autowired private WordRepository wordRepository;
    @Autowired private WordService wordService;
    @Autowired EntityManager em;

    @Test
    public void 워드추가() throws Exception{
        //given
        String name = "시트러스";
        String alias = "시트라스";
        WordType type = WordType.NOTE;

        //when
        Word word = wordService.saveWordWithMapping(name,alias,type);
        Long saveId = word.getId();

        //then
        em.flush();
        assertEquals(word, wordRepository.findById(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_워드_예외() throws Exception{
        //given
        String name = "시트러스";
        String alias = "시트라스";
        WordType type = WordType.NOTE;

        //when
        Word word1 = wordService.saveWordWithMapping(name,alias,type);
        Word word2 = wordService.saveWordWithMapping(name,alias,type);

        //then
        fail("이름과 별칭이 같은 키워드 중복으로 예외가 발생해야한다.");
    }

    @Test
    public void 자동완성_반환() throws Exception{
        //given


        //when


        //then

    }

    @Test
    public void 자동완성_반환_예외() {

        // 테스트용 데이터
        String alias = "test";

        // 서비스 메서드 호출
        List<Word> result = wordService.getAutocompleteWords(alias);

        // 결과 확인
        assertNotNull(result); // 결과가 null이 아닌지 확인
        assertFalse(result.isEmpty());
    }


}
