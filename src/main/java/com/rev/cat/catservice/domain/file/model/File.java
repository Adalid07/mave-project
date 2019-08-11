package com.rev.cat.catservice.domain.file.model;

import com.rev.cat.catservice.domain.bootstrap.GenericDomain;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author rveizaga
 */
@Document
public class File extends GenericDomain {

    private Binary file;
    private String referenceId;

    public Binary getFile() {
        return file;
    }

    public void setFile(Binary file) {
        this.file = file;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
