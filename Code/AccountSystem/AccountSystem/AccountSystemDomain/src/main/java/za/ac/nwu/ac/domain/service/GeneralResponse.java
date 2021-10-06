package za.ac.nwu.ac.domain.service;

public class GeneralResponse<T> {
    private final T content;

    public GeneralResponse(T content) {
        this.content = content;
    }

    public T getContent(){
        return content;
    }
}
