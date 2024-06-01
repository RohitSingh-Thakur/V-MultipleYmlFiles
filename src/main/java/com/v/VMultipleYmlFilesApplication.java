package com.v;

import java.util.Properties;  

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.v.util.YamlPropertiesLoader;

@SpringBootApplication
public class VMultipleYmlFilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VMultipleYmlFilesApplication.class, args);
	}

	 @Bean
	    public MessageSource messageSource() {
	        Properties properties = new Properties();
	        properties.putAll(YamlPropertiesLoader.loadYamlIntoProperties("fieldValidationMessages.yml"));
	        properties.putAll(YamlPropertiesLoader.loadYamlIntoProperties("mymsg.yml"));
	       
	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	        messageSource.setDefaultEncoding("UTF-8");
	        messageSource.setCommonMessages(properties);
	        return messageSource;
	    }

	    @Bean
	    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
	        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	        bean.setValidationMessageSource(messageSource);
	        return bean;
	    }
}
