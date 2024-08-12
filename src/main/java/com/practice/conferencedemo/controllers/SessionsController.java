package com.practice.conferencedemo.controllers;

import com.practice.conferencedemo.models.Session;
import com.practice.conferencedemo.service.SessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sessions")
public class SessionsController {
    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Session> getAll(){
        return sessionService.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session getById(@PathVariable Long id){
        return sessionService.getById(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        return sessionService.save(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        sessionService.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionService.getById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionService.save(existingSession);
    }




}
