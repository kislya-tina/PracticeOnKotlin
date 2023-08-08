package me.apps.personal_account_npo_mir.model.server_connect

enum class ErrorCode(val description: String) {
    BLANK_USERNAME("Username is blank"),
    BLANK_PASSWORD("Password is blank"),
    BLANK_URL("URL is blank"),
    WRONG_URL("URL is wrong"),
    INPUT_EMPTY("Input empty"),
    LOGIN_ERROR("Login error"),
    USER_EXIST("User with the same name already exists"),
    BLANK_TOKEN("Token is empty"),
    BLANK_METER_ID("Meter Id is empty"),
    IOEXCEPTION("There is IOEXCEPTION");
}