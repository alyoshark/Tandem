package com.mdimension.jchronic.handlers;

import java.util.Calendar;
import java.util.List;

import com.mdimension.jchronic.Options;
import com.mdimension.jchronic.repeaters.Repeater;
import com.mdimension.jchronic.tags.Ordinal;
import com.mdimension.jchronic.tags.Pointer;
import com.mdimension.jchronic.utils.Span;
import com.mdimension.jchronic.utils.Time;
import com.mdimension.jchronic.utils.Token;

public abstract class ORRHandler implements IHandler {
  public Span handle(List<Token> tokens, Span outerSpan, Options options) {
    Repeater<?> repeater = tokens.get(1).getTag(Repeater.class);
    repeater.setStart(Time.cloneAndAdd(outerSpan.getBeginCalendar(), Calendar.SECOND, -1));
    Integer ordinalValue = tokens.get(0).getTag(Ordinal.class).getType();
    Span span = null;
    for (int i = 0; i < ordinalValue.intValue(); i++) {
      span = repeater.nextSpan(Pointer.PointerType.FUTURE);
      if (span.getBegin() > outerSpan.getEnd()) {
        span = null;
        break;
      }
    }
    return span;
  }
}
