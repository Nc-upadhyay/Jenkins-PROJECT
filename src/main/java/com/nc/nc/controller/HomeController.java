package com.nc.nc.controller;

import com.nc.nc.entities.TaskEntity;
import com.nc.nc.model.TaskModel;
import com.nc.nc.model.UserModel;
import com.nc.nc.service.MyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@Tag(name = "Home Controller",description = "This is home controller description")
public class HomeController {
    @Autowired
    MyService myService;

    @GetMapping("/sign-in/{username}/{password}")
    public ResponseEntity singIn(@PathVariable String username, @PathVariable String password) {
        return myService.signIn(username, password);
    }

    @Operation(summary = "summery",description = "This is used to for sign up ")
    @PostMapping("/sign-up")
    public ResponseEntity singUp(@RequestBody UserModel userModel) {
        return myService.singUp(userModel);
    }

    @Operation(summary = "summery",description = "This is used to for create")
    @PostMapping("/create")
    public ResponseEntity createTask(@RequestBody TaskModel taskModel) {
        return myService.createTask(taskModel);
    }

    @Operation(summary = "summery",description = "This is used to for get deskbord ")
    @GetMapping("/desk-board/{userId}")
    public List<TaskModel> getDeskBoardData(@PathVariable Long userId) {
        return myService.getTasks(userId);
    }

    @GetMapping("/status/{status}/{userId}")
    public List<TaskModel> getFilterData(@PathVariable String status, @PathVariable Long userId) {
        return myService.getFilteredData(status, userId);
    }

    @PutMapping("/update-status/{taskId}/{status}")
    public ResponseEntity updateStatus(@PathVariable Long taskId, @PathVariable String status) throws ChangeSetPersister.NotFoundException {
        return myService.updateStatus(taskId, status);
    }

    @DeleteMapping("delete-task/{taskId}")
    public ResponseEntity deleteStatus(@PathVariable Long taskId) throws ChangeSetPersister.NotFoundException {
        return myService.deleteStatus(taskId);
    }
}
