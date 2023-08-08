package me.apps.personal_account_npo_mir.view.abstractions.main

import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure

interface IOnDateArchiveView {
    fun setMeasure(measure: Measure)

    fun setHeader(header : String)

    fun getPosition() : Int
}