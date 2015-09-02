package com.github.pabloo99;

import com.github.pabloo99.xmlsoccer.api.dto.GetTeamResultDto;
import com.github.pabloo99.xmlsoccer.client.XmlSoccerServiceImpl;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class Test {

    @RequestMapping("/")
    String home() {

        XmlSoccerServiceImpl xmlSoccerService = new XmlSoccerServiceImpl();
        xmlSoccerService.setServiceUrl("http://www.xmlsoccer.com/FootballDataDemo.asmx");
        xmlSoccerService.setApiKey("YOUR API KEY");
        List<GetTeamResultDto> teams = xmlSoccerService.getAllTeams();

        String result = "";

        for(GetTeamResultDto entry : teams)
        {
            result = result + "<br/>" + entry.getName();
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Test.class, args);
    }

}