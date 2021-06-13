package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);

        return compensationService.create(compensation);
    }

    @PutMapping("/compensation/{id}")
    public Compensation update(@PathVariable String id, @RequestBody Compensation compensation) {
        LOG.debug("Received compensation update request with id [{}]", id);

        compensation.setCompensationId(id);
        return compensationService.update(compensation);
    }

    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Read compensation by the given compensationId [{}]", id);
        return compensationService.read(id);
    }

    @GetMapping("/compensation/read/{employeeId}")
    public List<Compensation> readByEmployeeId(@PathVariable String employeeId) {
        LOG.debug("Read compensation by the given employeeId [{}]", employeeId);
        return compensationService.readByEmployeeId(employeeId);
    }
}
