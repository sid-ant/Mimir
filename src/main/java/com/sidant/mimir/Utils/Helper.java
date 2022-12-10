package com.sidant.mimir.Utils;

import com.sidant.mimir.ErrorConstants;
import com.sidant.mimir.Exceptions.UnsupportedOperation;
import org.springframework.stereotype.Component;

@Component
public class Helper {

    public static void validateText(String text) throws UnsupportedOperation {
        if (text == null)
            throw new UnsupportedOperation(ErrorConstants.ONLY_TEXT_SUPPORTED);
    }

}
