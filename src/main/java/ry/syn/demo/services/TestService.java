package ry.syn.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
@Component
public class TestService {
    public String appleName = "Apple";

    public boolean setAppleName(String appleName) {
        this.appleName=appleName.toUpperCase();
        return true;
    }
}
