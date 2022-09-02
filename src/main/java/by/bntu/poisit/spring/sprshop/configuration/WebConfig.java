
package by.bntu.poisit.spring.sprshop.configuration;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "by.bntu.poisit.spring.sprshop")
public class WebConfig implements WebMvcConfigurer {

    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
    // =======================================
    // =             Bean Config             =
    // =======================================

    


    // =======================================
    // =          Override Methods           =
    // =======================================

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/static/css/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("/static/js/");

        registry.addResourceHandler("/video/**")
                .addResourceLocations("/static/video/");
        
        registry.addResourceHandler("/fullsize/**")
                .addResourceLocations("/assets/img/portfolio/fullsize/");
        
        registry.addResourceHandler("/thumbnails/**")
                .addResourceLocations("/assets/img/portfolio/thumbnails/");
        
        registry.addResourceHandler("/img/**")
                .addResourceLocations("/assets/img/");
        
         registry.addResourceHandler("/black/**")
                .addResourceLocations("/assets/img/products/black/");
    }


   
}
