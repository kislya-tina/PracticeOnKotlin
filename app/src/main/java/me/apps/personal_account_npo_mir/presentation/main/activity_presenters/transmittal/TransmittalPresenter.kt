package me.apps.personal_account_npo_mir.presentation.main.activity_presenters.transmittal

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.ITransmittalView

class TransmittalPresenter: IPresenter<ITransmittalView> {

    override fun onViewCreated(view: ITransmittalView) {
        this.view = view
    }

    fun onClickHandOverButton(){
//        TransmittalDialogFragment().show(FragmentManager, TransmittalDialogFragment.TAG)
    }

    override fun onDestroy() {
        this.view = null
    }

    private var view: ITransmittalView? = null
}