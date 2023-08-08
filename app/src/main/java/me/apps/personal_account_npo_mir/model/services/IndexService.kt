package me.apps.personal_account_npo_mir.model.services

import me.apps.personal_account_npo_mir.model.abstractions.index.IIndexService

class IndexService: IIndexService {
    override var index: Int
        get() = _index
        set(value) {
            _index = value
        }

    private var _index = 0
}