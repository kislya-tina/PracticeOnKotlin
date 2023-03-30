package me.apps.personal_account_npo_mir.presentation.abstraction

interface IPresenter<TView> {

    fun onViewCreated(view : TView)

    fun onStart() {

    }

    fun onResume() {

    }

    fun onPause() {

    }

    fun onStop() {

    }

    fun onDestroy()
}