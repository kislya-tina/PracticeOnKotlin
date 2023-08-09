package me.apps.personal_account_npo_mir.model.services

import me.apps.personal_account_npo_mir.model.abstractions.archive_date.IArchiveDateService
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure

class ArchiveDateService() : IArchiveDateService {
    override var dates:List<String> = mutableListOf<String>()


    override var datesCount: Int
        get() = _datesCount
        set(value) {
            _datesCount = value
        }

    override var currentClickedDate: Int
        get() = _currentClickedDate
        set(value) {
            _currentClickedDate = value
        }
    override var arrayOfMeasures:Array<Measure> = arrayOf()
    var _dates: List<String> = listOf()
    var _datesCount: Int = 0
    var _currentClickedDate = 0
}