package com.example.demo.config;

import com.example.demo.bean.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;
import org.thymeleaf.util.StringUtils;

@Configuration
public class WebConfig {  //implements WebMvcConfigurer {


    // 配置矩阵可以生效
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer){
//
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        urlPathHelper.setRemoveSemicolonContent(false);
//
//        configurer.setUrlPathHelper(urlPathHelper);
//
//    }

    // WebMvcConfigurer定制化开发springMVC的功能
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {

        return new WebMvcConfigurer() {

            // 配置矩阵生效
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {

                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);

                configurer.setUrlPathHelper(urlPathHelper);

            }


            // 手动添加converter 可以是参数用自定义的传入逻辑
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, UserBean>() {
                    @Override
                    public UserBean convert(String source) {
                        if (!StringUtils.isEmpty(source)) {

                            UserBean userBean = new UserBean();

                            String[] split = source.split(",");

                            userBean.setId(Integer.parseInt(split[0]));
                            userBean.setName(split[1]);

                            return userBean;
                        }
                        return null;
                    }
                });
            }
        };

    }




}
