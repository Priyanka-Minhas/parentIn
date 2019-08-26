package com.sdei.parentIn.interfaces;

import org.jetbrains.annotations.NotNull;

public interface InterConst {

    @NotNull
    String ROLE_ID = "role_id";

    int ROLE_PARENT = 2;
    int ROLE_TEACHER = 3;
    int ROLE_SUPERVISOR = 4;

    int CODE_SUCCESS = 200;
    int CODE_ERROR = 404;
    int CODE_WARNING = 303;

    @NotNull
    String EXTRA_DATA = "extra_data";

    int RESULT_CREATE_ACCOUNT = 100;

    @NotNull
    String ID = "_id";
    @NotNull
    String FIRST_NAME = "firstName";
    @NotNull
    String LAST_NAME = "lastName";
}
