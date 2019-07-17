package io.wooo.evertools;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author wushuaiping
 * @date 2019/7/5 09:46
 */
@RestController
@RequestMapping("/date-utils")
public class ToolsController {

    @GetMapping("/ms-convert")
    public Mono<ServerResponse> msToDateString(@RequestParam(value = "ms") Long ms) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromObject(new Date(ms).toString()));
    }

}
