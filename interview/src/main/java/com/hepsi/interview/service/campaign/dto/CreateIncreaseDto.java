package com.hepsi.interview.service.campaign.dto;

import com.hepsi.interview.utils.Status;
import lombok.*;

import java.sql.Time;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateIncreaseDto {

    public UUID campaignId;

    public Time time;
}
