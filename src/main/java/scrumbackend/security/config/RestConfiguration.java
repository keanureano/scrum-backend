package scrumbackend.security.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class RestConfiguration implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(
    RepositoryRestConfiguration config,
    CorsRegistry cors
  ) {
    cors
      .addMapping("/**")
      .allowedOrigins("*")
      .allowedMethods("*")
      .allowedHeaders("*")
      .exposedHeaders("Access-Control-Allow-Origin")
      .allowCredentials(false)
      .maxAge(3600);
  }
}
