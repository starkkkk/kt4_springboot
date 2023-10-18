package com.config;

import com.pojo.CompetitionMatrixService;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class Config {

//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowCredentials(true)
//                .maxAge(3600)
//                .allowedHeaders("*");
//    }

    @Bean(value = "jdbcTemplateOne")
    public JdbcTemplate jdbcTemplateOne() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourceOne());
        return jdbcTemplate;
    }

    @Bean(value = "jdbcTemplateTwo")
    public JdbcTemplate jdbcTemplateTwo() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourcetwo());
        return jdbcTemplate;
    }
    @Bean(value = "jdbcTemplateThree")
    public JdbcTemplate jdbcTemplateThree() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourcethree());
        return jdbcTemplate;
    }

    @Bean(value = "jdbcTemplateFour")
    public JdbcTemplate jdbcTemplateFour() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourceFour());
        return jdbcTemplate;
    }

    @Bean(value = "jdbcTemplateFive")
    public JdbcTemplate jdbcTemplateFive() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourceFour());
        return jdbcTemplate;
    }

    @Bean(value = "jdbcTemplateSix")
    public JdbcTemplate jdbcTemplateSix() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourceFour());
        return jdbcTemplate;
    }

    @Bean(value = "jdbcTemplateHIT")
    public JdbcTemplate jdbcTemplateHIT() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourceFive());
        return jdbcTemplate;
    }

    @Bean(value = "competitionMatrixService")
    public CompetitionMatrixService competitionMatrixService() {
        CompetitionMatrixService competitionMatrixService = new CompetitionMatrixService();
        return competitionMatrixService;
    }
    @Bean(value = "jdbcTemplateChen")
    public JdbcTemplate jdbcTemplateChen() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourcechen());
        return jdbcTemplate;
    }

    @Bean(value = "jdbcTemplateZheng")
    public JdbcTemplate jdbcTemplateZheng() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourcezheng());
        return jdbcTemplate;
    }

    @ConfigurationProperties(prefix = "spring.datasource.firstdb")
    @Primary
    @Bean
    public DataSource dataSourceOne() {
        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix = "spring.datasource.seconddb")
    @Bean
    public DataSource dataSourcetwo() {
        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix = "spring.datasource.thirddb")
    @Bean
    public DataSource dataSourcethree() {
        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix = "spring.datasource.fourthdb")
    @Bean
    public DataSource dataSourceFour() {
        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix = "spring.datasource.fifthdb")
    @Bean
    public DataSource dataSourceFive() {
        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix = "spring.datasource.chendb")
    @Bean
    public DataSource dataSourcechen() {
        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix = "spring.datasource.zhengdb")
    @Bean
    public DataSource dataSourcezheng() {
        return DataSourceBuilder.create().build();
    }
}
