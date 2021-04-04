package http;

public enum HttpStatusCode {
    //   CLIENT ERRORS
    CLIENT_ERROR_400_BAD_REQUEST(400,"BadRequest"),
    CLIENT_ERROR_401_METHOD_NOT_ALLOWED(401,"Method not allowed"),
    CLIENT_ERROR_414_BAD_REQUEST(414,"Url Too Long"),
    //  SERVER ERRORS
    SERVER_ERROR_500_INTERNAL_ERROR(500,"Internal Server Error"),
    SERVER_ERROR_501_NOT_IMPLEMENTED(500,"Not Implemented"),

    ;

    public final int STATUS_CODE ;
    public final String MESSAGE ;


    HttpStatusCode(int STATUS_CODE, String MESSAGE){
        this.STATUS_CODE = STATUS_CODE ;
        this.MESSAGE = MESSAGE ;
    }
}
