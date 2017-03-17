package edu.byui_cs.jjmn.ponderize;

/**
 * Created by James Palmer on 22-Feb-17.
 */

public class ScriptureContainer {
  private String _book;
  private int _chapter;
  
  private int _verse;
  private String _text;
  private boolean _isCompleted;
  
  /**
   * Default constructor does nothing with initializing fields
   */
  public ScriptureContainer () {
  }
  
  /**
   * Nondefault constructor
   *
   * @param book  Book of reference
   * @param chapter chapter of reference
   * @param verse verse of reference
   */
  public ScriptureContainer (String book, int chapter, int verse) {
    this._book = book;
    this._chapter = chapter;
    this._verse = verse;
    this._isCompleted = false;
  }
  
  public String getBook () {
    return _book;
  }
  
  public void setBook (String book) {
    this._book = book;
  }
  
  public int getChapter () {
    return _chapter;
  }
  
  public void setChapter (int chapter) {
    this._chapter = chapter;
  }
  
  public String getText () {
    return _text;
  }
  
  public boolean getCompleted () {
    return _isCompleted;
  }
  
  public void setVerse (int verse) {
    this._verse = verse;
  }
  
  public int getVerse () {
    return _verse;
  }
  
  public void setText (String _text) {
    this._text = _text;
  }
  
  public void setCompleted () {
    _isCompleted = true;
  }
  
  /**
   * Formatte scripture reference
   *
   * @return Formatted string object of object reference
   */
  public String getReference () {
    return _book + ' ' + _chapter + ':' + _verse;
  }
}
