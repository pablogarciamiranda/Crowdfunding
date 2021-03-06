package ie.cit.adf.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("main");
        registry.addViewController("/project").setViewName("project");
        registry.addViewController("/edit").setViewName("edit");
        registry.addViewController("/create").setViewName("create");
        registry.addViewController("/pledges").setViewName("pledges");
    }
}
