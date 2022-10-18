package kalix.demo.views

import kalix.demo.CurrentCounter
import kalix.demo.domain.CounterState
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class CountersByValueView(context: ViewContext) extends AbstractCountersByValueView {

  override def emptyState: CurrentCounter = null

  override def onUpdate(state: CurrentCounter, counterState: CounterState): UpdateEffect[CurrentCounter] =
    effects.updateState(CurrentCounter(counterState.value, updateContext().eventSubject.get))
}
