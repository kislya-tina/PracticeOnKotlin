package me.apps.personal_account_npo_mir.model.abstractions.archive_date

interface IArchiveDateService {
    var dates: List<String>
    var datesCount: Int
    var currentClickedDate: Int
}