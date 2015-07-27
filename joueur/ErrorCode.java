package joueur;

public enum ErrorCode {
    NONE(0),
    INVALID_ARGS(20),
    COULD_NOT_CONNECT(21),
    DISCONNECTED_UNEXPECTEDLY(22),
    CANNOT_READ_SOCKET(23),
    DELTA_MERGE_FAILURE(24),
    REFLECTION_FAILED(25),
    UNKNOWN_EVENT_FROM_SERVER(26),
    SERVER_TIMEOUT(27),
    INVALID_EVENT(28),
    GAME_NOT_FOUND(29);
    
    private int returnNumber;
    
    private ErrorCode(int returnNumber) {
        this.returnNumber = returnNumber;
    }
    
    public static void handleError(Exception e, ErrorCode errorCode, String errorMessage) {
        if (errorMessage != null) {
            System.err.println("ERROR: " + errorMessage);
        }
        
        if(e != null) {
            e.printStackTrace();
        }

        System.exit(errorCode.returnNumber);
    }
}
