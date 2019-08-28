package com.sdei.parentIn.interfaces;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    String PARENT_DATA = "parent_data";
    @Nullable
    String CHILD_DATA="child_data";

    @NotNull
    String ID = "_id";

    @NotNull
    String FIRST_NAME = "firstName";

    @NotNull
    String LAST_NAME = "lastName";

    @NotNull
    String AUTH_TOKEN = "auth_token";

    int RESULT_CHILDREN=1001;
}
