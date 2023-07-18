package me.apps.personal_account_npo_mir.model.services

import me.apps.personal_account_npo_mir.model.abstractions.archive_date.IArchiveDateService

class ArchiveDateService() : IArchiveDateService {
    //model
    override var dates: List<Long>
        get() = _dates
        set(value) {
            _dates = value
        }
    var _dates: List<Long> = listOf(12, 13, 14, 15, 16, 17, 18, 19, 20)
}