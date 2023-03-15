package me.apps.personal_account_npo_mir.model.abstractions.meters

interface IMetersService {
    /**
     * Получить счетчики пользователя
     * @param username Имя пользователя
     */
    fun getMeters(username: String) : List<Meter>
}