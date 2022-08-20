package bg.softuni.happytravel.config;

import bg.softuni.happytravel.interceptors.LoggingInterceptor;
import bg.softuni.happytravel.service.MaintenanceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final MaintenanceInterceptor maintenanceInterceptor;

    public WebConfig(MaintenanceInterceptor maintenanceInterceptor) {
        this.maintenanceInterceptor = maintenanceInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(maintenanceInterceptor);
        //registry.addInterceptor(new LoggingInterceptor());
    }

}
