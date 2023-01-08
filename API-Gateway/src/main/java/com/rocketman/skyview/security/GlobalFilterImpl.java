package com.rocketman.skyview.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalFilterImpl implements GlobalFilter {

    //GlobalFilter from Gateway enables us to add filter for all requests flowing in through gateway

    Logger LOG = LoggerFactory.getLogger(GlobalFilterImpl.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        LOG.info("=========ENTERED in Custom GLobalFilterImpl REQUEST==========");
        LOG.info("========="+ exchange.getRequest().getLocalAddress().toString() + "=========");
        ServerHttpRequest request = exchange.getRequest();

        if(request.getURI().toString().contains("/")) LOG.info("========="+ request.getURI().toString() + "=========");
        //We can give custom logic for our URIs this way

        //return chain.filter(exchange);
        //pass the request to appropriate microservice
        //Above part is for PRE-Filter, i.e. Gateway will filter from client then foward to MS

        //Now for POST-Filter, where Gateway will filter from MS then forward to Client
        return chain.filter(exchange).then(Mono.fromRunnable(() ->
        {
            ServerHttpResponse response = exchange.getResponse();
            LOG.info("=========ENTERED in Custom GLobalFilterImpl RESPONSE==========");
            LOG.info("========="+response.getStatusCode()+"==========");
        }));
    }
}



/*
2023-01-08 17:59:42.937  INFO [api-gateway,9df2750c8a489ea0,9df2750c8a489ea0] 474629 --- [nio-8900-exec-7] c.r.skyview.security.GlobalFilterImpl    : =========ENTERED in Custom GLobalFilterImpl REQUEST==========
2023-01-08 17:59:42.938  INFO [api-gateway,9df2750c8a489ea0,9df2750c8a489ea0] 474629 --- [nio-8900-exec-7] c.r.skyview.security.GlobalFilterImpl    : =========/127.0.0.1:8900=========
2023-01-08 17:59:42.938  INFO [api-gateway,9df2750c8a489ea0,9df2750c8a489ea0] 474629 --- [nio-8900-exec-7] c.r.skyview.security.GlobalFilterImpl    : =========http://localhost:8900/api-gateway/default=========
2023-01-08 17:59:44.383  INFO [api-gateway,9df2750c8a489ea0,9df2750c8a489ea0] 474629 --- [or-http-epoll-2] c.r.skyview.security.GlobalFilterImpl    : =========ENTERED in Custom GLobalFilterImpl RESPONSE==========
2023-01-08 17:59:44.384  INFO [api-gateway,9df2750c8a489ea0,9df2750c8a489ea0] 474629 --- [or-http-epoll-2] c.r.skyview.security.GlobalFilterImpl    : =========200 OK==========

[api-gateway,9df2750c8a489ea0,9df2750c8a489ea0]
MS Name, traceID, SpanID

*/
