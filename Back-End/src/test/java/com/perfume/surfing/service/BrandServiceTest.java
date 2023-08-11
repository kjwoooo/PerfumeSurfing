package com.perfume.surfing.service;


import com.perfume.surfing.domain.Brand;
import com.perfume.surfing.repository.BrandRepository;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BrandServiceTest {

    @Autowired BrandService brandService;
    @Autowired BrandRepository brandRepository;
    @Autowired EntityManager em;

    @Test
    public void 브랜드추가() throws Exception{
        //given
        Brand brand = new Brand();
        brand.setName("딥디크");
        brand.setUrl("https://www.sivillage.com/dispctg/initBrandCtg.siv?disp_ctg_no=010000039942");
        brand.setCreated_at(SqlDate.now());
        brand.setUpdated_at(SqlDate.now());

        //when
        Long saveId = brandService.add(brand);

        //then
        em.flush();
        assertEquals(brand, brandService.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_브랜드_예외() throws Exception{
        //given
        Brand brand1 = new Brand();
        brand1.setName("딥디크");
        brand1.setCreated_at(SqlDate.now());
        brand1.setUpdated_at(SqlDate.now());

        Brand brand2 = new Brand();
        brand2.setName("딥디크");      // 이름 중복
        brand2.setCreated_at(SqlDate.now());
        brand2.setUpdated_at(SqlDate.now());

        //when
        brandService.add(brand1);
        brandService.add(brand2);   // 예외발생해야 함

        //then
        fail("딥디크 브랜드 이름 중복으로 예외가 발생해야한다.");
    }
}
