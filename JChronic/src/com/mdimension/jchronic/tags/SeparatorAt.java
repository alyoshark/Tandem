package com.mdimension.jchronic.tags;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.mdimension.jchronic.Options;
import com.mdimension.jchronic.utils.Token;

public class SeparatorAt extends Separator {
  private static final Pattern AT_PATTERN = Pattern.compile("^(at|@)$");

  public SeparatorAt(Separator.SeparatorType type) {
    super(type);
  }

  @Override
  public String toString() {
    return super.toString() + "-at";
  }

  public static SeparatorAt scan(Token token, Options options) {
    Map<Pattern, Separator.SeparatorType> scanner = new HashMap<Pattern, Separator.SeparatorType>();
    scanner.put(SeparatorAt.AT_PATTERN, Separator.SeparatorType.AT);
    for (Pattern scannerItem : scanner.keySet()) {
      if (scannerItem.matcher(token.getWord()).matches()) {
        return new SeparatorAt(scanner.get(scannerItem));
      }
    }
    return null;
  }
}
