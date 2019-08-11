package com.rev.cat.catservice.service.file;

import com.rev.cat.catservice.domain.file.model.File;
import com.rev.cat.catservice.domain.file.payload.FileRequestDTO;
import com.rev.cat.catservice.exception.FileStorageException;
import com.rev.cat.catservice.exception.MyFileNotFoundException;
import com.rev.cat.catservice.repository.file.DBFileRepository;
import com.rev.cat.catservice.service.bootstrap.GenericService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author rveizaga
 */

@Service
public class DBFileStorageService extends GenericService<File, FileRequestDTO> {

    private DBFileRepository dbFileRepository;

    public DBFileStorageService(DBFileRepository fileRepository) {
        this.dbFileRepository = fileRepository;
    }

    @Override
    public List<File> findAll() {
        return null;
    }

    @Override
    public File findById(String id) {
        return null;
    }

    @Override
    public File delete(String id) {
        return null;
    }

    @Override
    public File insert(FileRequestDTO dto) {
        return null;
    }

    @Override
    public File update(String id, FileRequestDTO dto) {
        return null;
    }

    public File upload(MultipartFile multipart, FileRequestDTO dto) {
        File file = buildCreateFile(dto, multipart);
        file = dbFileRepository.insert(file);
        return file;
    }

    private File buildCreateFile(FileRequestDTO dto, MultipartFile multipart) {
        File file = new File();
        setFileInformation(dto, file, multipart);

        return file;
    }

    private void setFileInformation(FileRequestDTO dto, File file, MultipartFile multipart) {
        try {
            file.setReferenceId(dto.getReferenceId());
            file.setFile(new Binary(BsonBinarySubType.BINARY, multipart.getBytes()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
