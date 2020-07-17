package com.myPortfolio.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.myPortfolio")
public class SpringConfig implements WebMvcConfigurer {
	@Bean
	public ViewResolver viewResolver()
	{
	
		InternalResourceViewResolver viewresolver = new InternalResourceViewResolver();
		viewresolver.setViewClass(JstlView.class);
        viewresolver.setPrefix("/WEB-INF/pages/");
        viewresolver.setSuffix(".jsp");

        return viewresolver;
	}
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    
    }
}
