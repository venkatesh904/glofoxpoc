package com.gloflox.controller;

import com.gloflox.model.Response;
import com.gloflox.model.StudioClass;
import com.gloflox.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public Response createClass(@RequestBody StudioClass studioClass) {
        return classService.createClass(studioClass);
    }

    @GetMapping
    public List<StudioClass> getClasses() {
        return classService.getClasses();
    }
}
