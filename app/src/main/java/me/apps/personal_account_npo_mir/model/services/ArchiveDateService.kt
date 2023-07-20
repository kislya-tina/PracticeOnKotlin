package me.apps.personal_account_npo_mir.model.services

import me.apps.personal_account_npo_mir.model.abstractions.archive_date.IArchiveDateService

class ArchiveDateService() : IArchiveDateService {
    override var dates: List<Long>
        get() = _dates
        set(value) {
            _dates = value
        }

    override var datesCount: Int
        get() = _datesCount
        set(value) {
            _datesCount = value
        }



    var _dates: List<Long> = listOf(12, 13, 14, 15, 16, 17, 18, 19, 20)
    var _datesCount: Int = 0
}