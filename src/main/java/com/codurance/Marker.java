package com.codurance;


public class Marker {

  public final Character mark;

  public Marker(Character mark) {
    this.mark = mark;
  }

  public boolean isEmpty(){
    return mark == '\0';
  }

  public boolean equals(Marker other) {
    return this.mark == other.mark;
  }
}
