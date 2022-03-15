package com.dy.wind;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dy.wind.entity.DyFeedbackOrder;
import com.dy.wind.mapper.DyFeedbackOrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerFeedbackSystemApplicationTests {
    @Autowired
    private DyFeedbackOrderMapper dyFeedbackOrderMapper;

    /*@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("dy/feedback/user/loginUser/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }*/

    @Test
    public void selectByPage() {
        QueryWrapper<DyFeedbackOrder> wrap = new QueryWrapper<>();
        wrap.like("ny_id", "0");

        Page<Map<String, Object>> page = new Page<>(1, 2, false);

        Page<Map<String, Object>> e = dyFeedbackOrderMapper.selectMapsPage(page, wrap);

        System.out.println("总页数" + e.getPages());
        System.out.println("总条数" + e.getTotal());
        e.getRecords().forEach(System.out::println);

    }

    @Test
    public void test() {
        System.out.println("hello wind");
        int q = 3, w = 5;

        q ^= w ^= q ^= w;

        System.out.println("q:" + q + "   w: " + w);
    }

}
