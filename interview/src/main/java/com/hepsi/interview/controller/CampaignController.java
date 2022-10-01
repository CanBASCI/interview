package com.hepsi.interview.controller;

import com.hepsi.interview.service.campaign.dto.CampaignDto;
import com.hepsi.interview.service.campaign.dto.CreateCampaignDto;
import com.hepsi.interview.service.campaign.operation.CampaignOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampaignController {
    @Autowired
    CampaignOperation campaignOperation;

    @GetMapping("/getAllCampaign")
    List<CampaignDto> getAllProducts(){

        return campaignOperation.getAllCampaign();
    }

    @GetMapping("/getCampaignInfo/{name}")
    CampaignDto getCampaignInfo(@PathVariable("name") String name){
        return campaignOperation.getCampaignInfo(name);
    }

    @PostMapping("/createCampaign")
    CampaignDto createCampaign(@RequestBody CreateCampaignDto createCampaignDto){
        return campaignOperation.createCampaign(createCampaignDto);
    }
}
