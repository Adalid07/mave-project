package com.rev.cat.catservice.web.file;

import com.rev.cat.catservice.domain.file.model.File;
import com.rev.cat.catservice.domain.file.payload.FileRequestDTO;
import com.rev.cat.catservice.service.file.DBFileStorageService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rveizaga
 */
@RestController
@RequestMapping("/files")
@Api(value = "files", description = "Operations related to files")
public class FileController {

    private DBFileStorageService fileService;

    public FileController(DBFileStorageService fileService) {
        this.fileService = fileService;
    }
    
    // TODO: Improve implementations with findAll
    @RequestMapping(method = RequestMethod.GET)
    public List<File> findAll() {
        return fileService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public File findById(@PathVariable String id) {
        return fileService.findById(id);
    }

    @RequestMapping(
            value = "/{referenceId}",
            method = RequestMethod.POST
    )
    public File upload(@RequestParam("file") MultipartFile multipart, @PathVariable String referenceId) {
        FileRequestDTO dto = new FileRequestDTO(referenceId);
        return fileService.upload(multipart, dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public File delete(@PathVariable String id) {
        return fileService.delete(id);
    }
}
