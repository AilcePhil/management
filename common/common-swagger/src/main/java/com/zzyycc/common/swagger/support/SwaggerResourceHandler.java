package com.zzyycc.common.swagger.support;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className SwaggerResourceHandler
 * @createTime 2022/2/23 10:33
 * @description
 */

@Component
public class SwaggerResourceHandler implements HandlerFunction<ServerResponse> {

    @Autowired
    private SwaggerResourcesProvider swaggerResources;

    /**
     * Handle the given request.
     * @param request the request to handler
     * @return the response
     */
    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(swaggerResources.get()));
    }


}
