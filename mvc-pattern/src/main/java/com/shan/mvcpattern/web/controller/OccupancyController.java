package com.shan.mvcpattern.web.controller;

import com.shan.mvcpattern.service.RoomReservationService;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/occupancy")
public class OccupancyController {

    private final RoomReservationService roomReservationService;

    public OccupancyController(RoomReservationService roomReservationService) {
        this.roomReservationService = roomReservationService;
    }

    @GetMapping
    public String getOccupancy(Model model, @RequestParam(value = "date", required = false) String dateString){
        Date date = new Date();
        if (StringUtils.isNotBlank(dateString)) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                date = format.parse(dateString);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        model.addAttribute("date", date);
        model.addAttribute("reservations", this.roomReservationService.getRoomReservationForDate(dateString));
        return "occupancy";
    }
}
