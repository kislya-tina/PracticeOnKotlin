package me.apps.personal_account_npo_mir.model.abstractions.diagnostic

interface IDiagnosticListViewItem {
    fun setCode(errorId: Int)
    fun setError(errorText: String)
    fun setImage(boolean: Boolean)
}