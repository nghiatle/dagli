// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/DefaultOnNullArgument.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import com.linkedin.dagli.util.named.Named;
import java.util.Objects;


/**
 * A function class implementing DoubleFunction3.Serializable<A, B, C> that returns 0 if any of
 * the function's inputs are null.
 */
class DoubleDefaultOnNullArgument3<A, B, C> implements DoubleFunction3.Serializable<A, B, C>, Named {
  private static final long serialVersionUID = 1;
  private static final int CLASS_HASH = DoubleDefaultOnNullArgument3.class.hashCode();
  private final DoubleFunction3<A, B, C> _wrapped;

  DoubleDefaultOnNullArgument3(DoubleFunction3<A, B, C> wrapped) {
    // stacking this wrapper multiple times should be idempotent:
    if (wrapped instanceof DoubleDefaultOnNullArgument3) {
      _wrapped = ((DoubleDefaultOnNullArgument3) wrapped)._wrapped;
    } else {
      _wrapped = Objects.requireNonNull(wrapped);
    }
  }

  @Override
  public DoubleDefaultOnNullArgument3<A, B, C> safelySerializable() {
    return new DoubleDefaultOnNullArgument3<>(((DoubleFunction3.Serializable<A, B, C>) _wrapped).safelySerializable());
  }

  @Override
  public double apply(A value1, B value2, C value3) {
    if (value1 == null || value2 == null || value3 == null) {
      return 0;
    }
    return _wrapped.apply(value1, value2, value3);
  }

  @Override
  public int hashCode() {
    return CLASS_HASH + _wrapped.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DoubleDefaultOnNullArgument3) {
      return this._wrapped.equals(((DoubleDefaultOnNullArgument3) obj)._wrapped);
    }
    return false;
  }

  @Override
  public String toString() {
    return "arg == null ? 0 : " + Named.getName(_wrapped);
  }

  @Override
  public String getShortName() {
    return "arg == null ? 0 : " + Named.getShortName(_wrapped);
  }
}
