package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public long dateToLong(Date date) {
        return date.getTime();
    }

    @TypeConverter
    public Date longToDate(long time) {
        return new Date(time);
    }
}
