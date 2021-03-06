package com.trasher.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trasher.spring.model.Robot;
import com.trasher.spring.service.RobotService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RobotController {

   @Autowired
   private RobotService robotService;

   /*---Add new robot---*/
   @PostMapping("/robot")
   public ResponseEntity<?> save(@RequestBody Robot robot) {
      long id = robotService.save(robot);
      return ResponseEntity.ok().body("New Robot has been saved with id:" + id);
   }

   /*---Get a robot by id---*/
   @GetMapping("/robot/{id}")
   public ResponseEntity<Robot> get(@PathVariable("id") long id) {
	  Robot robot = robotService.get(id);
      return ResponseEntity.ok().body(robot);
   }

   /*---get all robots---*/
   @GetMapping("/robot")
   public ResponseEntity<List<Robot>> list() {
      List<Robot> robots = robotService.list();
      return ResponseEntity.ok().body(robots);
   }

   /*---Update a robot by id---*/
   @PutMapping("/robot/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Robot robot) {
	  robotService.update(id, robot);
      return ResponseEntity.ok().body("Robot has been updated successfully.");
   }

   /*---Delete a robot by id---*/
   @DeleteMapping("/robot/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	   robotService.delete(id);
      return ResponseEntity.ok().body("Robot has been deleted successfully.");
   }
}