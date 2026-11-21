package com.internflow.internflow_backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.internflow.internflow_backend.entity.CalendarEvent;
import com.internflow.internflow_backend.service.CalendarEventService;

@RestController
@RequestMapping("/api/calendar-events")
public class CalendarEventController {

    private final CalendarEventService calendarEventService;

    public CalendarEventController(CalendarEventService calendarEventService) {
        this.calendarEventService = calendarEventService;
    }

    @GetMapping
    public List<CalendarEvent> getAllCalendarEvents() {
        return calendarEventService.getAllCalendarEvents();
    }

    @GetMapping("/{id}")
    public CalendarEvent getCalendarEventById(@PathVariable UUID id) {
        return calendarEventService.getCalendarEventById(id);
    }

    @PostMapping
    public CalendarEvent createCalendarEvent(@RequestBody CalendarEvent calendarEvent) {
        return calendarEventService.createCalendarEvent(calendarEvent);
    }

    @PutMapping("/{id}")
    public CalendarEvent updateCalendarEvent(
            @PathVariable UUID id,
            @RequestBody CalendarEvent calendarEvent) {
        return calendarEventService.updateCalendarEvent(id, calendarEvent);
    }

    @DeleteMapping("/{id}")
    public void deleteCalendarEvent(@PathVariable UUID id) {
        calendarEventService.deleteCalendarEvent(id);
    }
}