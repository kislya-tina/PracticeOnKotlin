package me.apps.personal_account_npo_mir.view.abstractions.main

interface ITransmittalView {
    fun showDialog()

    fun setSummaryBackground(resourceID : Int)

    fun setTariff1Background(resourceID : Int)

    fun setTariff2Background(resourceID : Int)

    fun setTariff3Background(resourceID : Int)

    fun setTariff4Background(resourceID : Int)

    fun reactToMeasures()
}