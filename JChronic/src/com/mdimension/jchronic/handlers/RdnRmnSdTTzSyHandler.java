package com.mdimension.jchronic.handlers;

import java.util.Calendar;
import java.util.List;

import com.mdimension.jchronic.Options;
import com.mdimension.jchronic.repeaters.RepeaterMonthName;
import com.mdimension.jchronic.tags.ScalarDay;
import com.mdimension.jchronic.tags.ScalarYear;
import com.mdimension.jchronic.utils.Span;
import com.mdimension.jchronic.utils.Time;
import com.mdimension.jchronic.utils.Token;

public class RdnRmnSdTTzSyHandler implements IHandler {

  public Span handle(List<Token> tokens, Options options) {
    int month = tokens.get(1).getTag(RepeaterMonthName.class).getType().ordinal();
    int day = tokens.get(2).getTag(ScalarDay.class).getType().intValue();
    int year = tokens.get(5).getTag(ScalarYear.class).getType().intValue();

    Span span;
    try {
      List<Token> timeTokens = tokens.subList(3, 4);
      Calendar dayStart = Time.construct(year, month, day);
      span = Handler.dayOrTime(dayStart, timeTokens, options);
    }
    catch (IllegalArgumentException e) {
      if (options.isDebug()) {
        e.printStackTrace(System.out);
      }
      span = null;
    }
    return span;
  }
}
