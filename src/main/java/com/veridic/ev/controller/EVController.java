package com.veridic.ev.controller;

import com.veridic.ev.pojo.Station;
import com.veridic.ev.service.EVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/ev/")
public class EVController {

    @Autowired
    private PropertyConfig config;
    @Value("${greet.message}")
    private String message;

    private EVService service;

    public EVController(EVService service){
        this.service = service;
    }
    @RequestMapping(path = "health", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public String health() {
        return this.config.getMessage()+this;
    }


//    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
//    public String submit(@RequestParam("file") MultipartFile file) throws IOException {
//        InputStream inputStream = file.getInputStream();
//        byte[] bytes = inputStream.readAllBytes();
//        System.out.println(new String(bytes));
//
//        return "fileUploadView";
//    }
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Station>> getAllStation(@RequestParam(required = false) Integer limit, @RequestParam(required = false) String sort, @RequestParam(required = false) String param) {
        return ResponseEntity.of(Optional.ofNullable(service.getALlStations(limit, sort, param)));
    }

    @RequestMapping(path = "show/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Station> getAllStation(@PathVariable long id) {
        return ResponseEntity.of(service.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST,consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> save(@RequestBody Station station) {
        return ResponseEntity.of(Optional.ofNullable(service.save(station)));
    }

    @RequestMapping(path = "{id}/edit", method = RequestMethod.PUT,consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateById(@PathVariable long id,@RequestBody Station station) {
        return ResponseEntity.of(Optional.of(service.updateById(id, station)));
    }

    @RequestMapping(path = "delete/{id}",method = RequestMethod.DELETE,produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}
