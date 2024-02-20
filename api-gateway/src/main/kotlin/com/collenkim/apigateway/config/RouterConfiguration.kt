package com.collenkim.apigateway.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RouterConfiguration {

    @Bean
    fun authRouteConfig(builder : RouteLocatorBuilder) : RouteLocator =
        builder.routes{
            route{
                path("/auth/**")
                    .uri("lb://auth-service")
            }
        }

    @Bean
    fun orderRouteConfig(builder : RouteLocatorBuilder) : RouteLocator =
        builder.routes {
            route{
                path("/order/**")
                    .uri("lb://order-service")
            }
        }

}