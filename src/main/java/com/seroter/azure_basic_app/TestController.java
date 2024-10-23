package com.seroter.azure_basic_app;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    @GetMapping(value = "/testApi")
    public Response doStuff(@RequestParam("check") String check){
        log.info("received string - {} ",check);
        Response response = Response.builder()
                .val("Gowtham Raamachandranss")
                .build();
        log.info("Response - {}", response);
        return response;
    }

    @GetMapping(value = "/workout")
    public String workoutSession(){
        return "Hey its done!!";
    }

    @GetMapping(value = "/session")
    public String session(){
        return "Session!! its done!!";
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static
    class Response{
        String val;
    }
}
