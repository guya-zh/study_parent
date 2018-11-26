import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/9/11 18:48
 * @description 描述当前类的用途
 */
@SpringBootApplication
/*基础扫描包*/
@ComponentScan("com")
/*mybatis 单数据源*/
//@MapperScan(basePackages = {"com.lill.study.mapper"})
/*jpa*/ /*多数据源时关闭 ，但数据原时使用*/
//@EntityScan("com")
//@EnableJpaRepositories("com")
/*异步监听开启*/
@EnableAsync
public class AppMain {
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }
}
