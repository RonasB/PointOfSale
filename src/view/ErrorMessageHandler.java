package view;

import java.time.*;

/**
 * Handles printing error messages to the user.
 */
public class ErrorMessageHandler {

    /**
     * Prints the error message to the user. States that it is and error and includes the time.
     * @param msg The message that will be shown to the user.
     */
    public void showErrorMsg (String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(createTime());
        sb.append(", ERROR: ");
        sb.append(msg);
        System.out.println(sb);
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.toLocalDate().toString();
    }
}
