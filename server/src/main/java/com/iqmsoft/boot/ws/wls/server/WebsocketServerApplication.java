package com.iqmsoft.boot.ws.wls.server;

import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
//@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
@EnableWebSocket
@EnableAsync
@ComponentScan("com.iqmsoft.boot.ws.wls")
public class WebsocketServerApplication  extends SpringBootServletInitializer 
implements WebApplicationInitializer{

	public static void main(String[] args) {
		SpringApplication.run(WebsocketServerApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebsocketServerApplication.class);
	}
	
	
	
	@Bean
	public WebSocketConfigurer socketConfig() {
		
		
		return new WebSocketConfigurer() {
		
			@Override
			public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
				registry.addHandler(handler(), "/atom/gwidgets-ws").setAllowedOrigins("*");
			}
		};
		
		
	}
	
	@Bean
	public SocketHandler handler(){
		return new SocketHandler();
	}
	
	@Bean
	public WebSocketController echoEndpoint() {
	        return new WebSocketController();
	}
	
	@Bean
    public ServletContextAware endpointExporterInitializer(final ApplicationContext applicationContext) {
        return new ServletContextAware() {
            @Override
            public void setServletContext(ServletContext servletContext) {
                ServerEndpointExporter exporter = new ServerEndpointExporter();
                exporter.setApplicationContext(applicationContext);
                exporter.afterPropertiesSet();
            }
        };
    }

}
