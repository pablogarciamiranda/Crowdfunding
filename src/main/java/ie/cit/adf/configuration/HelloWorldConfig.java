package ie.cit.adf.configuration;

import java.util.Locale;

import org.springframework.boot.autoconfigure.web.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class HelloWorldConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public CookieLocaleResolver localeResolver() {
	CookieLocaleResolver localeResolver = new CookieLocaleResolver();
	localeResolver.setDefaultLocale(Locale.US);
	return localeResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
	return lci;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}
