package me.apps.personal_account_npo_mir.model.server_connect

enum class ErrorCode(val description: String) {
    BLANK_USERNAME("username is blank"),
    BLANK_PASSWORD("password is blank"),
    BLANK_URL("URL is blank"),
    LOGIN_ERROR("login error"),
    USER_EXIST("User with the same name already exists");

}