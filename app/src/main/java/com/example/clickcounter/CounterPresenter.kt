package com.example.clickcounter

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import moxy.MvpPresenter
import moxy.MvpView

class CounterPresenter(private val model: CounterModel, private val view: CounterView, private val router: Router) :
    MvpPresenter<CounterView>() {

    fun onCountPressed() {
        model.increment()
        viewState.setCount(model.data.toString())
    }

//    fun onOpenNewScreen() {
//         router.navigateTo(Screens.)
//    }
//
//    fun onBackPressed() {
//        router.exit()
//    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setCount(model.data.toString())
        viewState.setInc(model.valueIncrement.toString())
    }

//    class Base @Inject(private val model: CounterModel, private val view: CounterView): CounterPresenter, MvpPresenter<MvpView>(){ //базовая реализация интерфейса
//
//        init {
//            view.setInc(model.valueIncrement.toString())
//        }
//
//        override fun onCountPressed() {
//            model.increment()
//            view.setCount(model.data.toString())
//        }
//    }
}


