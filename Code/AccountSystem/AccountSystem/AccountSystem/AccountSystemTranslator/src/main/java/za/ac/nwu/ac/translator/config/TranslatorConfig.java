package za.ac.nwu.ac.translator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.repository.config.RepositoryConfig;

@Import(RepositoryConfig.class)
@Configuration
@ComponentScan(basePackages = {"za.ac.nwu.ac.translator"})
public class TranslatorConfig {
}
