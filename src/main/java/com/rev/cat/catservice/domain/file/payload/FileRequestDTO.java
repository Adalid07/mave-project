package com.rev.cat.catservice.domain.file.payload;

/**
 * @author rveizaga
 */
public class FileRequestDTO {
    private String referenceId;

    public FileRequestDTO(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
