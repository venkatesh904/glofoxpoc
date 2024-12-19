package com.gloflox.service;

import com.gloflox.model.Response;
import com.gloflox.model.StudioClass;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ClassService {

    private final Map<String, StudioClass> classes = new ConcurrentHashMap<>();

    public Response createClass(StudioClass studioClass) {
        if (studioClass.getName() == null || studioClass.getStartDate() == null ||
                studioClass.getEndDate() == null || studioClass.getCapacity() <= 0) {
            return new Response("Invalid input", false);
        }

        if (studioClass.getStartDate().isAfter(studioClass.getEndDate())) {
            return new Response("Start date must be before end date", false);
        }

        classes.put(studioClass.getName(), studioClass);
        return new Response("Class created successfully", true);
    }

    public List<StudioClass> getClasses() {
        return new ArrayList<>(classes.values());
    }
}
