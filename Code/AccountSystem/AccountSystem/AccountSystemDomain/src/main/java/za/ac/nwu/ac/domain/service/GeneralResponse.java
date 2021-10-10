package za.ac.nwu.ac.domain.service;

import java.io.Serializable;

public class GeneralResponse<T> implements Serializable {
    private final T content;
    private final boolean successful;

    public GeneralResponse(T content) {
        this.content = content;
        this.successful = false;
    }

    public GeneralResponse(boolean successful, T content){
        this.successful = successful;
        this.content = content;
    }

    public GeneralResponse(){
        this.successful = false;
        this.content = null;
    }

    public boolean isSuccessful(){
        return false;
    }

    public T getContent(){
        return content;
    }
}
