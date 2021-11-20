package kz.homecreditbank.homework.exception;

public class ProcessingException extends RuntimeException{
    public String errorCode;

    public ProcessingException(String errorCode) {
        this.errorCode = errorCode;
    }
}
