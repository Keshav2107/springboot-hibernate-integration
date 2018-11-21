package com.example.sbhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;

@Service
public class SleuthService {

    private Tracer tracer;

    @Autowired
    public SleuthService(final Tracer tracer) {
        super();
        this.tracer = tracer;
    }

    /**
     * A method which gets the current Span Id.
     * 
     * @return Span ID
     */
    public String getSpanId() {
        Span span = tracer.getCurrentSpan();

        return span.traceIdString();

    }

}