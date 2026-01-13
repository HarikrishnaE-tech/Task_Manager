package com.Project.Task_Manager.Controller;

import com.Project.Task_Manager.Model.FileAttached;
import com.Project.Task_Manager.Service.FileAttachedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/fileattach")
public class FileAttachment {

    @Autowired
    FileAttachedService fileattach;
    @PostMapping("/uploadfile/task/{taskid}")
    public ResponseEntity<FileAttached> uploadFile
            (@RequestParam("file") MultipartFile file,
             @PathVariable Long taskid){
         FileAttached savedFile=  fileattach.storeFile(file,taskid);
         return new ResponseEntity<>(savedFile, HttpStatus.OK);

    }
    @GetMapping("/getfile/fileid/{fileid}")
    public ResponseEntity<FileAttached> getFile(@PathVariable Long fileid){
         FileAttached file  =     fileattach.getFile(fileid);
         return new ResponseEntity<>(file,HttpStatus.OK);

    }
    @GetMapping("/getfilesoftask/task/{taskid}")
    public ResponseEntity<List<FileAttached>> getFilesofTask(@PathVariable  Long taskid){
                   List<FileAttached> lfile=     fileattach.getFilesofTask(taskid);
                   return new ResponseEntity<>(lfile,HttpStatus.OK);
    }
    @DeleteMapping("/deletefile/file/{fileid}")
    public ResponseEntity<String> deleteFile(@PathVariable Long fileid){
        String string =fileattach.deleteFile(fileid);
        return new ResponseEntity<>(string, HttpStatus.OK);
    }







}
