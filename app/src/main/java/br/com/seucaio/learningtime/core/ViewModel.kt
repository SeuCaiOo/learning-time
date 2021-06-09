package br.com.seucaio.learningtime.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//
//abstract class ViewModel<State : UIState, Action : UIAction>(
//    initialState: State
//) : androidx.lifecycle.ViewModel() {
//
//    private val disposable = CompositeDisposable()
//    val disposablesCount: Int
//        get() = disposable.size()
//
//    private val _state = MutableLiveData<State>(initialState)
//    val state: LiveData<State> = _state
//
//    private val _action = SingleLiveData<Action>()
//    val action: LiveData<Action> = _action
//
//    protected fun setState(state: (State) -> State) {
//        // As we always set a initial state and setter is private and
//        // always set a non null value, value can never be null.
//        _state.value = state(_state.value!!)
//    }
//
//    protected fun sendAction(action: () -> Action) {
//        _action.setValue(action())
//    }
//
//    protected fun Disposable.handleDisposable(): Disposable =
//        apply { disposable.add(this) }
//
//    override fun onCleared() {
//        disposable.dispose()
//        super.onCleared()
//    }
//}
