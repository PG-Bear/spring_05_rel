package icu.insomniac.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("icu.insomniac")
@PropertySource("classpath:my.properties")
@Import({MybatisConfig.class, JdbcConfig.class})
@EnableAspectJAutoProxy
public class SpringConfig {
}
