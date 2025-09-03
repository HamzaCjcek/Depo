package com.project.depo_ai.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/admin/index");
        registry.addViewController("/calendar").setViewName("/admin/calendar");
        registry.addViewController("/chart").setViewName("/admin/chart");
        registry.addViewController("/form").setViewName("/admin/form");
    }
}
