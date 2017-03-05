package com.mingyuans.smoke;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Formatter;
import java.util.regex.Pattern;

/**
 * Created by yanxq on 17/3/2.
 */

class StringUtil {

    public static String toString(Object arg) {
        String message = "";
        if (arg == null) {
            message = "null";
        } else if (arg instanceof Object[]) {
            message = array2String((Object[]) arg);
        } else if (arg instanceof Collection) {
            Collection collection = (Collection)arg;
            StringBuilder builder = new StringBuilder("[");
            for (Object child: collection) {
                builder.append(String.valueOf(child));
                builder.append(",");
            }
            if (collection.size() > 0) {
                builder.deleteCharAt(builder.length()-1);
            }
            builder.append("]");
            message = builder.toString();
        } else {
            message = String.valueOf(arg);
        }
        return message;
    }

    public static String array2String(Object[] arrayObject) {
        String message = "";
        if (arrayObject == null) {
            return message;
        }

        StringBuilder builder = new StringBuilder("[");
        int length = arrayObject.length;
        for (int i=0; i < length; i++) {
            builder.append(toString(arrayObject[i]));
            if (i == (length-1)) {
                builder.append("]");
            } else {
                builder.append(",");
            }
        }
        return builder.toString();
    }

    public static String format(String message, Object... args) {
        if (message.contains("{0}")) {
            String[] strObjects = new String[0];
            if (args != null && args.length > 0) {
                strObjects = new String[args.length];
                for (int i = 0, length = args.length; i < length; i++) {
                    strObjects[i] = toString(args[i]);
                }
            }
            return MessageFormat.format(message, strObjects);
        } else {
            return String.format(message,args);
        }
    }
}