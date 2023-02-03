package Tree;

// import Temp.Temp;
// import Temp.Label;

public class SEQ extends Stm {
  protected Stm left, right;

  public SEQ(Stm l, Stm r) {
    if (l == null)
      throw new Error("left statement in sequence is null");
    left = l;
    if (r == null)
      throw new Error("right statement in sequence is null");
    right = r;
  }

  // following added for convenience for long chains
  public SEQ(Stm s1, Stm s2, Stm s3) {
    this(s1, new SEQ(s2, s3));
  }

  public SEQ(Stm s1, Stm s2, Stm s3, Stm s4) {
    this(s1, s2, new SEQ(s3, s4));
  }

  public SEQ(Stm s1, Stm s2, Stm s3, Stm s4, Stm s5) {
    this(s1, s2, s3, new SEQ(s4, s5));
  }

  public SEQ(Stm s1, Stm s2, Stm s3, Stm s4, Stm s5, Stm s6) {
    this(s1, s2, s3, s4, new SEQ(s5, s6));
  }

  public SEQ(Stm s1, Stm s2, Stm s3, Stm s4, Stm s5, Stm s6, Stm s7) {
    this(s1, s2, s3, s4, s5, new SEQ(s6, s7));
  }

  public SEQ(Stm s1, Stm s2, Stm s3, Stm s4, Stm s5, Stm s6, Stm s7, Stm s8) {
    this(s1, s2, s3, s4, s5, s6, new SEQ(s7, s8));
  }

  public SEQ(Stm s1, Stm s2, Stm s3, Stm s4, Stm s5, Stm s6, Stm s7, Stm s8,
             Stm s9) {
    this(s1, s2, s3, s4, s5, s6, s7, new SEQ(s8, s9));
  }

  public SEQ(Stm s1, Stm s2, Stm s3, Stm s4, Stm s5, Stm s6, Stm s7, Stm s8,
             Stm s9, Stm s10) {
    this(s1, s2, s3, s4, s5, s6, s7, s8, new SEQ(s9, s10));
  }

  public SEQ(Stm s1, Stm s2, Stm s3, Stm s4, Stm s5, Stm s6, Stm s7, Stm s8,
             Stm s9, Stm s10, Stm s11) {
    this(s1, s2, s3, s4, s5, s6, s7, s8, s9, new SEQ(s10, s11));
  }

  public SEQ(Stm s1, Stm s2, Stm s3, Stm s4, Stm s5, Stm s6, Stm s7, Stm s8,
             Stm s9, Stm s10, Stm s11, Stm s12) {
    this(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, new SEQ(s11, s12));
  }

  static protected SEQ reverse(Stm stmt, SEQ result) {
    if (stmt == null || !(stmt instanceof SEQ))
      return result;
    else {
      SEQ s = (SEQ) stmt;
      if (s == null)
        throw new Error("Unexpected null after typecast to SEQ");
      if (s.getRight() == null)
        throw new Error("statement .right is null");
      if (s.getLeft() == null)
        throw new Error("statement .left is null");
      return reverse(s.getRight(), new SEQ(s.getLeft(), result));
    }
  }

  public Stm getLeft() {
    return left;
  }

  public Stm getRight() {
    return right;
  }

  public ExpList kids() {
    throw new Error("kids() not applicable to SEQ");
  }

  public Stm build(ExpList kids) {
    throw new Error("build() not applicable to SEQ");
  }

  // return current sequence in reverse
  public SEQ reverse() {
    if (getLeft() == null || !(getLeft() instanceof SEQ))
      return this;
    else
      return reverse(getRight(), (SEQ) getLeft());
  }
}
