package com.emse.spring.faircorp.hello;

import java.util.List;

public interface WindowDaoCustom {
    List<Window> findRoomOpenWindows(Long id);
}