package edu.byui_cs.jjmn.ponderize;

/**
 * Created by James Palmer on 22-Feb-17.
 */

public class ScriptureContainer {
  private String _book;
  private int _chapter;
  private int _verse;

  public ScriptureContainer(String _book, int _chapter, int _verse) {
    this._book = _book;
    this._chapter = _chapter;
    this._verse = _verse;
  }

  public String getBook() {
    return _book;
  }

  public void setBook(String book) {
    this._book = book;
  }

  public int getChapter() {
    return _chapter;
  }

  public void setChapter(int chapter) {
    this._chapter = chapter;
  }

  public int getVerse() {
    return _verse;
  }

  public void setVerse(int verse) {
    this._verse = verse;
  }

  @Override
  public String toString() {
    return _book + ' ' + _chapter + ':' + _verse;
  }
}
