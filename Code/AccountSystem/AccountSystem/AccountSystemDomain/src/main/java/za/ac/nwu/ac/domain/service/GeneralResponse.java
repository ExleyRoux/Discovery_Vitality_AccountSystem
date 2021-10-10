package za.ac.nwu.ac.domain.service;

import java.io.Serializable;

public class GeneralResponse<T> implements Serializable {
    private final transient T content;
    private final boolean successful;

    public GeneralResponse(T content){
        this.successful = false;
        this.content = content;
    }

    public GeneralResponse(boolean successful, T content) {
        this.successful = successful;
        this.content = content;
    }

    public boolean isSuccessful(){return successful;}
    public T getContent(){return content;}
}
