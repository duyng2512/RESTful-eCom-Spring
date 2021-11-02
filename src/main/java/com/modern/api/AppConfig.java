package com.modern.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import reactor.core.publisher.Flux;

@Configuration
@Slf4j
public class AppConfig {
    @Bean
    public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }

    @Bean
    public void coldStream(){
        log.debug("--------- Hot Stream Start ---------");
        Flux<Integer> fluxInt = Flux.just(1, 10, 100).log();
        fluxInt.reduce(Integer::sum).subscribe(sum -> log.debug("Sum : {}", sum));
        fluxInt.reduce(Integer::max).subscribe(max -> log.debug("Max : {}", max));
        log.debug("--------- Hot Stream End ---------");
    }

    @Bean
    public void hotStream(){
        log.debug("--------- Cold Stream Start ---------");
        Flux<Integer> fluxInt = Flux.just(1, 10, 100).log().cache();
        fluxInt.reduce(Integer::sum).subscribe(sum -> log.debug("Sum : {}", sum));
        fluxInt.reduce(Integer::max).subscribe(max -> log.debug("Max : {}", max));
        log.debug("--------- Cold Stream End ---------");
    }
}