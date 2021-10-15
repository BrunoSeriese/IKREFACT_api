package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.ExplanationDAO;
import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/explanations")
public class ExplanationController {
    private final ExplanationDAO explanationDAO;

    @Autowired
    public ExplanationController(ExplanationDAO explanationDAO) {
        this.explanationDAO = explanationDAO;
    }

    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<Explanation>> getAll(){
        return new ResponseEntity<>(this.explanationDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Explanation> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.explanationDAO.get(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    @ResponseBody
    public ResponseEntity<Explanation> post(@RequestBody Explanation explanation){
        return new ResponseEntity<>(this.explanationDAO.create(explanation), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Explanation> put(@PathVariable("id") Long id){
        this.explanationDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "")
    @ResponseBody
    public ResponseEntity<Explanation> delete(@RequestBody Explanation explanation{
        this.explanationDAO.delete(explanation);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
