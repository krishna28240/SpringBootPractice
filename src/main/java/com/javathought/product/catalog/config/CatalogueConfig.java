package com.javathought.product.catalog.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"com.javathought.product.catalog.repository"})
public class CatalogueConfig {

}

