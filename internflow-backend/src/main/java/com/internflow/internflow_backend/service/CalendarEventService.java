package com.internflow.internflow_backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.entity.CalendarEvent;
import com.internflow.internflow_backend.repository.CalendarEventRepository;

@Service
public class CalendarEventService {

    private final CalendarEventRepository calendarEventRepository;

    public CalendarEventService(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    public List<CalendarEvent> getAllCalendarEvents() {
        return calendarEventRepository.findAll();
    }

    public CalendarEvent getCalendarEventById(UUID id) {
        return calendarEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendar event not found"));
    }

    public CalendarEvent createCalendarEvent(CalendarEvent calendarEvent) {
        return calendarEventRepository.save(calendarEvent);
    }

    public CalendarEvent updateCalendarEvent(UUID id, CalendarEvent updatedCalendarEvent) {
        CalendarEvent existingCalendarEvent = getCalendarEventById(id);

        existingCalendarEvent.setTitle(updatedCalendarEvent.getTitle());
        existingCalendarEvent.setStartAt(updatedCalendarEvent.getStartAt());
        existingCalendarEvent.setEndAt(updatedCalendarEvent.getEndAt());
        existingCalendarEvent.setApplication(updatedCalendarEvent.getApplication());
        existingCalendarEvent.setInterview(updatedCalendarEvent.getInterview());
        existingCalendarEvent.setType(updatedCalendarEvent.getType());
        existingCalendarEvent.setNotes(updatedCalendarEvent.getNotes());

        return calendarEventRepository.save(existingCalendarEvent);
    }

    public void deleteCalendarEvent(UUID id) {
        calendarEventRepository.deleteById(id);
    }
}