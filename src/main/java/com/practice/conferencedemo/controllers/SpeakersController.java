package com.practice.conferencedemo.controllers;

import com.practice.conferencedemo.models.Speaker;
import com.practice.conferencedemo.repositories.SpeakersRepository;
import com.practice.conferencedemo.service.SpeakerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerService speakerService;

    @GetMapping
    public List<Speaker> list(){
        return speakerService.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker getById(@PathVariable Long id){
        return speakerService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Speaker speaker){
        if(speaker.getSpeaker_photo() == null)
            speaker.setSpeaker_photo(null);
        speakerService.save(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerService.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerService.getById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerService.save(existingSpeaker);
    }


}
