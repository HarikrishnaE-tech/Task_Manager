package com.Project.Task_Manager.Service;

import com.Project.Task_Manager.Model.FileAttached;
import com.Project.Task_Manager.Model.Task;
import com.Project.Task_Manager.Repository.FileAttachedrepo;
import com.Project.Task_Manager.Repository.TaskRepo;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Service
public class FileAttachedServiceIMPL  implements FileAttachedService{

    private final Set<String> ALLOWED_TYPES = Set.of(
            "application/pdf", "image/png", "image/jpeg", "application/msword",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
    );

    private final long MAX_FILE_SIZE = 20 * 1024 * 1024; // 20 MB
    @Autowired
    TaskRepo taskrepo;

    @Autowired
    FileAttachedrepo fileAttachedrepo;





    @Override
    public FileAttached storeFile(MultipartFile file, Long taskid) {
    if(file==null|| file.isEmpty()){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"file is empty");
    }
    if(file.getSize() > MAX_FILE_SIZE){
        throw new ResponseStatusException(HttpStatus.FORBIDDEN,"file size is not excepted");
    }

     String contentType= file.getContentType();
    if(contentType==null || !ALLOWED_TYPES.contains(contentType)){
        throw new ResponseStatusException(HttpStatus.NO_CONTENT,"content is null or type is different");
    }
      Task task=taskrepo.findById(taskid).orElseThrow(()-> new ResponseStatusException(HttpStatus.FOUND,"id didnt exist"));

    FileAttached fileAttach= new FileAttached();
    fileAttach.setFileName(file.getOriginalFilename());
    fileAttach.setTask(task);
    fileAttach.setSize(file.getSize());
    fileAttach.setContentType(contentType);
    fileAttach.setUploadAt(LocalDateTime.now());


        return fileAttachedrepo.save(fileAttach);
    }

    @Override
    public FileAttached getFile(Long fileid) {

        return fileAttachedrepo.findById(fileid).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"perticular id is not found"));

    }

    @Override
    public List<FileAttached> getFilesofTask(Long taskid) {

         List<FileAttached> lFile=      fileAttachedrepo.getFilesofTask(taskid);
            if(lFile==null|| lFile.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NO_CONTENT,"no item exist in it");
            }
            return lFile;
    }

    @Override
    public String deleteFile(Long fileid) {
         fileAttachedrepo.deleteById(fileid);
         return "filedeleted Successfully";
    }
}
