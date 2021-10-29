package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.AnswerDAO;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/answers")
public class AnswerController {
    @Autowired
    private AnswerDAO answerDAO;
    @Autowired
    private AnswerService answerService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Answer>> getAll(){
        return new ResponseEntity<>(this.answerDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Answer> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.answerDAO.get(id), HttpStatus.OK);
    }

    @GetMapping(value = "/currentContentId/{currentContentId}")
    @ResponseBody
    public ResponseEntity<List<Answer>> getByCurrentContentId(@PathVariable("currentContentId") Long currentContentId){
        return new ResponseEntity<>(this.answerDAO.getByCurrentContentId(currentContentId), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Answer> post(@RequestBody Answer answer){
        return new ResponseEntity<>(this.answerDAO.create(answer), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Answer> put(@RequestBody Answer answer){
        this.answerService.update(answer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Answer> delete(@RequestBody Answer answer){
        this.answerDAO.delete(answer);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
