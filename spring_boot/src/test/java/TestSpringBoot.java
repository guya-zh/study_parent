import com.lill.study.contrl.TestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/9/11 18:58
 * @description 描述当前类的用途
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestController.class)
public class TestSpringBoot {

    private MockMvc mvc;

    @Before
    public void init() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
    }

    @Test
    public void getTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
