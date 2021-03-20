package me.iiaii.springrevision.practice.web;

import lombok.RequiredArgsConstructor;
import me.iiaii.springrevision.practice.common.MyLogger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
