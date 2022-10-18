package kalix.demo.domain

import com.google.protobuf.empty.Empty
import kalix.demo
import kalix.scalasdk.valueentity.ValueEntity
import kalix.scalasdk.valueentity.ValueEntityContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class Counter(context: ValueEntityContext) extends AbstractCounter {

  override def emptyState: CounterState =
    CounterState(0)

  override def increase(currentState: CounterState, increaseValue: demo.IncreaseValue): ValueEntity.Effect[Empty] = {
    val newValue = currentState.value + increaseValue.value
    effects.updateState(CounterState(newValue)).thenReply(Empty.defaultInstance)
  }

  override def decrease(currentState: CounterState, decreaseValue: demo.DecreaseValue): ValueEntity.Effect[Empty] = {
    val newValue = currentState.value - decreaseValue.value
    effects.updateState(CounterState(newValue)).thenReply(Empty.defaultInstance)
  }

  override def reset(currentState: CounterState, resetValue: demo.ResetValue): ValueEntity.Effect[Empty] =
    effects.updateState(emptyState).thenReply(Empty.defaultInstance)

  override def getCurrentCounter(
      currentState: CounterState,
      getCounter: demo.GetCounter): ValueEntity.Effect[demo.CurrentCounter] =
    effects.reply(demo.CurrentCounter(currentState.value, context.entityId))

}
