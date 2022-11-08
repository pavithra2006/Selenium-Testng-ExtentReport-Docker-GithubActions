package com.learning.enums;

public enum WaitStrategy {
    CLICKABLE,
    VISIBLE,
    PRESCENCE,
    NONE;   // for example if we have already waited for user name , no need to wait for login button
}
