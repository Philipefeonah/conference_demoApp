package com.practice.conferencedemo.service;

import com.practice.conferencedemo.models.Session;
import com.practice.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> findAll(){
        return sessionRepository.findAll();
    }

    public Session getById(Long id){
        return sessionRepository.getReferenceById(id);
    }

    public Session save(Session session){
        return sessionRepository.saveAndFlush(session);
    }

    public void deleteById(Long id) {
        sessionRepository.deleteById(id);
    }

}
