package com.codurance;


public class Marker {

  public final Character mark;

  public Marker(){
    this('\0');
  }

  public Marker(Character mark) {
    this.mark = mark;
  }

  public boolean isEmpty(){
    return mark == '\0';
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Marker))
      return false;
    return ((Marker) other).mark == this.mark;
  }
}
