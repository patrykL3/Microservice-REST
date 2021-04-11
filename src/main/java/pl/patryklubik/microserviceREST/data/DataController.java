package pl.patryklubik.microserviceREST.data;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by Patryk Łubik on 08.04.2021.
 */

@RestController
@RequestMapping("/message")
public class DataController {

    private final DataService dataService;

    DataController(DataService dataService) {
        this.dataService = dataService;
    }


    @GetMapping(path = "{id}")
    ResponseEntity<String> getDataById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(dataService.findById(id));
    }

    @GetMapping
    ResponseEntity<List<Data>> getAllData() {

        return ResponseEntity.ok(dataService.getAllData());
    }

    @PostMapping
    ResponseEntity<Data> saveData(@RequestBody Data data) {
        return ResponseEntity.ok(dataService.save(data));
    }

    @PutMapping("/{id}")
    ResponseEntity<Data> updateData(@PathVariable Integer id, @RequestBody Data data) {
        return ResponseEntity.ok(dataService.updateData(id, data.getContent()));
    }

    @DeleteMapping("/{id}")
    void deleteData(@PathVariable Integer id) {
        dataService.deleteData(id);
    }
}
