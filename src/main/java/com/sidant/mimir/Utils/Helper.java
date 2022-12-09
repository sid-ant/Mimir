package com.sidant.mimir.Utils;

import com.sidant.mimir.ErrorConstants;
import com.sidant.mimir.Exceptions.UnsupportedOperation;

public class Helper {

    public static boolean isUserRegistered(Integer chatId) {
        return false;
    }

    public static void createUserIfNotExists(
            Integer chatId
    ) {

    };

    public static void validateText(String text) throws UnsupportedOperation {
        if (text == null)
            throw new UnsupportedOperation(ErrorConstants.ONLY_TEXT_SUPPORTED);
    }

}
