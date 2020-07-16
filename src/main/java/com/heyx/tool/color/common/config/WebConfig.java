package com.heyx.tool.color.common.config;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@EnableSwagger2Doc
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Value("${web.file.root}")
    private String rootPath;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        //文件映射
        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:" + rootPath + "/file/");
        //静态文件
        registry.addResourceHandler("/public/**")
                .addResourceLocations("classpath:/static/public/");

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        /*添加swagger静态页面*/
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        super.addResourceHandlers(registry);
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
