package me.apps.personal_account_npo_mir.presentation.main.activity_presenters

import me.apps.personal_account_npo_mir.di.App

class DiagnosticPresenter {

    fun setImage(boolean: Boolean){
        if(boolean){
            // TODO: cool green pic
        }
        else{
            // TODO:not cool not green red pic
        }
    }


    fun getMeterName(): String{
        return App.metersService.meters[App.indexService.index].name
    }

}