package com.seroter.azure_basic_app;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.extern.slf4j.Slf4j;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${institute.name}")
    private String instituteName;

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

    @GetMapping(value = "/teamInfo")
    public String teamInfo(){
        return coachName + " - " + instituteName;
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
