package by.refor.mobilefarm.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("by.refor.mobilefarm.model.entity")
public class JpaConfiguration {
}
