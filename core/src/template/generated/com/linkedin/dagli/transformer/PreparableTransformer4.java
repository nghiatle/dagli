// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the transformer/PreparableTransformerX.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.transformer;

import com.linkedin.dagli.dag.DAG;
import com.linkedin.dagli.dag.DAG4x1;
import com.linkedin.dagli.dag.SimpleDAGExecutor;
import com.linkedin.dagli.preparer.PreparerContext;
import com.linkedin.dagli.preparer.PreparerResultMixed;
import com.linkedin.dagli.placeholder.Placeholder;
import com.linkedin.dagli.transformer.internal.PreparableTransformer4InternalAPI;
import com.linkedin.dagli.util.collection.Iterables;


public interface PreparableTransformer4<A, B, C, D, R, N extends PreparedTransformer4<A, B, C, D, R>> extends
    Transformer4<A, B, C, D, R>, PreparableTransformer<R, N> {

  @Override
  PreparableTransformer4InternalAPI<A, B, C, D, R, N, ? extends PreparableTransformer4<A, B, C, D, R, N>> internalAPI();

  /**
   * Casts a preparable transformer to a "supertype".  This cast is safe due to the semantics of preparable
   * transformers.
   *
   * @param preparable the preparable transformer to cast
   * @param <A> the new type of input #1
   * @param <B> the new type of input #2
   * @param <C> the new type of input #3
   * @param <D> the new type of input #4
   * @param <R> the new result type
   * @param <N> the new prepared transformer type
   * @return the provided {@code preparable}, cast to the desired "supertype"
   */
  @SuppressWarnings("unchecked")
  static <A, B, C, D, R, N extends PreparedTransformer4<A, B, C, D, R>> PreparableTransformer4<A, B, C, D, R, N> cast(
      PreparableTransformer4<? super A, ? super B, ? super C, ? super D, ? extends R, ? extends N> preparable) {
    // safe due to semantics of preparable transformers:
    return (PreparableTransformer4<A, B, C, D, R, N>) preparable;
  }

  /**
   * Casts a preparable transformer to a "supertype" with an unknown type of prepared transformer.  This cast is safe
   * due to the semantics of preparable transformers.
   *
   * @param preparable the preparable transformer to cast
   * @param <A> the new type of input #1
   * @param <B> the new type of input #2
   * @param <C> the new type of input #3
   * @param <D> the new type of input #4
   * @param <R> the new result type
   * @return the provided {@code preparable}, cast to the desired "supertype"
   */
  @SuppressWarnings("unchecked")
  static <A, B, C, D, R> PreparableTransformer4<A, B, C, D, R, PreparedTransformer4<A, B, C, D, R>> castWithGenericPrepared(
      PreparableTransformer4<? super A, ? super B, ? super C, ? super D, ? extends R, ?> preparable) {
    // safe due to semantics of preparable transformers:
    return (PreparableTransformer4<A, B, C, D, R, PreparedTransformer4<A, B, C, D, R>>) preparable;
  }

  /**
   * Prepares a preparable transformer and returns the result (which includes the prepared transformer for both the
   * "preparation" data (in this case, the values passed to this method) and "new" data.
   *
   * @param preparable the transformer to prepare
   * @param values1 the values for the first input to the transformer for each example
   * @param values2 the values for the second input to the transformer for each example
   * @param values3 the values for the third input to the transformer for each example
   * @param values4 the values for the fourth input to the transformer for each example
   * @param <A> the type of the first input
   * @param <B> the type of the second input
   * @param <C> the type of the third input
   * @param <D> the type of the fourth input
   * @param <R> the type of the result of the prepared transformers
   * @param <N> the type of the prepared transformer ("for new data")
   * @return a {@link PreparerResultMixed} containing the prepared transformers for "preparation data" (the provided
   *         values)
   */
  @SuppressWarnings("unchecked")
  static <A, B, C, D, R, N extends PreparedTransformer4<A, B, C, D, R>> PreparerResultMixed<PreparedTransformer4<A, B, C, D, R>, N> prepare(
      PreparableTransformer4<A, B, C, D, R, N> preparable, Iterable<? extends A> values1,
      Iterable<? extends B> values2, Iterable<? extends C> values3, Iterable<? extends D> values4) {
    return (PreparerResultMixed<PreparedTransformer4<A, B, C, D, R>, N>) preparable.internalAPI().prepare(
        PreparerContext.builder(Iterables.size64(values1)).setExecutor(new SimpleDAGExecutor()).build(), values1,
        values2, values3, values4);
  }

  /**
   * Creates a trivial DAG that wraps the provided transformer, with the DAG retaining the transformer's existing
   * inputs or, if the transformer is already a DAG, simply returns it unaltered.
   *
   * @param transformer the transformer to wrap
   * @param <A> the type of transformer input #1
   * @param <B> the type of transformer input #2
   * @param <C> the type of transformer input #3
   * @param <D> the type of transformer input #4
   * @param <R> the type of result produced by the transformer
   * @return a trivial DAG that wraps the provided transformer, or the transformer itself if it is already a DAG
   */
  @SuppressWarnings("unchecked")
  static <A, B, C, D, R> DAG4x1<A, B, C, D, R> toDAG(PreparableTransformer4<A, B, C, D, R, ?> transformer) {
    if (transformer instanceof DAG4x1) {
      return (DAG4x1<A, B, C, D, R>) transformer;
    }

    Placeholder<A> placeholder1 = new Placeholder<>("Input #1");
    Placeholder<B> placeholder2 = new Placeholder<>("Input #2");
    Placeholder<C> placeholder3 = new Placeholder<>("Input #3");
    Placeholder<D> placeholder4 = new Placeholder<>("Input #4");
    return DAG
        .withPlaceholders(placeholder1, placeholder2, placeholder3, placeholder4)
        .withNoReduction()
        .withOutput(transformer.internalAPI().withInputs(placeholder1, placeholder2, placeholder3, placeholder4))
        .withAllInputs(transformer.internalAPI().getInput1(), transformer.internalAPI().getInput2(),
            transformer.internalAPI().getInput3(), transformer.internalAPI().getInput4());
  }
}
