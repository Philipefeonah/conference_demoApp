package com.practice.conferencedemo.service;

import com.practice.conferencedemo.models.Speaker;
import com.practice.conferencedemo.repositories.SpeakersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerService {

    @Autowired
    private SpeakersRepository speakersRepository;

    public List<Speaker> findAll(){
        return speakersRepository.findAll();
    }

    public Speaker getById(Long id){
        return speakersRepository.getReferenceById(id);
    }

    public Speaker save(Speaker speaker){
        return speakersRepository.saveAndFlush(speaker);
    }

    public void deleteById(Long id){
        speakersRepository.deleteById(id);
    }

}
