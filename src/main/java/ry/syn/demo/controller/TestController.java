package ry.syn.demo.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ry.syn.demo.services.TestService;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService service;
    @GetMapping()
    public Boolean getRootTest() {
        return false;
    }

    @GetMapping("/getApple/{count}")
    public List<String> getApple(@PathVariable("count") int count) {
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < count; ++i)
            ret.add(service.appleName + "#" + i);
        return ret;
    }

    @PostMapping("/setAppleName")
    public boolean setAppleName(@RequestBody() Map<String, Object> body) {
        try {
            if (body.containsKey("name")) {
                 return service.setAppleName((String) body.get("name"));
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
