package com.devswpro.config;

import com.devswpro.dao.IUsuarioDAO;
import com.devswpro.resolver.UserResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class ApplicationMvcConfig implements WebMvcConfigurer {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserResolver(usuarioDAO));
    }

}
