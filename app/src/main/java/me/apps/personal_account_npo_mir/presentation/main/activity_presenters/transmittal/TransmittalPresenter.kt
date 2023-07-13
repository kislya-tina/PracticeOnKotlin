package me.apps.personal_account_npo_mir.presentation.main.activity_presenters.transmittal

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.ITransmittalView
import me.apps.personalaccountnpomir.R

class TransmittalPresenter: IPresenter<ITransmittalView> {

    override fun onViewCreated(view: ITransmittalView) {
        this.view = view
    }

    fun onClickHandOverButton(){
//        var success = true
//        if (login.isBlank()){
//            success = false
//            view?.setSummaryBackground(R.drawable.ic_warning_frame)
//        } else {
//            view?.setLoginBackground(R.drawable.rectangle_reg)
//        }
//        if (password.isBlank()){
//            success = false
//            view?.setPasswordBackground(R.drawable.ic_warning_frame)
//        } else {
//            view?.setPasswordBackground(R.drawable.rectangle_reg)
//        }
//
//        if (email.isBlank()){
//            success = false
//            view?.setEmailBackground(R.drawable.ic_warning_frame)
//        } else {
//            view?.setEmailBackground(R.drawable.rectangle_reg)
//        }
//
//        if (phone.isBlank()){
//            success = false
//            view?.setPhoneBackground(R.drawable.ic_warning_frame)
//        } else {
//            view?.setPhoneBackground(R.drawable.rectangle_reg)
//        }
//
//        if(success){
//
//        }
    }

    override fun onDestroy() {
        this.view = null
    }

    private var view: ITransmittalView? = null
}