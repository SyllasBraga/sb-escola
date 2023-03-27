package sb.escola.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringParaDate {

    public Date converter(String data) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formato.parse(data);
        return date;
    }

}
