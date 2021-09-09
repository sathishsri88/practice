package com.leetcode.stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class IsValidParantheses {
  //  private static final List<Bracket> openBraces =
  //      Arrays.<Bracket>asList(new Bracket('(', 1),
  //                             new Bracket('[', 2),
  //                             new Bracket('{', 3));
  //  private static final List<Bracket> closedBraces =
  //      Arrays.<Bracket>asList(new Bracket(')', 1),
  //                             new Bracket(']', 2),
  //                             new Bracket('}', 3));
  private static final Map<Character, Character> openBraces = new HashMap<>();
  private static final Map<Character, Character> closedBraces = new HashMap<>();

  static {
    openBraces.put('(', ')');
    openBraces.put('[', ']');
    openBraces.put('{', '}');
    closedBraces.put(')', '(');
    closedBraces.put(']', '[');
    closedBraces.put('}', '{');
  }

  private boolean isValid(String s) {
    final Stack<Character> paranthesesStack = new Stack<>();
    for (Character character : s.toCharArray()) {
      if (openBraces.containsKey(character)) paranthesesStack.push(character);
      else if (closedBraces.containsKey(character)) {
        if (!paranthesesStack.isEmpty() && openBraces.get(paranthesesStack.peek()) == character)
          paranthesesStack.pop();
        else return false;
      }
    }
    return true;
  }

  @Test
  public void testIsValid() {
    System.out.println(isValid("()"));
    System.out.println(isValid("())"));
    System.out.println(isValid("()[]{}"));
    System.out.println(isValid("(]"));
  }

  private static class Bracket {
    private final Character bracketType;
    private final int identifier;

    public Bracket(Character bracketType, int identifier) {
      this.bracketType = bracketType;
      this.identifier = identifier;
    }

    public Character getBracketType() {
      return bracketType;
    }

    public int getIdentifier() {
      return identifier;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Bracket bracket = (Bracket) o;
      return Objects.equals(bracketType, bracket.bracketType);
    }

    @Override
    public int hashCode() {
      return Objects.hash(bracketType);
    }
  }
}
