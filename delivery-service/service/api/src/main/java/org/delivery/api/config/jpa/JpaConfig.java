package org.delivery.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "org.delivery.db") // 다른 패키지의 빈을 주입시키기 위해서 설정
@EnableJpaRepositories(basePackages = "org.delivery.db")
public class JpaConfig {
}
