package mohu.smartID.gitex.models;

public class Response<T> {
    String status;
    String message;
    Integer statusCode;
    T output;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public T getOutput() {
        return output;
    }

    public void setOutput(T output) {
        this.output = output;
    }
}
